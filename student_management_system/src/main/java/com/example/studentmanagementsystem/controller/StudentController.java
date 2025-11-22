package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.request.StudentRequest;
import com.example.studentmanagementsystem.response.StudentResponse;
import com.example.studentmanagementsystem.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    public StudentService getService() {
        return service;
    }

    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<StudentResponse> createStudent(@Valid @RequestBody StudentRequest request) {
        StudentResponse response = service.createStudent(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    @GetMapping("/roll/{rollNumber}")
    public ResponseEntity<StudentResponse> getByRoll(@PathVariable String rollNumber) {
        return ResponseEntity.ok(service.getStudentByRollNumber(rollNumber));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequest request) {
        return ResponseEntity.ok(service.updateStudent(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<Page<StudentResponse>> listStudents(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "firstName,asc") String[] sort) {

        Sort.Direction direction = Sort.Direction.fromString(sort[1].toUpperCase());
        Sort sortObj = Sort.by(direction, sort[0]);
        Pageable pageable = PageRequest.of(page, size, sortObj);
        Page<StudentResponse> result = service.listStudents(search, pageable);
        return ResponseEntity.ok(result);
    }
}
