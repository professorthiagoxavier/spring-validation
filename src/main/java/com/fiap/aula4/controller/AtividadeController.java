package com.fiap.aula4.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.aula4.model.Atividade;
import com.fiap.aula4.repository.AtividadeRepository;

import lombok.var;

@RestController
@RequestMapping("/atividade")
public class AtividadeController {
	
	@Autowired
	private AtividadeRepository atividadeRepository; 
	
	@GetMapping()
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<Page<Atividade>> get(Pageable page){
		
		Page<Atividade> result = atividadeRepository.findAll(page);
		
		return new ResponseEntity<Page<Atividade>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAnyRole('ADMIN')")
	public ResponseEntity<List<Atividade>> getAll(){
		
		List<Atividade> result = atividadeRepository.findAll();
		
		return new ResponseEntity<List<Atividade>>(result, HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Atividade> post(@RequestBody @Valid Atividade atividade) {
		
		var result = atividadeRepository.save(atividade);
		
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

}
