package com.izaiasvalentim.vendasapplication.domain.Repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.izaiasvalentim.vendasapplication.domain.entity.Cliente;

@Repository
public class Clientes {

    private JdbcTemplate jdbcTemplate;

    public Clientes(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static String INSERT = "INSERT INTO CLIENTE (NOME) VALUES ?";
    private static String SELECT_ALL = "SELECT * FROM CLIENTE";
    private static String UPDATE = "UPDATE CLIENTE SET NOME = ? WHERE ID = ?";
    private static String DELETE = "DELETE FROM CLIENTE WHERE ID = ?";

    public Cliente salvar(Cliente cliente) {

        jdbcTemplate.update(INSERT, new Object[] { cliente.getNome() });

        return cliente;
    }

    public List<Cliente> obterTodosOsClientes() {
        return jdbcTemplate.query(SELECT_ALL, new RowMapper<Cliente>() {
            @Override
            public Cliente mapRow(ResultSet resultSet, int i) throws SQLException {
                return new Cliente(resultSet.getInt("ID"), resultSet.getString("NOME"));
            }
        });
    }

    public Cliente atualizarNomeCliente(Cliente cliente) {
        jdbcTemplate.update(UPDATE, new Object[] {
                cliente.getNome(), cliente.getId()
        });
        return cliente;
    }

    public void deletar(Integer id) {
        jdbcTemplate.update(DELETE, new Object[] { id });
    }

}
