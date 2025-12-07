package com.example.demo.usecase;

import com.example.demo.domain.exception.StudentNotFoundException;
import com.example.demo.domain.gateway.StudentGateway;

public class DeleteStudent {

    private final StudentGateway gateway;

    public DeleteStudent(StudentGateway gateway) {
        this.gateway = gateway;
    }

    public void execute(String nim) {
        if (!gateway.existsByNim(nim)) {
            throw new StudentNotFoundException(nim);
        }

        gateway.deleteByNim(nim);
    }
}