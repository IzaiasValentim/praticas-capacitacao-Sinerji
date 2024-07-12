module.exports = app => {
    /**
     * Rotas de login e cadastro do usuário
     *  - /signup -> Acessa a função save que realiza o cadastro no banco de dados.
     *  - /signin -> Acessa a função signin que realiza a autenticação do usuário com as credênciais fornecidas.
     */
    app.post('/signup', app.api.user.save)
    app.post('/signin', app.api.auth.signin)

    /**
     * Rotas de acesso ao recurso tasks:
     *  - (GET) /tasks             -> Retorna a lista de todas as tasks de um usuário.
     *  - (POST) /tasks            -> Salva uma task de um usuário.
     *  - (DELETE) /tasl/:id       -> Deleta uma task do id informado na requisição.
     *  - (PUT) /tasks/:id/toggle  -> Muda a propriedade de realização da terefa.
     */
    app.route('/tasks')
        .all(app.config.passport.authenticate())
        .get(app.api.task.getTasks)
        .post(app.api.task.save)

    app.route('/tasks/:id')
        .all(app.config.passport.authenticate())
        .delete(app.api.task.remove)

    app.route('/tasks/:id/toggle')
        .all(app.config.passport.authenticate())
        .put(app.api.task.toggleTask)
}