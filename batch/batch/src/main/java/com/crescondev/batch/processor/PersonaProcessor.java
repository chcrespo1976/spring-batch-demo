package com.crescondev.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import com.crescondev.batch.model.Persona;

public class PersonaProcessor implements ItemProcessor<Persona, Persona> {
	
	private static final Logger LOG = LoggerFactory.getLogger(PersonaProcessor.class);

	@Override
	public Persona process(Persona item) throws Exception {
		LOG.info("Procesando el registro : {}", item);
		
		return Persona
				.builder()
				.id(item.getId())
				.nombrePersona(item.getNombrePersona())
				.apellidoPersona(item.getApellidoPersona())
				.cedulaPersona(item.getCedulaPersona())
				.telefonoPersona(item.getTelefonoPersona())
				.build();

	}

}
