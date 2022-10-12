package com.github.lucasdevrj.quegeladinho.spring.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Sorvete;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.SorveteRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner{
	
	private final SorveteRepository sorveteRepository;

	public SpringDataApplication(SorveteRepository sorveteRepository) {
		this.sorveteRepository = sorveteRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Sorvete sorvete = new Sorvete();
		
		
		sorveteRepository.save(sorvete);
	}

}
