package com.example.backend.dto;

public class MakeAdminRequest {
    int userId;

    public MakeAdminRequest(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
