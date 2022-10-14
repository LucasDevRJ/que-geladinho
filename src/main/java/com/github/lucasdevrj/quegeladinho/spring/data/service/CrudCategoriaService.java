package com.github.lucasdevrj.quegeladinho.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Marca;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.CategoriaRepository;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.MarcaRepository;

@Service
public class CrudCategoriaService {

	private final CategoriaRepository categoriaRepository;
	private Boolean repeticao = true;

	public CrudCategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}

	public void exibeMenu(Scanner entrada) {
		while (repeticao) {
			System.out.println("------------------------------|CRUD MARCA|------------------------------");
			System.out.println("Opção 1 - Cadastrar Marca.");
			System.out.println("Opção 2 - Atualizar Marca.");
			System.out.println("Opção 3 - Deletar Marca.");
			System.out.println("Opção 4 - Exibir Marcas.");
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
		System.out.print("Digite o ID que deseja deletar a marca: ");
		Integer id = entrada.nextInt();
		this.marcaRepository.deleteById(id);
		
		System.out.println("Marca deletada com sucesso!");
	}
	
	public void exibir() {
		Iterable<Marca> sorvetes = this.marcaRepository.findAll();
		sorvetes.forEach(sorvete -> System.out.println(sorvete));
	}

	public void cadastrar(Scanner entrada) {
		System.out.print("Digite o nome da marca: ");
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
