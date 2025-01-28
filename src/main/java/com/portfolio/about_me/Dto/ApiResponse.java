package com.portfolio.about_me.Dto;

public class ApiResponse<T> {
    public  int status;
    public T data;
    public String message;

    public ApiResponse(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }
}
