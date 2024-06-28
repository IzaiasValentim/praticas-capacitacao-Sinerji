package com.izaiasvalentim.projeto_security_jwt.domain.entity.dto;

public class UsuarioRetornoDTO {
 
    private Long id;
    private String login;

    public UsuarioRetornoDTO(Long id, String login) {
        this.id = id;
        this.login = login;
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

    
}
