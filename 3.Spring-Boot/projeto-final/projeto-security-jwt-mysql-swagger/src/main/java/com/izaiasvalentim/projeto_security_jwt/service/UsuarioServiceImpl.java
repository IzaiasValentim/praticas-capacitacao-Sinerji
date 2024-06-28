package com.izaiasvalentim.projeto_security_jwt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.izaiasvalentim.projeto_security_jwt.domain.entity.Usuario;
import com.izaiasvalentim.projeto_security_jwt.domain.entity.dto.UsuarioRetornoDTO;
import com.izaiasvalentim.projeto_security_jwt.domain.repositories.UsuarioRepository;
import com.izaiasvalentim.projeto_security_jwt.exception.SenhaInvalidaException;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

    @Autowired
    // Injeta uma instância de PasswordEncoder.
    private PasswordEncoder encoder;

    @Autowired
    // Injeta uma instância de UsuarioRepository.
    private UsuarioRepository usuarioRepository;

    // Autentica um usuário verificando seu login e senha.
    public UserDetails autenticar(Usuario usuario) {

        // Carrega os detalhes do usuário pelo login.
        UserDetails user = loadUserByUsername(usuario.getLogin());

        // Verifica se a senha fornecida corresponde à senha armazenada.
        boolean senhasBatem = encoder.matches(usuario.getSenha(), user.getPassword());

        if (senhasBatem) {
            // Retorna os detalhes do usuário se a senha estiver correta.
            return user;
        }

        // Lança uma exceção se a senha estiver incorreta.
        throw new SenhaInvalidaException();
    }

    @Transactional
    public UsuarioRetornoDTO salvarUsuario(Usuario usuario) {

        // Verifica se já existe um usuário com o mesmo login.
        if (usuarioRepository.findByLogin(usuario.getLogin()).isPresent()) {
            throw new RuntimeException("Já existe um usuário com este login.");
        }

        // Salva o usuário no banco de dados.
        Usuario usuarioCriado = usuarioRepository.save(usuario);

        // Retorna o DTO do usuario com o ID e login do usuário criado.
        return new UsuarioRetornoDTO(usuario.getId(), usuarioCriado.getLogin());
    }

    @Override
    // Carrega os detalhes do usuário pelo nome de usuário (login).
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // Procura o usuário no repositório pelo login.
        Usuario buscaUsuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com este login"));

        // Define as roles (perfis) do usuário com base em seu status de administrador.
        String[] roles = buscaUsuario.isAdmin() ? new String[] { "ADMIN", "USER" } : new String[] { "USER" };

        // Retorna um objeto User com os detalhes do usuário e suas roles.
        return User
                .builder()
                .username(buscaUsuario.getLogin())
                .password(buscaUsuario.getSenha())
                .roles(roles)
                .build();
    }

}
