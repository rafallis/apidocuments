package com.thecontainerd.api.apidocumentos.service;

import java.io.IOException;
import java.util.stream.Stream;

import com.thecontainerd.api.apidocumentos.model.Document;

import org.springframework.web.multipart.MultipartFile;

public interface DocumentDBStorageService {

    public Document store(MultipartFile file, int typeId) throws IOException;

    public Document getDocument(String id);

    public Stream<Document> getAllFiles();
}
