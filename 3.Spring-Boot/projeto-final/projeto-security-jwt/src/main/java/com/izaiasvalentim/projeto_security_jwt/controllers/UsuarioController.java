package com.izaiasvalentim.projeto_security_jwt.controllers;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.izaiasvalentim.projeto_security_jwt.domain.entity.Usuario;
import com.izaiasvalentim.projeto_security_jwt.domain.entity.dto.CredenciaisDTO;
import com.izaiasvalentim.projeto_security_jwt.domain.entity.dto.TokenDTO;
import com.izaiasvalentim.projeto_security_jwt.domain.entity.dto.UsuarioRetornoDTO;
import com.izaiasvalentim.projeto_security_jwt.exception.SenhaInvalidaException;
import com.izaiasvalentim.projeto_security_jwt.service.JwtService;
import com.izaiasvalentim.projeto_security_jwt.service.UsuarioServiceImpl;

/*
 * Usuariocontroller implementa as rotas públicas de cadastro e autenticação do usuário.
 * - Nesta aplicação a autenticação é realizada por meio de token JWT.
 */

@RestController
@RequestMapping("/home/usuarios")
public class UsuarioController {

    private final UsuarioServiceImpl usuarioServiceImpl;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    // Injeção de dependências via construtor.
    public UsuarioController(UsuarioServiceImpl usuarioServiceImpl, PasswordEncoder passwordEncoder,
            JwtService jwtService) {
        this.usuarioServiceImpl = usuarioServiceImpl;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioRetornoDTO salvarUsuario(@RequestBody @Valid Usuario usuario) {

        String senhaProtegida = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaProtegida);

        return usuarioServiceImpl.salvarUsuario(usuario);
    }

    @PostMapping("/auth-token")
    public TokenDTO autenticar(@RequestBody CredenciaisDTO credenciaisDTO) {
        try {
            Usuario user = new Usuario();
            user.setLogin(credenciaisDTO.getLogin());
            user.setSenha(credenciaisDTO.getSenha());
            UserDetails usuarioAutenticado = usuarioServiceImpl.autenticar(user);
            String token = jwtService.gerarToken(user);
            return new TokenDTO(user.getLogin(), token);

        } catch (UsernameNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        } catch (SenhaInvalidaException e) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}
