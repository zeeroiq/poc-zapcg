package com.zapcg.poc.processor;

import com.zapcg.poc.dto.EmployeeDTO;
import com.zapcg.poc.dto.enums.NamePrefix;
import com.zapcg.poc.model.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeDTO, Employee> {
    @Override
    public Employee process(EmployeeDTO employeeDTO) throws Exception {

        Employee employee = new Employee();

        employee.setEmpId(employeeDTO.getEmpId());
        employee.setPrefix(employeeDTO.getPrefix().name());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender().name());
        employee.setEmail(employeeDTO.getEmail());
        employee.setFatherName(employeeDTO.getFatherName());
        employee.setMotherName(employeeDTO.getMotherName());
        employee.setDob(employeeDTO.getDob());
        employee.setDoj(employeeDTO.getDoj());
        employee.setSalary(employeeDTO.getSalary());
        employee.setSsn(employeeDTO.getSsn());
        employee.setPhoneNumber(employeeDTO.getPhoneNumber());
        employee.setPlace(employeeDTO.getPlace());
        employee.setCountry(employeeDTO.getCountry());
        employee.setState(employeeDTO.getState());
        employee.setZip(employeeDTO.getZip());
        employee.setRegion(employeeDTO.getRegion().name());
        employee.setUsername(employeeDTO.getUsername());
        employee.setPassword(employeeDTO.getPassword());

        return employee;
    }
}
