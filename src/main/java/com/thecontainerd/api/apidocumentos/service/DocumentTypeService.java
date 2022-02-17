package com.thecontainerd.api.apidocumentos.service;

import java.util.stream.Stream;

import com.thecontainerd.api.apidocumentos.model.DocumentType;
import com.thecontainerd.api.apidocumentos.repository.DocumentTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeService {

    @Autowired
    DocumentTypeRepository repository;

    public Stream<DocumentType> getAll() {
        return repository.findAll().stream();
    }

    public DocumentType getDocumentType(int documentTypeId) {
        return repository.getById(documentTypeId);
    }
}
