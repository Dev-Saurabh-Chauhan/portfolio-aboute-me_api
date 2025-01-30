package com.portfolio.about_me.Dto;

public class DocumentPayloadDTO {
    String document_name;
    String document_file;
    String document_type;

    public String getDocument_type() {

        return document_type;
    }
    public void setDocument_type(String document_type) {

        this.document_type = document_type;
    }

    public String getDocument_name() {

        return document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
    }

    public String getDocument_file() {

        return document_file;
    }

    public void setDocument_file(String document_file) {
        this.document_file = document_file;
    }
}
