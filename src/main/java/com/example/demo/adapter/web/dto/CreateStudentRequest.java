package com.example.demo.adapter.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateStudentRequest(
        @NotBlank(message = "NIM tidak boleh kosong")
        String nim,

        @NotBlank(message = "Nama depan tidak boleh kosong")
        String namaDepan,

        String namaBelakang,

        @NotNull(message = "Tanggal lahir tidak boleh kosong")
        LocalDate tanggalLahir
) {}