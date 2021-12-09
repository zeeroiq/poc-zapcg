package com.zapcg.poc.repository;

import com.zapcg.poc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

    @Modifying
    @Transactional
//    @Query(value = "DELETE FROM poc.employee ORDER BY emp_id DESC LIMIT :delete", nativeQuery = true)
    @Query(value = "DELETE FROM poc.employee LIMIT :delete", nativeQuery = true)
    void deleteEmployees(int delete);
}
