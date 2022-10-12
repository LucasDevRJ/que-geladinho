package com.github.lucasdevrj.quegeladinho.spring.data;

import java.util.Scanner;

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
		Scanner entrada = new Scanner(System.in);
		int opcao = 0;
		
		do {
			
			System.out.println("------------------------------|MENU SORVETE|------------------------------");
			System.out.println("Opção 1 - Salvar Registro.");
			System.out.println("Opção 2 - Sair.");			
			System.out.print("Digite a opção desejada: ");
			opcao = entrada.nextInt();
		} while (opcao != 2);
		
		Sorvete sorvete = new Sorvete();
		sorvete.setNome("Magnum");
		sorvete.setCategoria("Picolé");
		sorvete.setLitros(0.182);
		sorvete.setPreco(8.00f);
		sorvete.setMarca("Magnum");
		sorvete.setSabor("Chocolate");
		
		sorveteRepository.save(sorvete);
	}

}
