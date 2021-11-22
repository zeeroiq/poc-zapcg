package com.zapcg.poc.processor;

import com.zapcg.poc.dto.EmployeeDTO;
import com.zapcg.poc.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmployeeProcessor implements ItemProcessor<EmployeeDTO, Employee> {
    @Override
    public Employee process(EmployeeDTO employeeDTO) throws Exception {
        log.info(">>>>> Processed data: {}", employeeDTO.toString());
        Employee employee = new Employee();

        employee.setEmpId(employeeDTO.getEmpId());
        employee.setPrefix(employeeDTO.getPrefix());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
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
        employee.setRegion(employeeDTO.getRegion());
        employee.setUsername(employeeDTO.getUsername());
        employee.setPassword(employeeDTO.getPassword());

        return employee;
    }
}
