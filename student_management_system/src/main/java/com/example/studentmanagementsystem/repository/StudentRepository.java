package com.example.studentmanagementsystem.repository;

import com.example.studentmanagementsystem.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByRollNumber(String rollNumber);

    Page<Student> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrRollNumberContainingIgnoreCase(
            String firstName, String lastName, String rollNumber, Pageable pageable);
}
