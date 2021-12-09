package com.zapcg.poc.controller;

import com.zapcg.poc.excel.ExcelExportService;
import com.zapcg.poc.model.Employee;
import com.zapcg.poc.service.EmployeeDBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/export")
public class DBExcelDumpController {

    @Autowired
    private EmployeeDBService employeeDBService;

    @PostMapping("/employee")
    private void excelToExport(HttpServletResponse response) throws IOException {

        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=employees-details_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Employee> listUsers = employeeDBService.listEmployees();

        ExcelExportService excelExporter = new ExcelExportService(listUsers);

        excelExporter.export(response);
        log.debug(">>>>> No of records dumped: " + listUsers.size());
    }
}
