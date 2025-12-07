package com.example.demo.service;

import com.example.demo.dto.StudentCreateRequest;
import com.example.demo.dto.StudentDetailResponse;
import com.example.demo.dto.StudentListItemResponse;
import com.example.demo.dto.StudentUpdateRequest;
import com.example.demo.entity.Student;
import com.example.demo.exception.DuplicateNimException;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repo.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    public List<StudentListItemResponse> list() {
        return repo.findAll().stream()
                .map(s -> new StudentListItemResponse(s.getNim(), fullName(s), age(s.getTanggalLahir())))
                .toList();
    }

    public StudentDetailResponse getOne(String nim) {
        Student s = repo.findById(nim).orElseThrow(() -> new StudentNotFoundException(nim));
        return new StudentDetailResponse(
                s.getNim(),
                s.getNamaDepan(),
                s.getNamaBelakang(),
                s.getTanggalLahir(),
                fullName(s),
                age(s.getTanggalLahir())
        );
    }

    public StudentDetailResponse create(StudentCreateRequest req) {
        if (repo.existsById(req.nim())) throw new DuplicateNimException(req.nim());

        Student s = new Student();
        s.setNim(req.nim());
        s.setNamaDepan(req.namaDepan());
        s.setNamaBelakang(req.namaBelakang());
        s.setTanggalLahir(req.tanggalLahir());

        Student saved = repo.save(s);
        return getOne(saved.getNim());
    }

    public StudentDetailResponse update(String nim, StudentUpdateRequest req) {
        Student existing = repo.findById(nim).orElseThrow(() -> new StudentNotFoundException(nim));

        existing.setNamaDepan(req.namaDepan());
        existing.setNamaBelakang(req.namaBelakang());
        existing.setTanggalLahir(req.tanggalLahir());

        repo.save(existing);
        return getOne(nim);
    }

    public void delete(String nim) {
        if (!repo.existsById(nim)) throw new StudentNotFoundException(nim);
        repo.deleteById(nim);
    }

    private static String fullName(Student s) {
        String depan = s.getNamaDepan() == null ? "" : s.getNamaDepan().trim();
        String belakang = s.getNamaBelakang() == null ? "" : s.getNamaBelakang().trim();
        if (depan.isBlank()) return belakang;
        if (belakang.isBlank()) return depan;
        return depan + " " + belakang;
    }

    private static int age(LocalDate dob) {
        if (dob == null) return 0;
        return Period.between(dob, LocalDate.now()).getYears();
    }
}
