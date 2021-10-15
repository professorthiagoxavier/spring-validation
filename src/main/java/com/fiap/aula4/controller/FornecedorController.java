package com.fiap.aula4.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.aula4.model.Fornecedor;
import com.fiap.aula4.repository.FornecedorRepository;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	@GetMapping
	public ResponseEntity<List<Fornecedor>> getAll() {
		List<Fornecedor> result = fornecedorRepository.findAll();

		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Fornecedor> post(@RequestBody @Valid Fornecedor fornecedor) {
		Fornecedor fornecedorSalvo = fornecedorRepository.save(fornecedor);
		return new ResponseEntity<Fornecedor>(fornecedorSalvo, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> put(@PathVariable String id, @RequestBody @Valid Fornecedor fornecedor) {
		Optional<Fornecedor> fornecedorOptional = fornecedorRepository.findById(id);
		
		if(!fornecedorOptional.isPresent()) {
			return new ResponseEntity<Fornecedor>(HttpStatus.NOT_FOUND);
		}
		
		Fornecedor fornecedoSalvo =  fornecedorRepository.save(fornecedor);
		
		return new ResponseEntity<Fornecedor>(fornecedoSalvo, HttpStatus.OK);
	}

	// Criar update e delete

}
