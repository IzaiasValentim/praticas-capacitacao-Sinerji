package com.izaiasvalentim.projeto_security_jwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetoSecurityJwtApplication {
	/* Os comando abaixo são para o cadastro de dois usuários iniciais para testes utilizados quando o
	   o banco for o H2*/

//	@Bean
//	public CommandLineRunner init(@Autowired UsuarioRepository usuarioRepository) {
//		return args -> {
//
//			 Usuario usuarioBase = new Usuario("testeSinerji",
//			 		"$2a$10$q8G.P5PB0y4HrZSt4pfbueau/VU/.3jcHUoTRHiAFhOQi/zRRy0I2",
//			 		false);
//
//			 Usuario usuarioAdmin = new Usuario("testeAdmin",
//			 		"$2a$10$5kHXR6sK5w8G65u3CcBqwOvIWykigRZMmF7q2HjrVY/tNAe4uBRoy",
//			 		true);
//			 //usuarioRepository.save(usuarioBase);
//			 usuarioRepository.save(usuarioAdmin);
//		};
//	}

    public static void main(String[] args) {
        SpringApplication.run(ProjetoSecurityJwtApplication.class, args);
    }

}
