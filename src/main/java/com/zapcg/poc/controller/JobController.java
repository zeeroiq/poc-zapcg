package com.zapcg.poc.controller;

import com.zapcg.poc.runner.DataDumpJobRunner;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dump")
public class JobController {

    @Autowired
    private DataDumpJobRunner jobRunner;

    @SneakyThrows
    @GetMapping("/csv")
    public ResponseEntity<HttpStatus> doDataDump() {
        jobRunner.runBatch();
        return new ResponseEntity<>(HttpStatus.IM_USED);
    }
}
