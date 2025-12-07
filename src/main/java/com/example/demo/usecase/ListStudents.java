package com.example.demo.usecase;

import com.example.demo.domain.entity.Student;
import com.example.demo.domain.gateway.StudentGateway;

import java.util.List;

public class ListStudents {

    private final StudentGateway gateway;

    public ListStudents(StudentGateway gateway) {
        this.gateway = gateway;
    }

    public List<Student> execute() {
        return gateway.findAll();
    }
}