package com.github.lucasdevrj.quegeladinho.spring.data;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.github.lucasdevrj.quegeladinho.spring.data.service.CrudCategoriaService;
import com.github.lucasdevrj.quegeladinho.spring.data.service.CrudMarcaService;
import com.github.lucasdevrj.quegeladinho.spring.data.service.CrudSaborService;
import com.github.lucasdevrj.quegeladinho.spring.data.service.CrudSorveteService;
import com.github.lucasdevrj.quegeladinho.spring.data.service.RelatorioService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private final CrudSorveteService crudSorveteService;
	private final CrudMarcaService crudMarcaService;
	private final CrudCategoriaService crudCategoriaService;
	private final CrudSaborService crudSaborService;
	private final RelatorioService relatorioService;
	private Boolean repeticao = true;

	public SpringDataApplication(CrudSorveteService crudSorveteService, CrudMarcaService crudMarcaService, CrudCategoriaService crudCategoriaService, CrudSaborService crudSaborService, RelatorioService relatorioService) {
		this.crudSorveteService = crudSorveteService;
		this.crudMarcaService = crudMarcaService;
		this.crudCategoriaService = crudCategoriaService;
		this.crudSaborService = crudSaborService;
		this.relatorioService = relatorioService;
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
			System.out.println("Opção 3 - Acessar CRUD da Categoria.");
			System.out.println("Opção 4 - Acessar CRUD do Sabor.");
			System.out.println("Opção 5 - Relatório.");
			System.out.println("Opção 6 - Sair.");
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
					this.crudCategoriaService.exibeMenu(entrada);
				break;
				
				case 4:
					this.crudSaborService.exibeMenu(entrada);
				break;
				
				case 5:
					this.relatorioService.exibeMenu(entrada);
				break;
				
				case 6:
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
