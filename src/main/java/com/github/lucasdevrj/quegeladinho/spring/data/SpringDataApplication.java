package com.github.lucasdevrj.quegeladinho.spring.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Categoria;
import com.github.lucasdevrj.quegeladinho.spring.data.orm.Marca;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.CategoriaRepository;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.MarcaRepository;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.SaborRepository;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.SorveteRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	private final SorveteRepository sorveteRepository;
	private final MarcaRepository marcaRepository;
	private final CategoriaRepository categoriaRepository;
	private final SaborRepository saborRepository;
	
	public SpringDataApplication(SorveteRepository sorveteRepository, MarcaRepository marcaRepository,
			CategoriaRepository categoriaRepository, SaborRepository saborRepository) {
		this.sorveteRepository = sorveteRepository;
		this.marcaRepository = marcaRepository;
		this.categoriaRepository = categoriaRepository;
		this.saborRepository = saborRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Marca marca = new Marca();
		marca.setNome("Magnum");
		
		Categoria categoria = new Categoria();
		categoria.setNome("Massa");
	}

}
