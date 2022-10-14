package com.github.lucasdevrj.quegeladinho.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Categoria;
import com.github.lucasdevrj.quegeladinho.spring.data.orm.Sabor;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.SaborRepository;

@Service
public class CrudSaborService {

	private final SaborRepository saborRepository;
	private Boolean repeticao = true;

	public CrudSaborService(SaborRepository saborRepository) {
		this.saborRepository = saborRepository;
	}

	public void exibeMenu(Scanner entrada) {
		while (repeticao) {
			System.out.println("------------------------------|CRUD SABOR|------------------------------");
			System.out.println("Opção 1 - Cadastrar Sabor.");
			System.out.println("Opção 2 - Atualizar Sabor.");
			System.out.println("Opção 3 - Deletar Sabor.");
			System.out.println("Opção 4 - Exibir Sabores.");
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
		System.out.print("Digite o ID que deseja deletar o sabor: ");
		Integer id = entrada.nextInt();
		this.saborRepository.deleteById(id);
		
		System.out.println("Sabor deletado com sucesso!");
	}
	
	public void exibir() {
		Iterable<Sabor> sabores = this.saborRepository.findAll();
		sabores.forEach(sabor -> System.out.println(sabor));
	}

	public void cadastrar(Scanner entrada) {
		System.out.print("Digite o nome do sabor: ");
		String nome = entrada.next();

		Sabor sabor = new Sabor();
		sabor.setNome(nome);
		
		this.saborRepository.save(sabor);

		System.out.println("Sabor salvo com sucesso!");
	}
	
	public void atualizar(Scanner entrada) {
		System.out.println("Digite o ID que deseja atualizar o sabor: ");
		Integer id = entrada.nextInt();
		
		System.out.print("Digite o nome do sabor: ");
		String nome = entrada.next();
		
		Sabor sabor = new Sabor();
		sabor.setId(id);
		sabor.setNome(nome);
		
		this.saborRepository.save(sabor);

		System.out.println("Sabor atualizado com sucesso!");
	}
}
