package com.fiap.aula4.model;

import javax.validation.constraints.Email;
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
	
	@NotBlank(message = "A propriedade nome não pode ser vazia")
	@Size(min = 3, max = 200, message = "O nome deve ter no mínimo 3 caracteres")
	private String nome;
	
	private String urlGitHub;
	
	private int numeroAtividade;

}
