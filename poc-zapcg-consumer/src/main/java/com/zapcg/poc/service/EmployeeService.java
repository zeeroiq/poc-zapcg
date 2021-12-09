package com.zapcg.poc.service;

import com.zapcg.poc.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> listAllEmployees();
    List<Employee> listAllEmployees(int page, int size, String sortBy);
    void deleteById(int empId);
    void deleteEmployees(int toDelete);
}
