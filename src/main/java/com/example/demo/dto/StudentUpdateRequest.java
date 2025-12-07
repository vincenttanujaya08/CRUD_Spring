package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record StudentUpdateRequest(
        @NotBlank String namaDepan,
        String namaBelakang,            // optional
        @NotNull LocalDate tanggalLahir
) {}
