package com.registrapp.models;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

public class File {

    private MultipartFile file;

    private String description;

    private String name;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
