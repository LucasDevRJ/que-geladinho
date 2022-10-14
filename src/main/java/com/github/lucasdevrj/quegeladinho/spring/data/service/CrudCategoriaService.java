package com.github.lucasdevrj.quegeladinho.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Categoria;
import com.github.lucasdevrj.quegeladinho.spring.data.orm.Marca;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.CategoriaRepository;

@Service
public class CrudCategoriaService {

	private final CategoriaRepository categoriaRepository;
	private Boolean repeticao = true;

	public CrudCategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public void exibeMenu(Scanner entrada) {
		while (repeticao) {
			System.out.println("------------------------------|CRUD CATEGORIA|------------------------------");
			System.out.println("Opção 1 - Cadastrar Categoria.");
			System.out.println("Opção 2 - Atualizar Categoria.");
			System.out.println("Opção 3 - Deletar Categoria.");
			System.out.println("Opção 4 - Exibir Categorias.");
			System.out.println("Ou qualquer número para voltar.");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("Digite a opção desejada: ");
			
			int opcao = entrada.nextInt();
			
			switch (opcao) {
			case 1:
				cadastrar(entrada);
			break;
			
			case 2:
				atualizar(entrada);
			break;
			
			case 3:
				deletar(entrada);
			break;
			
			case 4:
				exibir();
			break;

			default:
				repeticao = false;
			break;
			}
		}

	}

	public void deletar(Scanner entrada) {
		System.out.print("Digite o ID que deseja deletar a categoria: ");
		Integer id = entrada.nextInt();
		this.categoriaRepository.deleteById(id);
		
		System.out.println("Categoria deletada com sucesso!");
	}
	
	public void exibir() {
		Iterable<Categoria> categorias = this.categoriaRepository.findAll();
		categorias.forEach(categoria -> System.out.println(categoria));
	}

	public void cadastrar(Scanner entrada) {
		System.out.print("Digite o nome da categoria: ");
		String nome = entrada.next();

		Marca marca = new Marca();
		marca.setNome(nome);
		
		marcaRepository.save(marca);

		System.out.println("Marca salva com sucesso!");
	}
	
	public void atualizar(Scanner entrada) {
		System.out.println("Digite o ID que deseja atualizar a marca: ");
		Integer id = entrada.nextInt();
		
		System.out.print("Digite o nome da marca: ");
		String nome = entrada.next();
		
		Marca marca = new Marca();
		marca.setId(id);
		marca.setNome(nome);
		
		marcaRepository.save(marca);

		System.out.println("Marca atualizada com sucesso!");
	}
}
