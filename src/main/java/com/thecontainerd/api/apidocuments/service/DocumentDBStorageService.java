package com.thecontainerd.api.apidocuments.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.stream.Stream;

import com.thecontainerd.api.apidocuments.model.Document;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentDBStorageService {

    public Document store(MultipartFile file, int typeId) throws IOException;

    public Document getDocument(String id);

    public Stream<Document> getAllFiles();

    public void deleteDocumentById(String docId) throws SQLException;
}
