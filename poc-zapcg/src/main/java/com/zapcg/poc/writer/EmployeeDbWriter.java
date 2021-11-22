package com.zapcg.poc.writer;

import com.zapcg.poc.model.Employee;
import com.zapcg.poc.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
//@Component
public class EmployeeDbWriter implements ItemWriter<Employee> {
    @Autowired
    private EmployeeRepo employeeRepo;
    @Override
    public void write(List<? extends Employee> employees) throws Exception {
            employeeRepo.saveAll(employees);
            log.info(String.format(">>>>> Data Written is %d", employees.size()));
    }
}
