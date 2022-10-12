package com.github.lucasdevrj.quegeladinho.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Marca;

@Repository
public interface MarcaRepository extends CrudRepository<Marca, Integer>{

}
