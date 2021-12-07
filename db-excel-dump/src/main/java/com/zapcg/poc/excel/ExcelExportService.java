package com.zapcg.poc.excel;

import com.zapcg.poc.model.Employee;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ExcelExportService {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<Employee> employeeList;
    private final String[] cellValue = {
            "Emp ID",
            "Name Prefix",
            "First Name",
            "Last Name",
            "Gender",
            "E Mail",
            "Father's Name",
            "Mother's Name",
            "Date of Birth",
            "Date of Joining",
            "Salary",
            "SSN",
            "Phone No. ",
            "Place Name",
            "Country",
            "State",
            "Zip",
            "Region",
            "User Name",
            "Password"};

    public ExcelExportService(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    private void writeHeaderLine() {
        sheet = workbook.createSheet("Employees");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight((short) 16);
        style.setFont(font);

        createCell(row, cellValue, style);
    }

    private void createCell(Row row, Object[] cellValue, CellStyle style) {
        AtomicInteger cellCount = new AtomicInteger();
        Arrays.stream(cellValue).forEach(value -> {
            int currentCell = cellCount.getAndIncrement();
            sheet.autoSizeColumn(currentCell);
            Cell cell = row.createCell(currentCell);
            if (value instanceof Integer) {
                cell.setCellValue((Integer) value);
            } else if (value instanceof Boolean) {
                cell.setCellValue((Boolean) value);
            } else if (value instanceof Date) {
                cell.setCellValue((Date) value);
            } else {
                cell.setCellValue((String) value);
            }

            cell.setCellStyle(style);
        });
    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {

        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Date) {
            cell.setCellValue((Date) value);
        } else {
            cell.setCellValue((String) value);
        }

        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;
        CellStyle cellStyle = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontHeight((short) 14);
        cellStyle.setFont(font);

        for (Employee employee : employeeList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, employee.getEmpId(), cellStyle);
            createCell(row, columnCount++, employee.getPrefix(), cellStyle);
            createCell(row, columnCount++, employee.getFirstName(), cellStyle);
            createCell(row, columnCount++, employee.getLastName(), cellStyle);
            createCell(row, columnCount++, employee.getGender(), cellStyle);
            createCell(row, columnCount++, employee.getEmail(), cellStyle);
            createCell(row, columnCount++, employee.getFirstName(), cellStyle);
            createCell(row, columnCount++, employee.getMotherName(), cellStyle);
            createCell(row, columnCount++, employee.getDob(), cellStyle);
            createCell(row, columnCount++, employee.getDoj(), cellStyle);
            createCell(row, columnCount++, employee.getSalary(), cellStyle);
            createCell(row, columnCount++, employee.getSsn(), cellStyle);
            createCell(row, columnCount++, employee.getPhoneNumber(), cellStyle);
            createCell(row, columnCount++, employee.getPlace(), cellStyle);
            createCell(row, columnCount++, employee.getCountry(), cellStyle);
            createCell(row, columnCount++, employee.getState(), cellStyle);
            createCell(row, columnCount++, employee.getZip(), cellStyle);
            createCell(row, columnCount++, employee.getRegion(), cellStyle);
            createCell(row, columnCount++, employee.getUsername(), cellStyle);
            createCell(row, columnCount++, employee.getPassword(), cellStyle);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();

        outputStream.close();

    }
}
