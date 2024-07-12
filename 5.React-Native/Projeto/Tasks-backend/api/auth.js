const { authSecret } = require('../.env')
const jwt = require('jwt-simple')
const bcrypt = require('bcrypt-nodejs')

module.exports = app => {

    // Função assíncrona que tenta realizar o login do usuário.
    const signin = async (req, res) => {

        // Valida a presença das credênciais de login.
        if (!req.body.email || !req.body.password) {
            return res.status(400).send('Dados incompletos')
        }

        // Consulta o usuário pelo email, no banco.
        const user = await app.db('users')
            .whereRaw("LOWER(email) = LOWER(?)", req.body.email)
            .first()

        // Se houver usuário ele será authenticado pela senha.
        if (user) {
            bcrypt.compare(req.body.password, user.password, (err, isMatch) => {
                if (err || !isMatch) {
                    return res.status(401).send('A senha informada é inválida!')
                }

                const payload = {
                    id: user.id,
                    name: user.name,
                    email: user.email
                }

                res.json({
                    // Retorno positivo, o token será retornado.
                    name: user.name,
                    email: user.email,
                    token: jwt.encode(payload, authSecret),
                })
            })
        } else {
            res.status(400).send('Usuário não cadastrado!')
        }
    }

    return { signin }
}