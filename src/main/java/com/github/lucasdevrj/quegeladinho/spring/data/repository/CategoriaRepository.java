package com.github.lucasdevrj.quegeladinho.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{
	
}
