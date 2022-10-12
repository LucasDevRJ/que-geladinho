package com.github.lucasdevrj.quegeladinho.spring.data.service;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.github.lucasdevrj.quegeladinho.spring.data.orm.Sorvete;
import com.github.lucasdevrj.quegeladinho.spring.data.repository.SorveteRepository;

@Service
public class CrudSorveteService {

	private final SorveteRepository sorveteRepository;

	public CrudSorveteService(SorveteRepository sorveteRepository) {
		this.sorveteRepository = sorveteRepository;
	}

	public void exibeMenu(Scanner entrada) {
		int opcao = 0;

		while (opcao == 0) {
			System.out.println("------------------------------|CRUD SORVETE|------------------------------");
			System.out.println("Opção 1 - Salvar Registro.");
			System.out.println("Ou qualquer número para voltar.");
			System.out.print("Digite a opção desejada: ");
			
			opcao = entrada.nextInt();
			if (opcao == 1) {
				salvar(entrada);
			} 
		}

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
}
