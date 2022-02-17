package com.thecontainerd.api.apidocumentos.repository;

import com.thecontainerd.api.apidocumentos.model.DocumentType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
    
}
