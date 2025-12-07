package com.example.demo.adapter.web.dto;

import com.example.demo.domain.entity.Student;

public record StudentListResponse(
        String nim,
        String namaLengkap,
        int usia
) {
    public static StudentListResponse from(Student student) {
        return new StudentListResponse(
                student.getNim(),
                student.getNamaLengkap(),
                student.getUsia()
        );
    }
}