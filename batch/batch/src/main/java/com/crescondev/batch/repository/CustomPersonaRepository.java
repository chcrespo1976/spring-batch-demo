package com.crescondev.batch.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.crescondev.batch.model.Persona;

import lombok.RequiredArgsConstructor;

@Repository("customPersonaRepository")
@RequiredArgsConstructor
public class CustomPersonaRepository implements PersonaRepository {
	
	private final PersonaRepository personaRepository;

	@Override
	public <S extends Persona> S save(S entity) {
		return personaRepository.save(entity);
	}

	@Override
	public <S extends Persona> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Persona> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Persona> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Persona> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Persona entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Persona> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}
