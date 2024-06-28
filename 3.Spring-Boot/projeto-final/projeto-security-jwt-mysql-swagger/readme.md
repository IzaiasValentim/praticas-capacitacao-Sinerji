Rota de acesso Swagger-ui:
    - http://localhost:8081/swagger-ui.html

Usuários cadastrado para teste:

    Acesso comum: 
        Login: testeSinerji
        Senha: teste

    Acesso Admin: 
        Login: testeAdmin
        Senha: testeadmin

-> No arquivo projeto-security-jwt.postman_collection.json tem a coleção com as requisições feitas pelo postman.

-> Após obter o token é possível inseri-lo em Headers->Authorization com o valor Bearer<espaço>token na pasta
de Rotas de testes de acesso.    

-> No Swagger é possível adicionar o token em Authorize, como Beaeker <espaço> token.

-> Em script-banco-aplicacao.sql tem os comandos de criação do banco e tabela de usuários.