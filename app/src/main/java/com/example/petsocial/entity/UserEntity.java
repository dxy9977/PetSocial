package com.example.petsocial.entity;

public class UserEntity {

    /**
     * token : oU6G-buESrNrETTKM1h0Ar0WwxqrxYsIRVWI132kaJo
     * expiry : 3600
     */

    private String token;
    private int expiry;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getExpiry() {
        return expiry;
    }

    public void setExpiry(int expiry) {
        this.expiry = expiry;
    }
}
