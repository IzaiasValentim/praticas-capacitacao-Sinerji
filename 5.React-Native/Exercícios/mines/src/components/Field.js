import React from 'react'
import { View, StyleSheet, Text, TouchableWithoutFeedback } from 'react-native'
import params from '../params'
import Mine from './Mine'
import Flag from './Flag'

// Componente funcional para renderizar um campo individual no tabuleiro.
export default props => {

    // Desestruturação das propriedades recebidas por props.
    const { mined, opened, nearMines, exploded, flagged } = props

    // Estilos do campo baseado em seu estado.
    const styleField = [styles.field]
        // Campo aberto.
        if (opened) styleField.push(styles.opened)
        // Campo com explosão.
        if (exploded) styleField.push(styles.exploded)
        // Campo com bandeira.
        if (flagged) styleField.push(styles.flagged)
        // Campo regular.
        if (!opened && !exploded) styleField.push(styles.regular)

    // Definindo a cor do texto baseado no número de minas próximas.
    let color = null
    if (nearMines > 0) {
        if (nearMines == 1) color = '#2A28D7'
        if (nearMines == 2) color = '#2B520F'
        if (nearMines > 2 && nearMines < 6) color = '#F9060A'
        if (nearMines >= 6) color = '#F221A9'
    }

    return (
        // Componente que detecta toques sem feedback.
        <TouchableWithoutFeedback onPress={props.onOpen}
            onLongPress={props.onSelect}>
            <View style={styleField}>
                {/* Exibe o número de minas próximas se o campo estiver aberto e não for uma mina. */}
                {!mined && opened && nearMines > 0 ?
                    <Text style={[styles.label, { color: color }]}>
                        {nearMines}</Text> : false}
                {/* Exibe o componente Mine se o campo for uma mina e estiver aberto. */}
                {mined && opened ? <Mine /> : false}
                {/* Exibe o componente Flag se o campo estiver marcado com uma bandeira e não estiver aberto. */}
                {flagged && !opened ? <Flag /> : false}
            </View>
        </TouchableWithoutFeedback>
    )
}

// Estilos do componente
const styles = StyleSheet.create({
    field: {
        height: params.blockSize,
        width: params.blockSize,
        borderWidth: params.borderSize,
    },
    regular: {
        backgroundColor: '#999',
        borderLeftColor: '#CCC',
        borderTopColor: '#CCC',
        borderRightColor: '#333',
        borderBottomColor: '#333',
    },
    opened: {
        backgroundColor: '#999',
        borderColor: '#777',
        alignItems: 'center',
        justifyContent: 'center',
    },
    label: {
        fontWeight: 'bold',
        fontSize: params.fontSize,
    },
    exploded: {
        backgroundColor: 'red',
        borderColor: 'red',
    }
})