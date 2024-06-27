package com.izaiasvalentim.projeto_security_jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.izaiasvalentim.projeto_security_jwt.service.JwtService;
import com.izaiasvalentim.projeto_security_jwt.service.UsuarioServiceImpl;

public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioServiceImpl usuarioServiceImpl;

    // Injeção das dependências utilizadas.
    public JwtAuthFilter(JwtService jwtService, UsuarioServiceImpl usuarioServiceImpl) {
        this.jwtService = jwtService;
        this.usuarioServiceImpl = usuarioServiceImpl;
    }

    /*
     * Este método é onde a lógica de filtragem é implementada.
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // Obtendo o header de autorização.
        String authorization = request.getHeader("Authorization");

        // Verifica se o cabeçalho não é nulo e se há o inidicativo do token "Bearer".
        if (authorization != null && authorization.startsWith("Bearer")) {

            // Extração do token
            String token = authorization.split(" ")[1];

            // Validação do token anterior.
            boolean isValid = jwtService.tokenValido(token);

            // Se o token for válido obtem as informações do usuário e o insere no contexto
            // de segurança do Spring (SecurityContextHolder).
            if (isValid) {

                String loginUsuario = jwtService.obterLoginUsuario(token);
                UserDetails usuario = usuarioServiceImpl.loadUserByUsername(loginUsuario);
                UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(usuario, null,
                        usuario.getAuthorities());
                user.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(user);
            }
        }
        // Continua a cadeia de filtros.
        filterChain.doFilter(request, response);
    }

}
