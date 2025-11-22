package com.example.studentmanagementsystem.service;

import com.example.studentmanagementsystem.request.StudentRequest;
import com.example.studentmanagementsystem.response.StudentResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    StudentResponse createStudent(StudentRequest request);
    StudentResponse getStudentById(Long id);
    StudentResponse updateStudent(Long id, StudentRequest request);
    void deleteStudent(Long id);
    Page<StudentResponse> listStudents(String search, Pageable pageable);
    StudentResponse getStudentByRollNumber(String rollNumber);
}
