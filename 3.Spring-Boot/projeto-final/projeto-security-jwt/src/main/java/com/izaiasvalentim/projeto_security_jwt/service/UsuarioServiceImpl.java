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
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public UserDetails autenticar( Usuario usuario ){
        UserDetails user = loadUserByUsername(usuario.getLogin());
        boolean senhasBatem = encoder.matches( usuario.getSenha(), user.getPassword() );

        if(senhasBatem){
            return user;
        }

        throw new SenhaInvalidaException();
    }

    @Transactional
    public UsuarioRetornoDTO salvarUsuario(Usuario usuario) {

        Usuario usuarioCriado = usuarioRepository.save(usuario);
        return new UsuarioRetornoDTO(usuario.getId(), usuarioCriado.getLogin());
    
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario buscaUsuario = usuarioRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com este login"));

        String[] roles = buscaUsuario.isAdmin() ? new String[] { "ADMIN", "USER" } : new String[] { "USER" };

        return User
                .builder()
                .username(buscaUsuario.getLogin())
                .password(buscaUsuario.getSenha())
                .roles(roles)
                .build();
    }

}
