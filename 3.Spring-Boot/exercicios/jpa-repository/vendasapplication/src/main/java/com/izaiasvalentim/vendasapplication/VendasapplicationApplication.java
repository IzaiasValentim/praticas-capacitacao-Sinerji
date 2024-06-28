package com.izaiasvalentim.vendasapplication;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.izaiasvalentim.vendasapplication.domain.Repositories.ClientesRepository;
import com.izaiasvalentim.vendasapplication.domain.Repositories.PedidoRepository;
import com.izaiasvalentim.vendasapplication.domain.entity.Cliente;
import com.izaiasvalentim.vendasapplication.domain.entity.Pedido;

@SpringBootApplication
public class VendasapplicationApplication {
	// No momento os clientes são criados no CommandLineRunner
	@Bean
	public CommandLineRunner init(@Autowired ClientesRepository clientes,
			@Autowired PedidoRepository pedidoRepository) {
		return args -> {
			// As operações de CRUD estão sendo realizandas com o JpaRepository.

			// Criando duas instãncias de Cliente.
			Cliente izaias = new Cliente();
			izaias.setNome("Izaias");

			// Salvando izaias na base de dados por meio.
			clientes.save(izaias);

			var outroCliente = new Cliente();
			outroCliente.setNome("o Excluível");

			// Salvando outro cliente na base de dados.
			clientes.save(outroCliente);

			// Obtendo a lista de clientes na base de dados e a exibindo.
			System.out.println("1.Lista de clientes: ");
			clientes.findAll().forEach(cliente -> {
				System.out.print(cliente);
			});
			// Excluindo outroCliente e alterando izaias na base de dados.
			System.out.println("\n\n2.Excluindo o Excluível e Modificando nome de Izaias.");
			izaias.setNome("Luis Izaias");
			izaias.setId(1);

			clientes.deleteById(2);
			clientes.save(izaias);

			System.out.println("\n\n3.Lista atualizada de clientes: ");

			// Mostrando a lista de clientes após as operações de atualização e delete.
			clientes.findAll().forEach(cliente -> {
				System.out.println(cliente);
			});

			// Realizando uma consulta por nome
			System.out.println("\n\n4.Buscando pelo o nome ' Luis Izaias' ");
			clientes.procuraClientePorNome("Luis Izaias").forEach(cliente -> {
				System.out.print("Ocorrência " + cliente);
			});

			Pedido p = new Pedido();
			p.setCliente(izaias);
			p.setDataPedido(LocalDate.now());
			p.setTotal(BigDecimal.valueOf(10));
			pedidoRepository.save(p);

			clientes.findClientFetchPedidos(izaias.getId()).getPedidos().forEach(pedido->{
				System.out.println(pedido);
			});

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(VendasapplicationApplication.class, args);
	}

}
