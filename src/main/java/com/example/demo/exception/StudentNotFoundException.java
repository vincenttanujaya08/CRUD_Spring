package com.example.demo.exception;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String nim) {
        super("NIM tidak ditemukan: " + nim);
    }
}
