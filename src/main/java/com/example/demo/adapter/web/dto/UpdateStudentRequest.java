package com.example.demo.adapter.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UpdateStudentRequest(
        @NotBlank(message = "Nama depan tidak boleh kosong")
        String namaDepan,

        String namaBelakang,

        @NotNull(message = "Tanggal lahir tidak boleh kosong")
        LocalDate tanggalLahir
) {}