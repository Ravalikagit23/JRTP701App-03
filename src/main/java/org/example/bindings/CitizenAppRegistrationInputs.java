package org.example.bindings;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CitizenAppRegistrationInputs {
    private String fullName;
    private String email;
    private String gender;
    private Long phoneNo;
    private Long ssn;
    private LocalDate dob;
}
