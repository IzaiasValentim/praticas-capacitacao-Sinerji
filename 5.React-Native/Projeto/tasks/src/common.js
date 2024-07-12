import { Alert, Platform } from 'react-native'

// Define a url do server de acordo com a plataforma(Ios ou Android).
const server = Platform.OS === 'ios'
    ? 'http://localhost:3000' : 'http://10.0.2.2:3000'

// Retorna uma mensagem de erro casa haja algum erro relacionado à operação com o servidor.
function showError(err) {
    if(err.response && err.response.data) {
        Alert.alert('Ops! Ocorreu um Problema!', `Mensagem: ${err.response.data}`)
    } else {
        Alert.alert('Ops! Ocorreu um Problema!', `Mensagem: ${err}`)
    }
}

// Sucesso na operação com o servidor.
function showSuccess(msg) {
    Alert.alert('Sucesso!', msg)
}

export { server, showError, showSuccess }