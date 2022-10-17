package com.github.lucasdevrj.quegeladinho.spring.data.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Sorvete;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.SorveteRepository;

@Service
public class RelatorioService {

	private Boolean repeticao = true;
	private final SorveteRepository sorveteRepository;

	public RelatorioService(SorveteRepository sorveteRepository) {
		this.sorveteRepository = sorveteRepository;
	}

	public void exibeMenu(Scanner entrada) {
		while (repeticao) {
			System.out.println("------------------------------|CRUD SORVETE|------------------------------");
			System.out.println("Opção 1 - Pesquisar sorvete por nome.");
			System.out.println("Opção 2 - Pesquisar sorvete por ID.");
			System.out.println("Opção 3 - Pesquisar sorvete pelo preço.");
			System.out.println("Opção 4 - Pesquisar sorvete pelo sabor.");
			System.out.println("Opção 5 - Pesquisar sorvete pela categoria.");
			System.out.println("Ou qualquer número para voltar.");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("Digite a opção desejada: ");

			int opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				pesquisarSorveteNome(entrada);
			break;
			
			case 2:
				pesquisarSorveteId(entrada);
			break;
			
			case 3:
				pesquisarSorveteMenorIgualPreco(entrada);
			break;
			
			case 4:
				pesquisarSorveteSabor(entrada);
			break;
			
			case 5:
				pesquisarSorveteCategoria(entrada);
			break;
			
			default:
				repeticao = false;
				break;
			}
		}
	}
	
	private void pesquisarSorveteNome(Scanner entrada) {
		System.out.print("Digite o nome do sorvete: ");
		String nome = entrada.next();
		
		List<Sorvete> lista = this.sorveteRepository.findByNome(nome);
		lista.forEach(nomes -> System.out.println(nomes));
	}
	
	private void pesquisarSorveteId(Scanner entrada) {
		System.out.print("Digite o ID do sorvete: ");
		Integer id = entrada.nextInt();
		
		if (this.sorveteRepository.existsById(id)) {
			Optional<Sorvete> sorvete = this.sorveteRepository.findById(id);
			System.out.println(sorvete);
		} else {
			System.out.println("ID inexistente!");
		}
	}
	
	private void pesquisarSorveteMenorIgualPreco(Scanner entrada) {
		System.out.print("Digite o preço do sorvete: ");
		Float preco = entrada.nextFloat();
		
		List<Sorvete> lista = this.sorveteRepository.findByPrecoLessThanEqual(preco);
		lista.forEach(nomes -> System.out.println(nomes));
	}
	
	private void pesquisarSorveteSabor(Scanner entrada) {
		System.out.print("Digite o sabor do sorvete: ");
		String sabor = entrada.next();
		
		List<Sorvete> lista = this.sorveteRepository.findBySabor(sabor);
		lista.forEach(sabores -> System.out.println(sabores));
	}
	
	private void pesquisarSorveteCategoria(Scanner entrada) {
		System.out.print("Digite a categoria do sorvete: ");
		String categoria = entrada.next();
		
		List<Sorvete> lista = this.sorveteRepository.findByCategoria(categoria);
		lista.forEach(categorias -> System.out.println(categorias));
	}
	
}
