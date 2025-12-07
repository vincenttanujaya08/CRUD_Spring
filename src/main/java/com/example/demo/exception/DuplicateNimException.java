package com.example.demo.exception;

public class DuplicateNimException extends RuntimeException {
    public DuplicateNimException(String nim) {
        super("NIM sudah terdaftar: " + nim);
    }
}
