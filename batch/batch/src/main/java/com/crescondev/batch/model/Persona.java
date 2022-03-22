package com.crescondev.batch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "persona", schema = "batch-db")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Persona {
	
	@Id
	private long id;
	
	@Column(name = "nombre")
	private String nombrePersona;
	
	@Column(name = "apellido")
	private String apellidoPersona;
	
	@Column(name = "cedula")
	private String cedulaPersona;
	
	@Column(name = "telefono")
	private String telefonoPersona;

}
