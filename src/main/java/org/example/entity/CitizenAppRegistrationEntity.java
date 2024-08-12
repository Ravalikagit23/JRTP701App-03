package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Table(name="CITIZEN_APPLICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CitizenAppRegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer appId;
    @Column(length =30)
    private String fullName;
    @Column(length =30)
    private  String email;
    @Column(length =20)
    private String gender;
    private Long phoneNo;
    private Long ssn;
    @Column(length=30)
    private String stateName;
    private LocalDate dob;
    @Column(length =30)
    private String createdBy;
    @Column(length =30)
    private String updatedBy;
    @CreationTimestamp
    @Column(updatable=false)
    private LocalDate creationTime;
    @CreationTimestamp
    @Column(insertable = false)
    private LocalDate updationTime;



}
