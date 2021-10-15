package com.fiap.aula4.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.fiap.aula4.model.Fornecedor;

public interface FornecedorRepository extends MongoRepository<Fornecedor, String> {

}
