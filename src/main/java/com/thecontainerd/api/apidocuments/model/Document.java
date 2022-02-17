package com.thecontainerd.api.apidocuments.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    private String ext;
    @Lob
    private byte[] data;
    private int documentTypeId;

    public Document(String name, String ext, byte[] data, int documentTypeId) {
        this.name = name;
        this.ext = ext;
        this.data = data;
        this.documentTypeId = documentTypeId;
    }
}
