package com.izaiasvalentim.projeto_security_jwt.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "O campo login é obrigatório!")
    @Column(unique = true)
    private String login;
    @NotEmpty(message = "O campo login é obrigatório!")
    private String senha;
    private boolean admin;

    public Usuario() {
    }

    public Usuario( String login, String senha, boolean admin) {
        this.login = login;
        this.senha = senha;
        this.admin = admin;
    }

    public Usuario(Long id, String login, String senha, boolean admin) {
        this.id = id;
        this.login = login;
        this.senha = senha;
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}
