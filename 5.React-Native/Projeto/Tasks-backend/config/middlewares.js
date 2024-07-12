// Intercepta e traduz o body das requisições.
const bodyParser = require('body-parser')

// Lida com as urls das requisições.
const cors = require('cors')

module.exports = app => {
    app.use(bodyParser.json())
    app.use(cors({
        origin: '*'
    }))
}