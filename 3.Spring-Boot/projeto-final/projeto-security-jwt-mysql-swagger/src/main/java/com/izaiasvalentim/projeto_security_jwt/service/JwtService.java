package com.izaiasvalentim.projeto_security_jwt.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.izaiasvalentim.projeto_security_jwt.domain.entity.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
// Classe responsável por gerar e validar os tokens JWT.
public class JwtService {
    @Value("${security.jwt.expiracao}")
    // Tempo de expiração do token.
    private String expiracao;

    @Value("${security.jwt.chave-assinatura}")
    // Chave utilizada para assinar o token.
    private String chaveAssinatura;

    // Gera um token JWT para um usuário específico.
    public String gerarToken(Usuario usuario) {
        long minutosDeValidade = Long.valueOf(expiracao);
        LocalDateTime dataHoraExpiracao = LocalDateTime.now().plusMinutes(minutosDeValidade);
        Instant instant = dataHoraExpiracao.atZone(ZoneId.systemDefault()).toInstant();
        Date data = Date.from(instant);

        return Jwts
                .builder()
                .setSubject(usuario.getLogin())
                .setExpiration(data)
                .signWith(SignatureAlgorithm.HS512, chaveAssinatura)
                .compact();
    }

    // Extrai e retorna as claims (informações contidas no token) a partir do token recebido.
    private Claims obterClaims(String token) throws ExpiredJwtException {
        return Jwts
                .parser()
                .setSigningKey(chaveAssinatura)
                .parseClaimsJws(token)
                .getBody();
    }

    // Verifica se o token é válido.
    public boolean tokenValido(String token) {
        try {
            Claims claims = obterClaims(token);
            Date dataExpiracao = claims.getExpiration();
            LocalDateTime data = dataExpiracao.toInstant()
                    .atZone(ZoneId.systemDefault()).toLocalDateTime();
            return !LocalDateTime.now().isAfter(data);
        } catch (Exception e) {
            return false;
        }
    }

    // Extrai e retorna o login do usuário a partir de um token JWT
    public String obterLoginUsuario(String token) throws ExpiredJwtException {
        return (String) obterClaims(token).getSubject();
    }

}
