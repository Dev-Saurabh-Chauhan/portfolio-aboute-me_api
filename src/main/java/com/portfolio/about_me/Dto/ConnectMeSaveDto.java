package com.portfolio.about_me.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ConnectMeSaveDto {
    @NotBlank(message = "Connection Name cannot be blank")
    @Size(max = 100, message = "Connection Name exceed 100 characters")
    private int connectionName;
    @NotBlank(message = "Link cannot be blank")
    @Size(max = 255, message = "Link exceed 100 characters")
    private String link;

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
