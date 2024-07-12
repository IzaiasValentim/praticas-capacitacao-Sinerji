// Importa o framework Express.
const express = require('express');
// Cria uma instância do Express.
const app = express();

// Importa a configuração do banco de dados.
const db = require('./config/db');

// Importa o módulo Consign.
const consign = require('consign');

// Configura o Consign para autoload de scripts.
consign()
    // Carrega a configuração de autenticação   .
    .then('./config/passport.js')
    // Carrega os middlewares.
    .then('./config/middlewares.js')
    // Carrega os arquivos da API.
    .then('./api')
    // Carrega as rotas da aplicação.
    .then('./config/routes.js')
    // Injeta tudo na instância do app.
    .into(app);

// Define a conexão com o banco de dados no app.
app.db = db;

// Define uma rota GET de teste para a raiz do servidor.
app.get('/', (req, res) => {
    // Responde com status 200 e uma mensagem.
    res.status(200).send('Meu backend!');
});

// Inicia o servidor na porta 3000
app.listen(3000, () => {
    // Loga no console que o servidor está rodando.
    console.log('Backend executando...');
});