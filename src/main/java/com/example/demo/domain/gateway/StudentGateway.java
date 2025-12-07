package com.example.demo.domain.gateway;

import com.example.demo.domain.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentGateway {

    Student save(Student student);

    Optional<Student> findByNim(String nim);

    List<Student> findAll();

    boolean existsByNim(String nim);

    void deleteByNim(String nim);
}