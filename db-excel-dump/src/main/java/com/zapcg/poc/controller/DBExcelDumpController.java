package com.zapcg.poc.controller;

import com.zapcg.poc.excel.ExcelExportService;
import com.zapcg.poc.model.Employee;
import com.zapcg.poc.service.EmployeeDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/export")
public class DBExcelDumpController {

    @Autowired
    private EmployeeDBService employeeDBService;

    @GetMapping("/employee")
    private void excelToExport(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Employee> listUsers = employeeDBService.listEmployees();

        ExcelExportService excelExporter = new ExcelExportService(listUsers);

        excelExporter.export(response);
    }
}
