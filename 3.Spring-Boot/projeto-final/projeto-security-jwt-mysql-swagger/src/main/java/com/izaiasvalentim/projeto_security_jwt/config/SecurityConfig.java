package com.izaiasvalentim.projeto_security_jwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.izaiasvalentim.projeto_security_jwt.service.JwtService;
import com.izaiasvalentim.projeto_security_jwt.service.UsuarioServiceImpl;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;
    @Autowired
    private JwtService jwtService;

    // Define um bean para o BCryptPasswordEncoder, que será usado para criptografar as senhas dos usuários.
    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    /* Define um bean para um filtro customizado (JwtAuthFilter) que processa o
       token JWT em cada requisição.
     */
    @Bean
    public OncePerRequestFilter jwtFilter() {
        return new JwtAuthFilter(jwtService, usuarioServiceImpl);
    }

    /*
     * - Este configure é responsável pela autenticação do usuário.
     * - Configura a autenticação para usar o serviço de usuários
     * (usuarioServiceImpl) e o codificador de senhas definido anteriormente.
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(usuarioServiceImpl)
                .passwordEncoder(passwordEncoder());
    }

    // Este configure é responsável pela autorização de um usuário já authenticado.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
                // Permite o acesso livre para o usuário se cadastrar.
                .antMatchers(HttpMethod.POST, "/home/usuarios/")
                .permitAll()
                // Permite o acesso livre à rota say-hello-free.
                .antMatchers("/home/say-hello-free")
                .hasAnyRole("ADMIN", "USER")
                // Só libera o acesso para este patch caso o usuario esteja autenticado e tenha
                // Alguma das roles informadas.
                .antMatchers("/home/say-hello-secured/**")
                .hasRole("ADMIN")
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    // Retira o swagger-ui dos filtros iniciais do spring security.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(
                "/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }
}
