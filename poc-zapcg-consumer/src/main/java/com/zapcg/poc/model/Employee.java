package com.zapcg.poc.model;

import com.zapcg.poc.model.eums.Gender;
import com.zapcg.poc.model.eums.NamePrefix;
import com.zapcg.poc.model.eums.Region;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class Employee {
    @Id
    private Integer empId;
    @Enumerated(EnumType.STRING)
    private NamePrefix prefix;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String email;
    private String fatherName;
    private String motherName;
    private Date dob;
    private Date doj;
    private Double salary;
    private String ssn;
    private String phoneNumber;
    private String place;
    private String country;
    private String state;
    private String zip;
    @Enumerated(EnumType.STRING)
    private Region region;
    private String username;
    private String password;
}
