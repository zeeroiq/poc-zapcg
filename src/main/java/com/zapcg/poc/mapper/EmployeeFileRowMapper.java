package com.zapcg.poc.mapper;

import com.zapcg.poc.dto.EmployeeDTO;
import com.zapcg.poc.dto.enums.Gender;
import com.zapcg.poc.dto.enums.NamePrefix;
import com.zapcg.poc.dto.enums.Region;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.sql.Date;

public class EmployeeFileRowMapper implements FieldSetMapper<EmployeeDTO> {

    @Override
    public EmployeeDTO mapFieldSet(FieldSet fieldSet) throws BindException {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpId(Integer.valueOf(fieldSet.readString("Emp ID")));
        employeeDTO.setPrefix(NamePrefix.valueOf(fieldSet.readString("Name Prefix")));
        employeeDTO.setFirstName(fieldSet.readString("First Name"));
        employeeDTO.setLastName(fieldSet.readString("Last Name"));
        employeeDTO.setGender(Gender.valueOf(fieldSet.readString("Gender")));
        employeeDTO.setEmail(fieldSet.readString("E Mail"));
        employeeDTO.setFatherName(fieldSet.readString("Father's Name"));
        employeeDTO.setMotherName(fieldSet.readString("Mother's Name"));
        employeeDTO.setDob(Date.valueOf(fieldSet.readString("Date of Birth")));
        employeeDTO.setDoj(Date.valueOf(fieldSet.readString("Date of Joining")));
        employeeDTO.setSalary(Double.valueOf(fieldSet.readString("Salary")));
        employeeDTO.setSsn(fieldSet.readString("SSN"));
        employeeDTO.setPhoneNumber(fieldSet.readString("Phone No. "));
        employeeDTO.setPlace(fieldSet.readString("County"));
        employeeDTO.setCountry(fieldSet.readString("City"));
        employeeDTO.setState(fieldSet.readString("State"));
        employeeDTO.setZip(fieldSet.readString("Zip"));
        employeeDTO.setRegion(Region.valueOf(fieldSet.readString("Region")));
        employeeDTO.setUsername(fieldSet.readString("User Name"));
        employeeDTO.setPassword(fieldSet.readString("Password"));

        return employeeDTO;
    }
}
