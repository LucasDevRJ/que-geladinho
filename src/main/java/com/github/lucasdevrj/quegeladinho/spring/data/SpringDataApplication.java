package com.github.lucasdevrj.quegeladinho.spring.data;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.lucasdevrj.quegeladinho.spring.data.service.CrudCategoriaService;
import com.github.lucasdevrj.quegeladinho.spring.data.service.CrudMarcaService;
import com.github.lucasdevrj.quegeladinho.spring.data.service.CrudSorveteService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudSorveteService crudSorveteService;
	private final CrudMarcaService crudMarcaService;
	private final CrudCategoriaService crudCategoriaService;
	private Boolean repeticao = true;

	public SpringDataApplication(CrudSorveteService crudSorveteService, CrudMarcaService crudMarcaService, CrudCategoriaService crudCategoriaService) {
		this.crudSorveteService = crudSorveteService;
		this.crudMarcaService = crudMarcaService;
		this.crudCategoriaService = crudCategoriaService;
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
			System.out.println("Opção 2 - Acessar CRUD da Marca.");
			System.out.println("Opção 3 - Sair.");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("Digite a opção desejada: ");
			
			try {
				int opcao = entrada.nextInt();
				
				switch (opcao) {
				case 1:
					this.crudSorveteService.exibeMenu(entrada);
				break;
				
				case 2:
					this.crudMarcaService.exibeMenu(entrada);
				break;
				
				case 3:
					finalizaPrograma();
				break;

				default:
					System.out.println("Opção inválida!");
				break;
				}
			} catch (InputMismatchException erro) {
				erro.printStackTrace();
				run(args);
			}
		
		}

	}

	public void finalizaPrograma() {
		System.out.println("Programa finalizado.");
		this.repeticao = false;
	}

}
