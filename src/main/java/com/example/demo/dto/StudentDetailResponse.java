package com.example.demo.dto;

import java.time.LocalDate;

public record StudentDetailResponse(
        String nim,
        String namaDepan,
        String namaBelakang,
        LocalDate tanggalLahir,
        String namaLengkap,
        int usia
) {}
