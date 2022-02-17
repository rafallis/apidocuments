package com.thecontainerd.api.apidocumentos.repository;

import com.thecontainerd.api.apidocumentos.model.Document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
    
}
