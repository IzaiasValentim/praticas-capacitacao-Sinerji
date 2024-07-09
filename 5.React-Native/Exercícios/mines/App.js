import React, { Component } from 'react';
import { StyleSheet, Text, View, Alert } from 'react-native';
import params from './src/params'
import MineField from './src/components/MineField'
import Header from './src/components/Header'
import LevelSelection from './src/screens/LevelSelection'
import {
  createMinedBoard,
  cloneBoard,
  openField,
  hadExplosion,
  wonGame,
  showMines,
  invertFlag,
  flagsUsed
} from './src/functions'

// Classe principal do aplicativo.
export default class App extends Component {

  // Construtor da classe.
  constructor(props) {
    super(props)

    // Inicializa o estado do componente
    this.state = this.createState()
  }

  // Função para calcular a quantidade de minas no tabuleiro com base na dificuldade.
  minesAmount = () => {
    const cols = params.getColumnsAmount()
    const rows = params.getRowsAmount()
    return Math.ceil(cols * rows * params.difficultLevel)
  }

  // Função para criar o estado inicial do tabuleiro
  createState = () => {
    const cols = params.getColumnsAmount()
    const rows = params.getRowsAmount()
    return {
      // Cria o tabuleiro.
      board: createMinedBoard(rows, cols, this.minesAmount()),
      // Define que o jogo não foi vencido
      won: false,
      // Define que o jogo não foi perdido
      lost: false,
      // Define que a seleção de nível não está visível.
      showLevelSelection: false,
    }
  }

  // Função chamada ao abrir um campo.
  onOpenField = (row, column) => {
    // Clona o tabuleiro atual.
    const board = cloneBoard(this.state.board)
    // Abre o campo selecionado.
    openField(board, row, column)
    // Verifica se houve explosão.
    const lost = hadExplosion(board)
    // Verifica se o jogo foi vencido.
    const won = wonGame(board)

    if (lost) {
      // Mostra todas as minas no tabuleiro
      showMines(board)
      // Mostra mensagem de derrota
      Alert.alert('Bummm, Derrotaa!', 'Você perdeu!')
    }

    if (won) {
      // Mostra mensagem de vitória
      Alert.alert('Parabénss!', 'Você Venceu!')
    }
    // Atualiza o estado do componente
    this.setState({ board, lost, won })
  }

  // Função chamada ao selecionar um campo para colocar bandeira.
  onSelectField = (row, column) => {
    const board = cloneBoard(this.state.board)
    // Inverte a bandeira no campo selecionado.
    invertFlag(board, row, column)
    const won = wonGame(board)

    if (won) {
      // Mostra mensagem de vitória.
      Alert.alert('Parabéns', 'Você Venceu!')
    }
    // Atualiza o estado do componente.
    this.setState({ board, won })
  }

  // Função chamada ao selecionar o nível do jogo.
  onLevelSelected = level => {
    // Define o nível de dificuldade.
    params.difficultLevel = level
    // Reinicia o estado do componente.
    this.setState(this.createState())
  }

  // Renderização dos componentes:
  render() {
    return (
      <View style={styles.container}>
        {/* Componente da seleção de nível */}
        <LevelSelection isVisible={this.state.showLevelSelection}
          onLevelSelected={this.onLevelSelected}
          onCancel={() => this.setState({ showLevelSelection: false })} />

        {/* Cabeçalho com informações do jogo */}
        <Header flagsLeft={this.minesAmount() - flagsUsed(this.state.board)}
          onNewGame={() => this.setState(this.createState())}
          onFlagPress={() => this.setState({ showLevelSelection: true })} />

        {/* Tabuleiro do campo minado */}
        <View style={styles.board}>
          <MineField board={this.state.board}
            onOpenField={this.onOpenField}
            onSelectField={this.onSelectField} />
        </View>
      </View>
    );
  }
}

// Estilos deste componente.
const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'flex-end'
  },
  board: {
    alignItems: 'center',
    backgroundColor: '#AAA'
  }
});