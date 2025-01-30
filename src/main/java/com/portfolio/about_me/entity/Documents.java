package com.portfolio.about_me.entity;

import jakarta.persistence.*;

@Entity
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false ,length = 30)
    private String document_name;
    @Column(nullable = false,length = 30)
    private String document_type;
    @Column(nullable = false,length = 255)
    private String document_file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocument_name() {
        return document_name;
    }

    public void setDocument_name(String document_name) {
        this.document_name = document_name;
    }

    public String getDocument_type() {
        return document_type;
    }

    public void setDocument_type(String document_type) {
        this.document_type = document_type;
    }

    public String getDocument_file() {
        return document_file;
    }

    public void setDocument_file(String document_file) {
        this.document_file = document_file;
    }
}
