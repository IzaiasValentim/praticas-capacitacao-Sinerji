package com.izaiasvalentim.vendasapplication.domain.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.izaiasvalentim.vendasapplication.domain.entity.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class Clientes {

    private JdbcTemplate jdbcTemplate;
    private EntityManager entityManager;

    public Clientes(JdbcTemplate jdbcTemplate, EntityManager entityManager) {
        this.jdbcTemplate = jdbcTemplate;
        this.entityManager = entityManager;
    }

    private static String INSERT = "INSERT INTO CLIENTE (NOME) VALUES ?";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";
    private static String UPDATE = "UPDATE CLIENTE SET NOME = ? WHERE ID = ?";
    private static String DELETE = "DELETE FROM CLIENTE WHERE ID = ?";

    @Transactional
    public Cliente salvar(Cliente cliente) {

        entityManager.persist(cliente);
        return cliente;
    }

    public List<Cliente> obterTodosOsClientes() {
        return entityManager
                .createQuery("from Cliente", Cliente.class).getResultList();
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscaClientesPorNome(String nome) {
        // JPQL é um pouco diferente do SQL. Ela referencia a entidade da classe e não a
        // tabela no DB.
        String jpql = "SELECT c from Cliente c WHERE c.nome like :nome";
        TypedQuery<Cliente> listaQuery = entityManager.createQuery(jpql, Cliente.class);
        listaQuery.setParameter("nome", "%" + nome + "%");
        return listaQuery.getResultList();
    }

    @Transactional
    public Cliente atualizarNomeCliente(Cliente cliente) {
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional
    public void deletar(Integer id) {

        Cliente procuraPorId = entityManager.find(Cliente.class, id);
        if (procuraPorId != null) {
            entityManager.remove(procuraPorId);
            System.out.printf("%s deletado com sucesso!\n", procuraPorId.getNome());
        } else {
            System.out.println("Nenhum cliente foi enctrado com este id: " + id);
        }
    }

}
