package com.github.lucasdevrj.quegeladinho.spring.data;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.lucasdevrj.quegeladinho.spring.data.service.CrudSorveteService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudSorveteService crudSorveteService;
	private Boolean repeticao = true;

	public SpringDataApplication(CrudSorveteService crudSorveteService) {
		this.crudSorveteService = crudSorveteService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		Scanner entrada = new Scanner(System.in);
		
		while (repeticao) {
			System.out.println("------------------------------|MENU PRINCIPAL|------------------------------");
			System.out.println("Opção 1 - Acessar CRUD do Sorvete.");
			System.out.println("Opção 2 - Sair.");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("Digite a opção desejada: ");
			
			try {
				int opcao = entrada.nextInt();
				
				if (opcao == 1) {
					this.crudSorveteService.exibeMenu(entrada);
				} else if (opcao == 2) {
					System.out.println("Programa finalizado.");
					this.repeticao = false;
				} else {
					System.out.println("Opção inválida!");
				}
			} catch (InputMismatchException erro) {
				erro.printStackTrace();
				erro.getMessage();
				run(args);
			}
		
		}

	}

}
