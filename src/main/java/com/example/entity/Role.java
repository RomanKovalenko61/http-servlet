package com.example.entity;

public enum Role {
    USER,
    ADMIN;

    public static boolean isValid(String role) {
        try {
            Enum.valueOf(Role.class, role);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}