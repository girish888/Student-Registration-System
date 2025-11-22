package com.example.studentmanagementsystem.request;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {

    @NotBlank(message = "Roll number is required")
    private String rollNumber;

    @NotBlank(message = "First name is required")
    private String firstName;

    private String lastName;

    @Email(message = "Invalid email format")
    private String email;

    private LocalDate dob;

    private String gender;

    @Pattern(regexp = "^[0-9]{10,15}$", message = "Enter valid phone number")
    private String phone;
}
