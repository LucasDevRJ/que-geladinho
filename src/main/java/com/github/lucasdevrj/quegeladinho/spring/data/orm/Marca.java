package com.github.lucasdevrj.quegeladinho.spring.data.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marcas")
public class Marca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy = "marca")
	private List<Sorvete> sorvetes;
}
