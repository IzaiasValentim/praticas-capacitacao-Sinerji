/*
    Sobre functions.js

    Este arquivo complementar reune algumas funções que 
    possibilitam a execução da aplicação.
*/

/*
    createBoard:
        Recebe as dimensões do tabuleiro(linha, coluna).
        Cria e Retorna uma matriz onde cada campo possui os 
        atributos de interesse para controle do jogo.
*/
const createBoard = (rows, columns) => {
    return Array(rows).fill(0).map((_, row) => {
        return Array(columns).fill(0).map((_, column) => {
            return {
                row,
                column,
                opened: false,
                flagged: false,
                mined: false,
                exploded: false,
                nearMines: 0
            }
        })
    })
}

/*
    spreadMines:

        Recebe um tabuleiro e quantidade de minas a serem inseridas aleatóriamente.
        Processa e Retorna um tabuleiro onde a quantidade de minas informadas serão
        distribuídas nos campos como 'mined'.   
 */
const spreadMines = (board, minesAmount) => {
    const rows = board.length
    const columns = board[0].length
    let minesPlanted = 0

    while (minesPlanted < minesAmount) {
        const rowSel = parseInt(Math.random() * rows, 10)
        const columnSel = parseInt(Math.random() * columns, 10)

        if (!board[rowSel][columnSel].mined) {
            board[rowSel][columnSel].mined = true
            minesPlanted++
        }
    }
}

/*
  createMinedBoard:
    Recebe a quantidade de linhas, colunas e minas presentes no tabuleiro.
    Processa com a ajuda de outras funções e retorna o tabuleiro do jogo pronto.
 */
const createMinedBoard = (rows, columns, minesAmount) => {
    const board = createBoard(rows, columns)
    spreadMines(board, minesAmount)
    return board
}

// cloneBoard: Cria e retorna uma cópia lógica do tabuleiro. 
const cloneBoard = board => {
    return board.map(rows => {
        return rows.map(field => {
            return { ...field }
        })
    })
}

/*
    getNeighbors:
        Recebe um tabuleiro,linha e uma coluna.
        Processa e Retorna os campos vizinhos à linha e coluna informada.
*/
const getNeighbors = (board, row, column) => {
    const neighbors = []
    const rows = [row - 1, row, row + 1]
    const columns = [column - 1, column, column + 1]
    rows.forEach(r => {
        columns.forEach(c => {
            const diferent = r !== row || c !== column
            const validRow = r >= 0 && r < board.length
            const validColumn = c >= 0 && c < board[0].length
            if (diferent && validRow && validColumn) {
                neighbors.push(board[r][c])
            }
        })
    })
    return neighbors
}

/*
    safeNeighborhood:
        Recebe um tabuleiro,linha e uma coluna.
        Processa e Retorna os campos vizinhos seguros(Não minados).
*/
const safeNeighborhood = (board, row, column) => {
    const safes = (result, neighbor) => result && !neighbor.mined
    return getNeighbors(board, row, column).reduce(safes, true)
}

/*
    openField:
        Recebe um tabuleiro,linha e uma coluna.
        Processa a ação de abrir um campo:
         - Se o campo for minado:  O jogo irá encerrar.
            
         - Se o campo não tiver mina e tiver vizinhos seguros: Serão revelados 
            os campos seguros ao redor.
        
         - Se o campo não tiver mina e não tiver vizinhos seguros: As minas próximas
            serão reveladas.  
*/
const openField = (board, row, column) => {
    const field = board[row][column]
    if (!field.opened) {
        field.opened = true
        if (field.mined) {
            field.exploded = true
        } else if (safeNeighborhood(board, row, column)) {
            getNeighbors(board, row, column)
                .forEach(n => openField(board, n.row, n.column))
        } else {
            const neighbors = getNeighbors(board, row, column)
            field.nearMines = neighbors.filter(n => n.mined).length
        }
    }
}

// Representa todos os campos do tabuleiro.
const fields = board => [].concat(...board)

/* 
    Armazena o valor lógico da verificação da ocorrência de explosão de alguma 
    mina no tabuleiro.
*/
const hadExplosion = board => fields(board)
    .filter(field => field.exploded).length > 0

// Valida se alguma ação foi realizada no campo.
const pendding = field => (field.mined && !field.flagged)
    || (!field.mined && !field.opened)

const wonGame = board => fields(board).filter(pendding).length === 0

// Mostra todas as minas.
const showMines = board => fields(board).filter(field => field.mined)
    .forEach(field => field.opened = true)

// Inverte a ocorrência da marcação da  mina.
const invertFlag = (board, row, column) => {
    const field = board[row][column]
    field.flagged = !field.flagged
}

// Contabilização de todas as bandeiras usadas.
const flagsUsed = board => fields(board)
    .filter(field => field.flagged).length

// Exporta os recursos necessários.
export {
    createMinedBoard,
    cloneBoard,
    openField,
    hadExplosion,
    wonGame,
    showMines,
    invertFlag,
    flagsUsed
}