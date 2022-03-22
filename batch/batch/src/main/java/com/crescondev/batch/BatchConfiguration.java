package com.crescondev.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import com.crescondev.batch.listener.JobListener;
import com.crescondev.batch.model.Persona;
import com.crescondev.batch.processor.PersonaProcessor;
import com.crescondev.batch.writer.PersonaWriter;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
	@Autowired
	public JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	public StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	JobRepository jobRepository;
	
	@Value("${file.input}")
	private String fileInput;

	@Bean
	public JobLauncher jobBatchPersonaLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(jobRepository);
		jobLauncher.setTaskExecutor(new SimpleAsyncTaskExecutor());
		jobLauncher.afterPropertiesSet();
		return jobLauncher;
	}
	
	@Bean
	public FlatFileItemReader<Persona> reader() {
		return new FlatFileItemReaderBuilder<Persona>()
				.name("personaItemReader")
				.resource(new ClassPathResource(fileInput))
				.delimited()
				.names(new String[] {"id","nombrePersona","apellidoPersona","cedulaPersona","telefonoPersona"})
				.fieldSetMapper(new BeanWrapperFieldSetMapper<Persona>() {{
					setTargetType(Persona.class);
				}})
				.build();
	}
	
	@Bean
	public PersonaProcessor processor() {
		return new PersonaProcessor();
		
	}
	
	@Bean
	public PersonaWriter writer() {
		return new PersonaWriter();
	}
	
	@Bean
	public Job importPersonaJob(JobListener listener, Step step1) {
		return jobBuilderFactory.get("importPersonaJob")
				.listener(listener)
				.flow(step1)
				.end()
				.build();
	}
	
	@Bean
	public Step step1() {
		return stepBuilderFactory.get("step1")
				.<Persona, Persona> chunk(100)
				.reader(reader())
				.processor(processor())
				.writer(writer())
				.build();
	}
	
}
