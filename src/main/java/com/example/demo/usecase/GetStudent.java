package com.example.demo.usecase;

import com.example.demo.domain.entity.Student;
import com.example.demo.domain.exception.StudentNotFoundException;
import com.example.demo.domain.gateway.StudentGateway;

public class GetStudent {

    private final StudentGateway gateway;

    public GetStudent(StudentGateway gateway) {
        this.gateway = gateway;
    }

    public Student execute(String nim) {
        return gateway.findByNim(nim)
                .orElseThrow(() -> new StudentNotFoundException(nim));
    }
}