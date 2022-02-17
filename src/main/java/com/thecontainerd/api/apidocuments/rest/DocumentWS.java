package com.thecontainerd.api.apidocuments.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import java.util.stream.Collectors;

import com.thecontainerd.api.apidocuments.helper.ResponseDocument;
import com.thecontainerd.api.apidocuments.helper.ResponseMessage;
import com.thecontainerd.api.apidocuments.model.Document;
import com.thecontainerd.api.apidocuments.rabbitmq.QueueSender;
import com.thecontainerd.api.apidocuments.service.DocumentDBStorageService;
import com.thecontainerd.api.apidocuments.service.DocumentTypeService;
import com.thecontainerd.api.apidocuments.service.LocalStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin("http://localhost:8081")
public class DocumentWS {

    @Autowired
    LocalStorageService localStorageService;

    @Autowired
    DocumentDBStorageService dbStorageService;

    @Autowired
    DocumentTypeService docTypeService;

    @Autowired
    private QueueSender queueSender;

    @PostMapping(value = "/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("doc") MultipartFile doc,
            @RequestParam("type") int typeId) {

        String message = "";

        try {
            String docId = dbStorageService.store(doc, typeId).getId().toString();
            localStorageService.save(doc);
            message = "Uploaded -> " + doc.getOriginalFilename() + " // Doc Type -> " + doc.getContentType();

            queueSender.send("Document: " + docId + " STORED");

            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Error uploading doc " + doc.getOriginalFilename() + ".";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping(value = "/docs")
    public ResponseEntity<List<ResponseDocument>> getDocumentList() {

        List<ResponseDocument> docs = dbStorageService.getAllFiles().map(doc -> {
            String url = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/docs/")
                    .path(doc.getId())
                    .toUriString();

            return new ResponseDocument(
                    doc.getName(),
                    url,
                    doc.getExt(),
                    docTypeService.getDocumentType(doc.getDocumentTypeId()).getName(),
                    doc.getData().length);
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(docs);
    }

    @GetMapping(value = "/docs/{id}")
    public ResponseEntity<byte[]> getDocument(@PathVariable String id) {
        Document doc = dbStorageService.getDocument(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + doc.getName() + "\"")
                .body(doc.getData());
    }

    @GetMapping(value = "/types")
    public ResponseEntity<List<String>> getDocumentTypeList() {
        List<String> docTypelist = docTypeService.getAll().map(type -> {
            return new String(type.getName());
        }).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(docTypelist);
    }
}
