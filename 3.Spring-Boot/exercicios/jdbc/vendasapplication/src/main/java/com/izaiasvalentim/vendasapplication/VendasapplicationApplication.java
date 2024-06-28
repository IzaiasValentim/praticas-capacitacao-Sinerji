package com.izaiasvalentim.vendasapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.izaiasvalentim.vendasapplication.domain.Repositories.Clientes;
import com.izaiasvalentim.vendasapplication.domain.entity.Cliente;

@SpringBootApplication
public class VendasapplicationApplication {
	// No momento os clientes são criados no CommandLineRunner
	@Bean
	public CommandLineRunner init(@Autowired Clientes clientes) {
		return args -> {
			// Criando dois clientes para testar as operações no banco.
			Cliente izaias = new Cliente();
			izaias.setNome("Izaias");
			clientes.salvar(izaias);

			var outroCliente = new Cliente();
			outroCliente.setNome("Excluível");
			clientes.salvar(outroCliente);

			System.out.println("Lista de clientes: ");
			clientes.obterTodosOsClientes().forEach(cliente -> {
				System.out.println(cliente);
			});

			System.out.println("Excluindo  Excluível e Modificando nome de Izaias.");
			izaias.setNome("Luis Izaias");
			izaias.setId(1);
			clientes.deletar(2);
			clientes.atualizarNomeCliente(izaias);
			System.out.println("Lista atualizada de clientes: ");
			
			clientes.obterTodosOsClientes().forEach(cliente -> {
				System.out.println(cliente);
			});

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasapplicationApplication.class, args);
	}

}
