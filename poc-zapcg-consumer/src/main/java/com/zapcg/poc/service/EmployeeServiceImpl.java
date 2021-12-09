package com.zapcg.poc.service;

import com.zapcg.poc.model.Employee;
import com.zapcg.poc.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;


    @Override
    public List<Employee> listAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public List<Employee> listAllEmployees(int page, int size, String sortBy) {
        Pageable paging = PageRequest.of(page, size, Sort.by(sortBy));
        Page<Employee> pageResult = employeeRepo.findAll(paging);

        return pageResult.hasContent() ? pageResult.getContent() : new ArrayList<>();
    }

    @Override
    public void deleteById(int empId) {
        employeeRepo.deleteById(empId);
    }

    @Override
    public void deleteEmployees(int toDelete) {
        employeeRepo.deleteEmployees(toDelete);
    }

}
