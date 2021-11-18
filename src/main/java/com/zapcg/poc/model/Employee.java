package com.zapcg.poc.model;

import com.zapcg.poc.dto.enums.Gender;
import com.zapcg.poc.dto.enums.NamePrefix;
import com.zapcg.poc.dto.enums.Region;
import com.zapcg.poc.model.converter.NamePrefixConverter;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Employee {
    @Id
    private Integer empId;
//    @Enumerated(EnumType.STRING)
    private String prefix;
    private String firstName;
    private String lastName;
//    @Enumerated(EnumType.STRING)
    private String gender;
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
//    @Enumerated(EnumType.STRING)
    private String region;
    private String username;
    private String password;
}
