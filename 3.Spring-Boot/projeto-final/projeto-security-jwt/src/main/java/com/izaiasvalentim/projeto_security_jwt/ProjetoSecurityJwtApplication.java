package com.izaiasvalentim.projeto_security_jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.izaiasvalentim.projeto_security_jwt.domain.entity.Usuario;
import com.izaiasvalentim.projeto_security_jwt.domain.repositories.UsuarioRepository;

@SpringBootApplication
public class ProjetoSecurityJwtApplication {
	// O cadastro dos usuários base para teste são realizados no CommandLineRunner.
	@Bean
	public CommandLineRunner init(@Autowired UsuarioRepository usuarioRepository) {
		return args -> {

			Usuario usuarioBase = new Usuario("testeSinerji",
					"$2a$10$q8G.P5PB0y4HrZSt4pfbueau/VU/.3jcHUoTRHiAFhOQi/zRRy0I2",
					false);

			Usuario usuarioAdmin = new Usuario("testeAdmin",
					"$2a$10$5kHXR6sK5w8G65u3CcBqwOvIWykigRZMmF7q2HjrVY/tNAe4uBRoy",
					true);
			usuarioRepository.save(usuarioBase);
			usuarioRepository.save(usuarioAdmin);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSecurityJwtApplication.class, args);
	}

}
