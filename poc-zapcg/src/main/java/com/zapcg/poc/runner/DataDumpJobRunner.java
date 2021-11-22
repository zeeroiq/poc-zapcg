package com.zapcg.poc.runner;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DataDumpJobRunner {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job csvDataDumpJob;

    public void runBatch() throws JobInstanceAlreadyCompleteException,
            JobExecutionAlreadyRunningException,
            JobParametersInvalidException,
            JobRestartException {

        JobParameters jobParameters = new JobParametersBuilder()
                .addDate("date", new Date(), true)
                .toJobParameters();
        run(csvDataDumpJob, jobParameters);
    }

    private void run(Job csvDataDumpJob, JobParameters jobParameters)
            throws JobInstanceAlreadyCompleteException,
            JobExecutionAlreadyRunningException,
            JobParametersInvalidException,
            JobRestartException {
        try {
            jobLauncher.run(csvDataDumpJob, jobParameters);
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
