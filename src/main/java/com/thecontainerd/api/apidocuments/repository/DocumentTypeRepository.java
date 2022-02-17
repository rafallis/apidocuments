package com.thecontainerd.api.apidocuments.repository;

import com.thecontainerd.api.apidocuments.model.DocumentType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Integer> {
    
}
