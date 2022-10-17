package com.github.lucasdevrj.quegeladinho.spring.data.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Sorvete;

@Repository
public interface SorveteRepository extends CrudRepository<Sorvete, Integer>{

	List<Sorvete> findByNome(String nome);
	
	@Query("SELECT s FROM Sorvete s WHERE s.sabor.nome = :sabor")
	List<Sorvete> findBySabor(String sabor);
	
	Optional<Sorvete> findById(Integer id);
	
	List<Sorvete> findByPrecoLessThanEqual(Float preco);
}
