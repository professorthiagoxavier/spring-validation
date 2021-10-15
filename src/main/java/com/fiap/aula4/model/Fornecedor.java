package com.fiap.aula4.model;

import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Fornecedor {

	@Id
	private String id; 
	
	@NotNull(message = "O campo nome é obrigatório")
	private String nome; 
	
	@NotNull(message = "O campo endereço é obrigatório")
	private String endereco; 
	
	private String email; 
	private Integer cnpj; 
	
}
