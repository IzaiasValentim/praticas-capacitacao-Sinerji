import React, { Component } from 'react'
import {
    View,
    ActivityIndicator,
    StyleSheet
} from 'react-native'
import { CommonActions } from '@react-navigation/native';

import axios from 'axios'
import AsyncStorage from '@react-native-async-storage/async-storage'

// Este componente verifica se o usuário está autenticado.
export default class AuthOrApp extends Component {

    // Função que é executada diretamente no componente.
    componentDidMount = async () => {

        // Obtém os dados do usuário armazenados localmente.
        const userDataJson = await AsyncStorage.getItem('userData')
        let userData = null

        // Tenta fazer o parser dos dados do usuário de JSON para objeto.
        try {
            userData = JSON.parse(userDataJson)
        } catch (e) {
        }

        // Se os dados do usuário e o token estiverem presentes.
        if (userData && userData.token) {
            // Configura o token de autorização para todas as requisições axios e redireciona para 'Home'.
            axios.defaults.headers.common['Authorization'] = `bearer ${userData.token}`
            this.props.navigation.dispatch(
                CommonActions.reset({
                    index: 0,
                    routes: [
                        {
                            name: 'Home',
                            params: userData,
                        },
                    ],
                })
            );
        } else {
            // Redireciona para a tela de autenticação/cadastro.
            this.props.navigation.dispatch(
                CommonActions.reset({
                    index: 0,
                    routes: [
                        {
                            name: 'Auth',
                        },
                    ],
                })
            )
        }
    }

    render() {
        return (
            <View style={styles.container}>
                <ActivityIndicator size='large' />
            </View>
        )
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#000'
    }
})