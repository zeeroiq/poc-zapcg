package com.zapcg.poc.mapper;

import com.zapcg.poc.dto.EmployeeDTO;
import com.zapcg.poc.dto.enums.Gender;
import com.zapcg.poc.dto.enums.NamePrefix;
import com.zapcg.poc.dto.enums.Region;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Locale;

public class EmployeeFileRowMapper implements FieldSetMapper<EmployeeDTO> {

    @Override
    public EmployeeDTO mapFieldSet(FieldSet fieldSet) throws BindException {

        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setEmpId(Integer.valueOf(fieldSet.readString("empId")));
        employeeDTO.setPrefix(NamePrefix.valueOf(fieldSet.readString("prefix").replace(".", "")));
        employeeDTO.setFirstName(fieldSet.readString("firstName"));
        employeeDTO.setLastName(fieldSet.readString("lastName"));
        employeeDTO.setGender(Gender.valueOf(fieldSet.readString("gender")));
        employeeDTO.setEmail(fieldSet.readString("email"));
        employeeDTO.setFatherName(fieldSet.readString("fatherName"));
        employeeDTO.setMotherName(fieldSet.readString("motherName"));
        employeeDTO.setDob(getConvertedDate(fieldSet.readString("dob")));
        employeeDTO.setDoj(getConvertedDate(fieldSet.readString("doj")));
        employeeDTO.setSalary(Double.valueOf(fieldSet.readString("salary")));
        employeeDTO.setSsn(fieldSet.readString("ssn"));
        employeeDTO.setPhoneNumber(fieldSet.readString("phoneNumber"));
        employeeDTO.setPlace(fieldSet.readString("place"));
        employeeDTO.setCountry(fieldSet.readString("country"));
        employeeDTO.setState(fieldSet.readString("state"));
        employeeDTO.setZip(fieldSet.readString("zip"));
        employeeDTO.setRegion(Region.valueOf(fieldSet.readString("region").toUpperCase(Locale.ROOT)));
        employeeDTO.setUsername(fieldSet.readString("username"));
        employeeDTO.setPassword(fieldSet.readString("password"));

        return employeeDTO;
    }

    private Date getConvertedDate(String dateString) {
        Date date = null;
        SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat format2 = new SimpleDateFormat("dd-MM-yyyy");
        try {
            if (dateString.contains("/")) {
                date = new Date(format1.parse(dateString).getTime());
            }
            else if(dateString.contains("-")) {
                date = new Date(format2.parse(dateString).getTime());
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
