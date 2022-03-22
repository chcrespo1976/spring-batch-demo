package com.crescondev.batch.repository;

import org.springframework.data.repository.CrudRepository;

import com.crescondev.batch.model.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Long> {
	

}
