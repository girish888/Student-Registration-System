package com.example.studentmanagementsystem.serviceimpl;

import com.example.studentmanagementsystem.model.Student;
import com.example.studentmanagementsystem.repository.StudentRepository;
import com.example.studentmanagementsystem.request.StudentRequest;
import com.example.studentmanagementsystem.response.StudentResponse;
import com.example.studentmanagementsystem.service.StudentService;
import com.example.studentmanagementsystem.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    @Autowired
    public StudentServiceImpl(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public StudentResponse createStudent(StudentRequest request) {
        Student s = Student.builder()
                .rollNumber(request.getRollNumber())
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .dob(request.getDob())
                .gender(request.getGender())
                .phone(request.getPhone())
                .build();
        Student saved = repo.save(s);
        return toResponse(saved);
    }

    @Override
    public StudentResponse getStudentById(Long id) {
        Student s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        return toResponse(s);
    }

    @Override
    public StudentResponse updateStudent(Long id, StudentRequest request) {
        Student s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        s.setRollNumber(request.getRollNumber());
        s.setFirstName(request.getFirstName());
        s.setLastName(request.getLastName());
        s.setEmail(request.getEmail());
        s.setDob(request.getDob());
        s.setGender(request.getGender());
        s.setPhone(request.getPhone());
        Student updated = repo.save(s);
        return toResponse(updated);
    }

    @Override
    public void deleteStudent(Long id) {
        Student s = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
        repo.delete(s);
    }

    @Override
    public Page<StudentResponse> listStudents(String search, Pageable pageable) {
        Page<Student> page;
        if (search == null || search.isBlank()) {
            page = repo.findAll(pageable);
        } else {
            page = repo.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrRollNumberContainingIgnoreCase(
                    search, search, search, pageable);
        }
        return page.map(this::toResponse);
    }

    @Override
    public StudentResponse getStudentByRollNumber(String rollNumber) {
        Student s = repo.findByRollNumber(rollNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with roll " + rollNumber));
        return toResponse(s);
    }

    private StudentResponse toResponse(Student s) {
        return StudentResponse.builder()
                .id(s.getId())
                .rollNumber(s.getRollNumber())
                .firstName(s.getFirstName())
                .lastName(s.getLastName())
                .email(s.getEmail())
                .dob(s.getDob())
                .gender(s.getGender())
                .phone(s.getPhone())
                .createdAt(s.getCreatedAt())
                .updatedAt(s.getUpdatedAt())
                .build();
    }
}
