package com.zapcg.poc.writer;

import com.zapcg.poc.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Slf4j
public class EmployeeKafkaWriter implements ItemWriter<Employee> {
    @Autowired private KafkaTopicSender sender;
    @Override
    public void write(List<? extends Employee> items) throws Exception {
        items.stream().forEach(emp-> sender.send(emp));
        log.info(">>>>> Message sent to kafka broker.");
    }
}
