package com.fiap.aula4.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Atividade {
	
	@Id
	private String id;
	
	@NotNull(message = "Preencher a matricula")
	private Integer rm; 
	
	@NotNull(message = "O campo nome não pode ser nulo")
	private String nome;
	
	private String urlGitHub;
	
	private int numeroAtividade;

}
