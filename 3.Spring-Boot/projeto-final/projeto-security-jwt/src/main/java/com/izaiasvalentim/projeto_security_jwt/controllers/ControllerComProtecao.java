package com.izaiasvalentim.projeto_security_jwt.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * ControllerComProtecao disponibiliza o acesso a duas rotas distintas.
 *  - /home/say-hello-secured é do tipo GET e só será acessado caso o usuário seja um Admin.
 *  - /home/say-hello-free é do tipo GET e possui acesso livre para qualquer usuário autenticado.
 */

@RestController
@RequestMapping("home")
public class ControllerComProtecao {

    @GetMapping("say-hello-secured")
    public String sayHelloSecuredPath() {
        return new String("Hello World! Protegido - Acesso apenas para ADMIN!");
    }

    @GetMapping("say-hello-free")
    public String sayHelloPath() {
        return new String("Hello World! Livre - Acesso para todos os usuários!");
    }

}
