package com.example.demo.adapter.persistence;

import com.example.demo.domain.entity.Student;
import com.example.demo.domain.gateway.StudentGateway;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentGatewayImpl implements StudentGateway {

    private final StudentJpaRepository jpaRepository;

    public StudentGatewayImpl(StudentJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    // ==================== GATEWAY INTERFACE IMPLEMENTATION ====================

    @Override
    public Student save(Student student) {
        // Step 1: Domain → JPA Entity
        StudentEntity entity = toEntity(student);

        // Step 2: Save to database via JPA
        StudentEntity savedEntity = jpaRepository.save(entity);

        // Step 3: JPA Entity → Domain
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Student> findByNim(String nim) {
        return jpaRepository.findById(nim)
                .map(this::toDomain);  // Convert JPA entity to domain entity
    }

    @Override
    public List<Student> findAll() {
        return jpaRepository.findAll().stream()
                .map(this::toDomain)  // Convert each JPA entity to domain entity
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByNim(String nim) {
        return jpaRepository.existsById(nim);
    }

    @Override
    public void deleteByNim(String nim) {
        jpaRepository.deleteById(nim);
    }

    private Student toDomain(StudentEntity entity) {
        return new Student(
                entity.getNim(),
                entity.getNamaDepan(),
                entity.getNamaBelakang(),
                entity.getTanggalLahir()
        );
    }


    private StudentEntity toEntity(Student domain) {
        return new StudentEntity(
                domain.getNim(),
                domain.getNamaDepan(),
                domain.getNamaBelakang(),
                domain.getTanggalLahir()
        );
    }


}