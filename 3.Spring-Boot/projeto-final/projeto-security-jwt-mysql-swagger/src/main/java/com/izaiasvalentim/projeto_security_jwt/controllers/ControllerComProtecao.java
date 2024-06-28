package com.izaiasvalentim.projeto_security_jwt.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api("Api com acesso controlado")
public class ControllerComProtecao {

    @GetMapping("say-hello-secured")
    @ApiOperation("Acesso disponível apenas para administradores")
    public String sayHelloSecuredPath() {
        return new String("Hello World! Protegido - Acesso apenas para ADMIN!");
    }

    @GetMapping("say-hello-free")
    @ApiOperation("Acesso livre :)")
    public String sayHelloPath() {
        return new String("Hello World! Livre - Acesso para todos os usuários!");
    }

}
