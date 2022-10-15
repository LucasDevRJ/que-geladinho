package com.github.lucasdevrj.quegeladinho.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

@Service
public class RelatorioService {

	private Boolean repeticao = true;

	public void exibeMenu(Scanner entrada) {
		while (repeticao) {
			System.out.println("------------------------------|CRUD SORVETE|------------------------------");
			System.out.println("Opção 1 - Pesquisar sorvete por nome.");
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
}
