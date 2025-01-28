package com.portfolio.about_me.entity;
import jakarta.persistence.*;

@Entity
public class ConnectMe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false, unique = true)
    private int connectionName;
    private String link;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConnectionName() {
        return connectionName;
    }

    public void setConnectionName(int connectionName) {
        this.connectionName = connectionName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
