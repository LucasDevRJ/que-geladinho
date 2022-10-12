package com.github.lucasdevrj.quegeladinho.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Sorvete;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.SorveteRepository;

@Service
public class CrudSorveteService {

	private final SorveteRepository sorveteRepository;
	private Boolean repeticao = true;

	public CrudSorveteService(SorveteRepository sorveteRepository) {
		this.sorveteRepository = sorveteRepository;
	}

	public void exibeMenu(Scanner entrada) {
		while (repeticao) {
			System.out.println("------------------------------|CRUD SORVETE|------------------------------");
			System.out.println("Opção 1 - Salvar Sorvete.");
			System.out.println("Opção 2 - Atualizar Sorvete.");
			System.out.println("Opção 3 - Deletar Sorvete.");
			System.out.println("Opção 4 - Exibir Sorvetes.");
			System.out.println("Ou qualquer número para voltar.");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("Digite a opção desejada: ");
			
			int opcao = entrada.nextInt();
			
			switch (opcao) {
			case 1:
				salvar(entrada);
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
		this.sorveteRepository.deleteById(id);
		
		System.out.println("Sorvete deletado com sucesso!");
	}
	
	public void exibir() {
		Iterable<Sorvete> sorvetes = this.sorveteRepository.findAll();
		sorvetes.forEach(sorvete -> System.out.println(sorvete));
	}

	public void salvar(Scanner entrada) {
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
		sorvete.setNome(nome);
		sorvete.setCategoria(categoria);
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
	}
}
