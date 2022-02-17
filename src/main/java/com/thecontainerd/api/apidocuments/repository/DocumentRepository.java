package com.thecontainerd.api.apidocuments.repository;

import com.thecontainerd.api.apidocuments.model.Document;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, String> {
    
}
