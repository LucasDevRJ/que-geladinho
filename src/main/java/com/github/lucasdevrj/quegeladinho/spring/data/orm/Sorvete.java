package com.github.lucasdevrj.quegeladinho.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sorvetes")
public class Sorvete {

	@Id
	private Integer id;
	private String nome;
	private Double litros;
	private String marca;
	private String categoria;
	private String sabor;
	private Float preco;
}
