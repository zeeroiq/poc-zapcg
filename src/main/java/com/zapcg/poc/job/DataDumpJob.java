package com.zapcg.poc.job;

import com.zapcg.poc.dto.EmployeeDTO;
import com.zapcg.poc.mapper.EmployeeFileRowMapper;
import com.zapcg.poc.model.Employee;
import com.zapcg.poc.processor.EmployeeProcessor;
import com.zapcg.poc.writer.EmployeeDbWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
public class DataDumpJob {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private EmployeeProcessor employeeProcessor;
    private DataSource dataSource;
    @Autowired private EmployeeDbWriter empWriter;
    private final String QUERY_INSERT_EMPLOYEE = "INSERT INTO " +
            "employee(" +
            "emp_Id, prefix, first_name, last_name, " +
            "gender, email, father_name, mother_name, " +
            "dob, doj, salary, ssn, phone_number, " +
            "place, country, state, zip, region, username, password" +
            ") " +
            "VALUES (" +
            ":empId, :prefix, :firstName, :lastName, " +
            ":gender, :email, :fatherName, :motherName, " +
            ":dob, :doj, :salary, :ssn, :phoneNumber, " +
            ":place, :country, :state, :zip, :region, " +
            ":username, :password" +
            ")";
    @Autowired
    public DataDumpJob(JobBuilderFactory jobBuilderFactory,
                       StepBuilderFactory stepBuilderFactory,
                       EmployeeProcessor employeeProcessor,
                       DataSource dataSource) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.employeeProcessor = employeeProcessor;
        this.dataSource = dataSource;
    }

    @Qualifier("csvDataDumpJob")
    @Bean
    public Job csvDataDumpJob() {
        return this.jobBuilderFactory.get("csv-data-dump-job")
                .start(dataDumpStep())
                .build();
    }

    private Step dataDumpStep() {
        return this.stepBuilderFactory.get("csv-data-dump-step")
                .<EmployeeDTO, Employee>chunk(10)
                .reader(employeeCSVReader())
                .processor(employeeProcessor)
                .writer(empWriter)
//                .writer(employeeDBWriter())
                .build();
    }

    @Bean
    public FlatFileItemReader<EmployeeDTO> employeeCSVReader() {
        return new FlatFileItemReaderBuilder<EmployeeDTO>()
                .name("csv-file-reader")
                .resource(new ClassPathResource("records.csv"))
                .linesToSkip(1)
                .delimited()
                .names(new String[]{"empId", "prefix", "firstName",
                        "lastName", "gender", "email", "fatherName",
                        "motherName", "dob", "doj", "salary", "ssn",
                        "phoneNumber", "place", "country", "state",
                        "zip", "region", "username", "password"})
                .fieldSetMapper(new EmployeeFileRowMapper())
                .build();
    }

    @Bean
    public JdbcBatchItemWriter<Employee> employeeDBWriter() {
        return new JdbcBatchItemWriterBuilder<Employee>()
                .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
                .sql(QUERY_INSERT_EMPLOYEE)
                .dataSource(dataSource)
                .build();
    }
}
