package com.thecontainerd.api.apidocuments.helper;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Getter
@Setter
@NoArgsConstructor
public class ResponseDocument {

    private String id;
    private String name;
    private String url;
    private String ext;
    private String documentType;
    private long size;

    public ResponseDocument(String id, String name, String url, String ext, String documentType, long size) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.ext = ext;
        this.documentType = documentType;
        this.size = size;
    }

}
