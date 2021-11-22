package com.zapcg.poc.kafka;

import com.zapcg.poc.model.Employee;
import com.zapcg.poc.repository.EmployeeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Slf4j
@Component
public class MessageReceiver {

    private CountDownLatch latch = new CountDownLatch(1);
    @Autowired
    private EmployeeRepo repository;

    @KafkaListener(topics = "EMPLOYEE_TOPIC")
    public void receiveMessages(Employee employee) {
        log.info(">>>>> Received Employee: {}", employee.toString());
        repository.save(employee);
        latch.countDown();
    }
}
