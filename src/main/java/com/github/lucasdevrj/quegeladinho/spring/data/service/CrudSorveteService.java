package com.github.lucasdevrj.quegeladinho.spring.data.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Categoria;
import com.github.lucasdevrj.quegeladinho.spring.data.orm.Sorvete;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.CategoriaRepository;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.MarcaRepository;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.SaborRepository;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.SorveteRepository;

@Service
public class CrudSorveteService {

	private final SorveteRepository sorveteRepository;
	private final CategoriaRepository categoriaRepository;
	private final MarcaRepository marcaRepository;
	private final SaborRepository saborRepository;
	
	public CrudSorveteService(SorveteRepository sorveteRepository, CategoriaRepository categoriaRepository,
			MarcaRepository marcaRepository, SaborRepository saborRepository) {
		this.sorveteRepository = sorveteRepository;
		this.categoriaRepository = categoriaRepository;
		this.marcaRepository = marcaRepository;
		this.saborRepository = saborRepository;
	}

	private Boolean repeticao = true;

	
	public void exibeMenu(Scanner entrada) {
		while (repeticao) {
			System.out.println("------------------------------|CRUD SORVETE|------------------------------");
			System.out.println("Opção 1 - Cadastrar Sorvete.");
			System.out.println("Opção 2 - Atualizar Sorvete.");
			System.out.println("Opção 3 - Deletar Sorvete.");
			System.out.println("Opção 4 - Exibir Sorvetes.");
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
		System.out.print("Digite o ID que deseja deletar o sorvete: ");
		Integer id = entrada.nextInt();
		
		if (this.sorveteRepository.existsById(id)) {
			System.out.println("Sorvete deletado com sucesso!");
			this.sorveteRepository.deleteById(id);
		} else {
			System.out.println("ID inexistente!");
		}
	}
	
	public void exibir() {
		if (this.sorveteRepository.count() > 0) {
			Iterable<Sorvete> sorvetes = this.sorveteRepository.findAll();
			sorvetes.forEach(sorvete -> System.out.println(sorvete));
		} else {
			System.out.println("Não existem sorvetes cadastrados!");
		}
	}

	public void cadastrar(Scanner entrada) {
		System.out.print("Digite o nome do sorvete: ");
		String nome = entrada.next();

		System.out.print(this.categoriaRepository.getClass().toString() + "\nDigite a categoria do sorvete: ");
		Integer categoriaId = entrada.nextInt();

		System.out.print("Digite a quantidade (em litros) do sorvete: ");
		Double litros = entrada.nextDouble();

		System.out.print("Digite o preço do sorvete: ");
		Float preco = entrada.nextFloat();

		System.out.print("Digite a marca do sorvete: ");
		String marca = entrada.next();

		System.out.print("Digite o sabor do sorvete: ");
		String sabor = entrada.next();

		Sorvete sorvete = new Sorvete();
		sorvete.setNome(nome);
		Optional<Categoria> categoria = this.categoriaRepository.findById(categoriaId);
		sorvete.setCategoria(categoria.get());
		sorvete.setLitros(litros);
		sorvete.setPreco(preco);
		sorvete.setMarca(marca);
		sorvete.setSabor(sabor);

		sorveteRepository.save(sorvete);

		System.out.println("Sorvete salvo com sucesso!");
	}
	
	public void atualizar(Scanner entrada) {
		System.out.println("Digite o ID que deseja atualizar o sorvete: ");
		Integer id = entrada.nextInt();
		
		if (this.sorveteRepository.existsById(id)) {
			System.out.print("Digite o nome do sorvete: ");
			String nome = entrada.next();

			System.out.print("Digite a categoria do sorvete: ");
			String categoria = entrada.next();

			System.out.print("Digite a quantidade (em litros) do sorvete: ");
			Double litros = entrada.nextDouble();

			System.out.print("Digite o preço do sorvete: ");
			Float preco = entrada.nextFloat();

			System.out.print("Digite a marca do sorvete: ");
			String marca = entrada.next();

			System.out.print("Digite o sabor do sorvete: ");
			String sabor = entrada.next();
			
			Sorvete sorvete = new Sorvete();
			sorvete.setId(id);
			sorvete.setNome(nome);
			sorvete.setCategoria(categoria);
			sorvete.setLitros(litros);
			sorvete.setPreco(preco);
			sorvete.setMarca(marca);
			sorvete.setSabor(sabor);
			
			sorveteRepository.save(sorvete);

			System.out.println("Sorvete atualizado com sucesso!");
		} else {
			System.out.println("ID inexistente!");
		}
	}
}
