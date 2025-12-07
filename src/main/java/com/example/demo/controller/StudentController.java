package com.example.demo.controller;

import com.example.demo.dto.StudentCreateRequest;
import com.example.demo.dto.StudentDetailResponse;
import com.example.demo.dto.StudentListItemResponse;
import com.example.demo.dto.StudentUpdateRequest;
import com.example.demo.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudentListItemResponse> list() {
        return service.list();
    }

    @GetMapping("/{nim}")
    public StudentDetailResponse getOne(@PathVariable String nim) {
        return service.getOne(nim);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDetailResponse create(@Valid @RequestBody StudentCreateRequest req) {
        return service.create(req);
    }

    @PutMapping("/{nim}")
    public StudentDetailResponse update(@PathVariable String nim, @Valid @RequestBody StudentUpdateRequest req) {
        return service.update(nim, req);
    }

    @DeleteMapping("/{nim}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String nim) {
        service.delete(nim);
    }
}
