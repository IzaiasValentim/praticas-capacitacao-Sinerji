import React from 'react'
import { View, StyleSheet } from 'react-native'
import Field from './Field'

// Componente funcional para renderizar o campo minado.
export default props => {
    // Mapeia cada linha do tabuleiro.
    const rows = props.board.map((row, r) => {
        // Mapeia cada campo da linha.
        const columns = row.map((field, c) => {
            return (
                // Renderiza o componente Field para cada campo.
                <Field {...field} key={c}
                    onOpen={() => props.onOpenField(r, c)}
                    onSelect={e => props.onSelectField(r, c)} />
            )
        })
        // Retorna uma View para cada linha contendo suas colunas.
        return (
            <View key={r} style={{ flexDirection: 'row' }}>
                {columns}
            </View>
        )
    })
    // Retorna uma View contendo todas as linhas do tabuleiro.
    return <View style={styles.container}>{rows}</View>
}

// Estilos deste componente.
const styles = StyleSheet.create({
    container: {
        backgroundColor: '#EEE', // Define a cor de fundo do container
    }
})