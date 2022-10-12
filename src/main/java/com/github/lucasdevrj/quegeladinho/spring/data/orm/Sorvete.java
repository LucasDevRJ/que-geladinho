package com.github.lucasdevrj.quegeladinho.spring.data.orm;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sorvetes")
public class Sorvete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Double litros;
	private String marca;
	private String categoria;
	private String sabor;
	private Float preco;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Double getLitros() {
		return litros;
	}
	
	public void setLitros(Double litros) {
		this.litros = litros;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	
	public String getSabor() {
		return sabor;
	}
	
	public Float getPreco() {
		return preco;
	}
	
	public void setPreco(Float preco) {
		this.preco = preco;
	}
}
