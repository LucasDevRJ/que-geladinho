package com.github.lucasdevrj.quegeladinho.spring.data.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@OneToMany(mappedBy = "categoria")
	private List<Sorvete> sorvetes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Sorvete> getSorvetes() {
		return sorvetes;
	}

	public void setSorvetes(List<Sorvete> sorvetes) {
		this.sorvetes = sorvetes;
	}
}
