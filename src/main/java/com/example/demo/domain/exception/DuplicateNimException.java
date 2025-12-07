package com.example.demo.domain.exception;

public class DuplicateNimException extends RuntimeException {

    private final String nim;

    public DuplicateNimException(String nim) {
        super("NIM " + nim + " sudah terdaftar");
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }
}