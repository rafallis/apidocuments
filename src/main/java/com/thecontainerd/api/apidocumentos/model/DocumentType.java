package com.thecontainerd.api.apidocumentos.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentType {
    
    private String type;

    public DocumentType(String type) {
        this.type = type;
    }
}
