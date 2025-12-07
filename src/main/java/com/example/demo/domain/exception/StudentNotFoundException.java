package com.example.demo.domain.exception;

public class StudentNotFoundException extends RuntimeException {

    private final String nim;

    public StudentNotFoundException(String nim) {
        super("Mahasiswa dengan NIM " + nim + " tidak ditemukan");
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }
}