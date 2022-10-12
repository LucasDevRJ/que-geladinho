package com.github.lucasdevrj.quegeladinho.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Sabor;

@Repository
public interface SaborRepository extends CrudRepository<Sabor, Integer>{

}
