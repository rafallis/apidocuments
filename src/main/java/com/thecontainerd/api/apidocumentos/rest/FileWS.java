package com.thecontainerd.api.apidocumentos.rest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.thecontainerd.api.apidocumentos.helper.ResponseMessage;
import com.thecontainerd.api.apidocumentos.model.Document;
import com.thecontainerd.api.apidocumentos.service.StorageService;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RestController
@CrossOrigin("http://localhost:8081")
public class FileWS {

    @Autowired
    StorageService storageService;

    @PostMapping(value = "/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {

        String message = "";

        try {
            storageService.save(file);
            message = "Uploaded -> " + file.getOriginalFilename() + " // Tipo arquivo -> " + file.getContentType();
            log.info(message);
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Error uploading file " + file.getOriginalFilename() + ".";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @GetMapping(value = "/files")
    public ResponseEntity<List<Document>> getFileList() {
        List<Document> files = storageService.loadAll().map(path -> {
            String fileName = path.getFileName().toString();
            String url = MvcUriComponentsBuilder.fromMethodName(FileWS.class, "getFile", path.getFileName().toString())
                    .build().toString();
            String extension = FilenameUtils.getExtension(fileName);
            return new Document(fileName, url, extension);
        }).collect(Collectors.toList());
        log.info(files.toString());
        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping(value = "/files/{fileName:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
        Resource file = storageService.load(fileName);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
