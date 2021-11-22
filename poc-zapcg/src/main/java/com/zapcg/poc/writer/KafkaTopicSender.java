package com.zapcg.poc.writer;

import com.zapcg.poc.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaTopicSender {
    @Autowired private KafkaTemplate<String, Employee> template;

    public void send(Employee employee) {
        template.send("EMPLOYEE_TOPIC", employee);
        log.info(">>>>> Object sent to kafka broker: {}", employee.toString());
    }
}
