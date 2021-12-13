package com.zapcg.poc.controller;

import com.zapcg.poc.model.Employee;
import com.zapcg.poc.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/consumer")
public class EmployeeController {

    @Autowired private EmployeeService employeeService;

    @GetMapping("/employees")
    private List<Employee> listEmployees() {
        List<Employee> employees = employeeService.listAllEmployees();
        return employees;
    }

    @GetMapping(value = "/employees/", params = {"page", "size", "sortBy"})
    private ResponseEntity<List<Employee>> getPaginatedList(@RequestParam(defaultValue = "0") Integer page,
                                                           @RequestParam(defaultValue = "10") Integer size,
                                                           @RequestParam(defaultValue = "emp_id") String sortBy) {
        List<Employee> employees = employeeService.listAllEmployees(page, size, sortBy);
        return new ResponseEntity<>(employees, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/employee", params = {"empId"})
    private ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("empId") Integer empId) {
        employeeService.deleteById(empId);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(value = "/employees", params = {"toDelete"})
    private ResponseEntity<HttpStatus> deleteEmployees(@RequestParam("toDelete") Integer toDelete) {
        employeeService.deleteEmployees(toDelete);
        return new ResponseEntity<>(new HttpHeaders(), HttpStatus.OK);
    }
}
