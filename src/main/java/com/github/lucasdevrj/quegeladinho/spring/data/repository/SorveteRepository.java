package com.github.lucasdevrj.quegeladinho.spring.data.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Sorvete;

@Repository
public interface SorveteRepository extends CrudRepository<Sorvete, Integer>{

	List<Sorvete> findByNome(String nome);
}
