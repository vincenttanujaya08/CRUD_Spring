package com.example.demo.adapter.web;

import com.example.demo.adapter.web.dto.*;
import com.example.demo.domain.entity.Student;
import com.example.demo.usecase.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final CreateStudent createStudent;
    private final GetStudent getStudent;
    private final ListStudents listStudents;
    private final UpdateStudent updateStudent;
    private final DeleteStudent deleteStudent;

    public StudentController(
            CreateStudent createStudent,
            GetStudent getStudent,
            ListStudents listStudents,
            UpdateStudent updateStudent,
            DeleteStudent deleteStudent
    ) {
        this.createStudent = createStudent;
        this.getStudent = getStudent;
        this.listStudents = listStudents;
        this.updateStudent = updateStudent;
        this.deleteStudent = deleteStudent;
    }

    @GetMapping
    public List<StudentListResponse> list() {
        return listStudents.execute().stream()
                .map(StudentListResponse::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{nim}")
    public StudentDetailResponse getOne(@PathVariable String nim) {
        Student student = getStudent.execute(nim);
        return StudentDetailResponse.from(student);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDetailResponse create(@Valid @RequestBody CreateStudentRequest request) {
        Student student = createStudent.execute(
                request.nim(),
                request.namaDepan(),
                request.namaBelakang(),
                request.tanggalLahir()
        );
        return StudentDetailResponse.from(student);
    }

    @PutMapping("/{nim}")
    public StudentDetailResponse update(
            @PathVariable String nim,
            @Valid @RequestBody UpdateStudentRequest request
    ) {
        Student student = updateStudent.execute(
                nim,
                request.namaDepan(),
                request.namaBelakang(),
                request.tanggalLahir()
        );
        return StudentDetailResponse.from(student);
    }

    @DeleteMapping("/{nim}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String nim) {
        deleteStudent.execute(nim);
    }
}