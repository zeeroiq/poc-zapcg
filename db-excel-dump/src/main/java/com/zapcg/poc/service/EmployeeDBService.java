package com.zapcg.poc.service;

import com.zapcg.poc.model.Employee;
import com.zapcg.poc.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDBService {

    @Autowired private EmployeeRepo employeeRepo;

    public List<Employee> listEmployees() {
        return employeeRepo.findAll(Sort.by("doj").ascending());
    }
}
