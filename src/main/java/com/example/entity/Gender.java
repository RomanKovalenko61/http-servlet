package com.example.entity;

public enum Gender {
    MALE,
    FEMALE;

    public static boolean isValid(String gender) {
        try {
            Enum.valueOf(Gender.class, gender);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}