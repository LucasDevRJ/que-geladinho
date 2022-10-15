package com.github.lucasdevrj.quegeladinho.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

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
			System.out.println("Ou qualquer número para voltar.");
			System.out.println("----------------------------------------------------------------------------");
			System.out.print("Digite a opção desejada: ");

			int opcao = entrada.nextInt();

			switch (opcao) {
			case 1:
				cadastrar(entrada);
				break;

			default:
				repeticao = false;
				break;
			}
		}
	}
	
	private void pesquisarSorveteNome() {
		
	}
}
