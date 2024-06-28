package com.izaiasvalentim.vendasapplication.domain.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.izaiasvalentim.vendasapplication.domain.entity.Cliente;

@Repository
public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
    // Realiza uma busca de  clientes pelo nome.
    List<Cliente> findByNomeLike(String nome);

    // Realiza a mesma pesquisa acima, mas por meio da query jpql.
    @Query(value = "select c from Cliente c where c.nome like :nome")
    List<Cliente> procuraClientePorNome(@Param("nome") String nome);

    // Carregar os pedidos de um cliente
    @Query(" select c from Cliente c left join fetch c.pedidos where c.id =:id")
    Cliente findClientFetchPedidos(@Param("id") Integer id);
    
}
