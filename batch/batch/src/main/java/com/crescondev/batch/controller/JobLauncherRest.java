package com.crescondev.batch.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jobs")
public class JobLauncherRest {
	
	@Autowired
	JobLauncher jobBatchPersonaLauncher;
	
	@Autowired
	Job importPersonaJob;
	
	@PostMapping("/persona")
	public String personaJob() throws Exception {
		
		JobExecution jobExecution = jobBatchPersonaLauncher
				.run(importPersonaJob, new JobParametersBuilder()
					.addLong("idInicio", System.nanoTime())
					.toJobParameters());
		return "JOB_EXECUTION_ID : " + jobExecution.getId();		
		
	}
	

}
