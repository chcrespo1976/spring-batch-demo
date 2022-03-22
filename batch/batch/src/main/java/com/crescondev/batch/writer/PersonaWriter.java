package com.crescondev.batch.writer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import com.crescondev.batch.model.Persona;
import com.crescondev.batch.repository.PersonaRepository;

public class PersonaWriter implements ItemWriter<Persona> {
	
	private static final Logger LOG = LoggerFactory.getLogger(PersonaWriter.class);
	
	@Autowired
	PersonaRepository personaRepository;
	
	public void write(List<? extends Persona> items) throws Exception {
		LOG.info("Escribiendo los registros {}", items);
		for(Persona item: items) {
			Persona persona = Persona
					.builder()
					.id(item.getId())
					.nombrePersona(item.getNombrePersona())
					.apellidoPersona(item.getApellidoPersona())
					.cedulaPersona(item.getCedulaPersona())
					.telefonoPersona(item.getTelefonoPersona())
					.build();
			personaRepository.save(persona);
		}
	}

}
