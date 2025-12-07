package com.example.demo.usecase;

import com.example.demo.domain.entity.Student;
import com.example.demo.domain.exception.StudentNotFoundException;
import com.example.demo.domain.gateway.StudentGateway;

import java.time.LocalDate;

public class UpdateStudent {

    private final StudentGateway gateway;

    public UpdateStudent(StudentGateway gateway) {
        this.gateway = gateway;
    }

    public Student execute(String nim, String namaDepan, String namaBelakang, LocalDate tanggalLahir) {
        Student student = gateway.findByNim(nim)
                .orElseThrow(() -> new StudentNotFoundException(nim));

        student.updateDetails(namaDepan, namaBelakang, tanggalLahir);

        return gateway.save(student);
    }
}