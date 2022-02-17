package com.thecontainerd.api.apidocuments.service;

import java.io.IOException;
import java.util.stream.Stream;

import com.thecontainerd.api.apidocuments.model.Document;
import com.thecontainerd.api.apidocuments.repository.DocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class DocumentDBStorageServiceImpl implements DocumentDBStorageService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document store(MultipartFile file, int typeId) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Document doc = new Document(fileName, file.getContentType(), file.getBytes(), typeId);
        return documentRepository.save(doc);
    }

    public Document getDocument(String id) {
        return documentRepository.findById(id).get();
    }

    public Stream<Document> getAllFiles() {
        return documentRepository.findAll().stream();
    }
}
