package com.example.demo.usecase;

import com.example.demo.domain.entity.Student;
import com.example.demo.domain.exception.DuplicateNimException;
import com.example.demo.domain.gateway.StudentGateway;

import java.time.LocalDate;

public class CreateStudent {

    private final StudentGateway gateway;

    public CreateStudent(StudentGateway gateway) {
        this.gateway = gateway;
    }

    public Student execute(String nim, String namaDepan, String namaBelakang, LocalDate tanggalLahir) {
        if (gateway.existsByNim(nim)) {
            throw new DuplicateNimException(nim);
        }

        Student student = new Student(nim, namaDepan, namaBelakang, tanggalLahir);

        return gateway.save(student);
    }
}