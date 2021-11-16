package com.zapcg.poc.dto;

import com.zapcg.poc.dto.enums.Gender;
import com.zapcg.poc.dto.enums.NamePrefix;
import com.zapcg.poc.dto.enums.Region;
import lombok.Data;

import java.sql.Date;

@Data
public class EmployeeDTO {

    private Integer empId;
    private NamePrefix prefix;
    private String firstName;
    private String lastName;
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
    private Region region;
    private String username;
    private String password;

}
