import { configureStore } from '@reduxjs/toolkit';
import booksReducer from './booksSlice.js';
import usersReducer from './usersSlice.js';

/*
  - Configuração da store Redux para a aplicação.
    - Utiliza configureStore do Redux Toolkit para configurar a store com os reducers necessários.
  
  - Importa os reducers dos slices:
    - booksReducer: Gerencia o estado da coleção de livros.
    - usersReducer: Gerencia o estado relacionado aos usuários.
  
  - A store configurada combina os reducers e disponibiliza os estados 'books' e 'users' na aplicação.
  - Exporta a store configurada para uso na aplicação.
 */
export default configureStore({
  reducer: {
    books: booksReducer,
    users: usersReducer
  }
})