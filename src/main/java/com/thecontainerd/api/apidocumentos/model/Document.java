package com.thecontainerd.api.apidocumentos.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Document {
    private String name;
    private String url;
    private String extension;

    public Document(String name, String url, String extension) {
        this.name = name;
        this.url = url;
        this.extension = extension;
    }
}
