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
			// As operações de CRUD estão sendo realizandas com o entityManager.

			// Criando duas instãncias de Cliente.
			Cliente izaias = new Cliente();
			izaias.setNome("Izaias");

			// Salvando izaias na base de dados por meio.
			clientes.salvar(izaias);

			var outroCliente = new Cliente();
			outroCliente.setNome("o Excluível");

			// Salvando outro cliente na base de dados.
			clientes.salvar(outroCliente);

			// Obtendo a lista de clientes na base de dados e a exibindo.
			System.out.println("1.Lista de clientes: ");
			clientes.obterTodosOsClientes().forEach(cliente -> {
				System.out.print(cliente);
			});
			// Excluindo outroCliente e alterando izaias na base de dados.
			System.out.println("\n\n2.Excluindo o Excluível e Modificando nome de Izaias.");
			izaias.setNome("Luis Izaias");
			izaias.setId(1);

			clientes.deletar(2);
			clientes.atualizarNomeCliente(izaias);

			System.out.println("\n\n3.Lista atualizada de clientes: ");

			// Mostrando a lista de clientes após as operações de atualização e delete.
			clientes.obterTodosOsClientes().forEach(cliente -> {
				System.out.println(cliente);
			});

			// Realizando uma consulta por nome
			System.out.println("\n\n4.Buscando pelo o nome 'Izaias' ");
			clientes.buscaClientesPorNome("Izaias").forEach(cliente -> {
				System.out.print("Ocorrência "+cliente);
			});

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasapplicationApplication.class, args);
	}

}
