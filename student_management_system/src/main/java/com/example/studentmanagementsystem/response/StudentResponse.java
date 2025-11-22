package com.example.studentmanagementsystem.response;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private String rollNumber;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dob;
    private String gender;
    private String phone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
