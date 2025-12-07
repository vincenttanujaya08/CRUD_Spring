package com.example.demo.adapter.web.dto;

import com.example.demo.domain.entity.Student;

import java.time.LocalDate;

public record StudentDetailResponse(
        String nim,
        String namaDepan,
        String namaBelakang,
        LocalDate tanggalLahir,
        String namaLengkap,
        int usia
) {
    public static StudentDetailResponse from(Student student) {
        return new StudentDetailResponse(
                student.getNim(),
                student.getNamaDepan(),
                student.getNamaBelakang(),
                student.getTanggalLahir(),
                student.getNamaLengkap(),
                student.getUsia()
        );
    }
}