package com.backend.tictactoe.models;

public class User {
    private String name;
    private String email;
    private String photo;

    public User() {}

    public User(String name, String email, String photo) {
        this.name = name;
        this.email = email;
        this.photo = photo;
    }
}
