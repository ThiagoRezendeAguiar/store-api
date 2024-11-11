package com.trab.store.model.enums;

public enum UserRole {
    ADMIN(0),
    USER(1);

    private int role;

    UserRole(int role) {
        this.role = role;
    }

    public int getRole(){
        return this.role;
    }
}
