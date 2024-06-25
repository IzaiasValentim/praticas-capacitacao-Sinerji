import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import {
  collection,
  query,
  where,
  getDocs,
  doc,
  updateDoc,
  deleteDoc,
  addDoc
}
  from "firebase/firestore";
import { db, auth } from '../firebase/config.js';

/*
  booksSlice gerencia o estado da coleção de livros na aplicação usando createSlice do Redux Toolkit.
 
  Estrutura inicial:
  - books: Array vazio para armazenar a coleção de livros.
  - status: String que indica o status da operação ('idle', 'loading', 'succeeded', 'failed').

  -ExtraReducers:
    - Utiliza extraReducers para lidar com ações assíncronas criadas por createAsyncThunk.
  
  * Casos Tratados:
      1. fetchBooks:
        - pending: Atualiza o status para 'loading' enquanto os dados são buscados.
        - fulfilled: Atualiza o status para 'succeeded' e armazena a lista de livros obtida.
        - rejected: Atualiza o status para 'failed' e registra o erro no console.
  
      2. toggleRead:
        - fulfilled: Alterna o estado de leitura (isRead) do livro especificado.
        - rejected: Atualiza o status para 'failed' e registra o erro no console.
      
      3. eraseBook:
        - pending: Atualiza o status para 'loading' enquanto o livro está sendo deletado.
        - fulfilled: Remove o livro da lista e atualiza o status para 'succeeded'.
        - rejected: Atualiza o status para 'failed' e registra o erro no console.
  
      4. addBook:
        - pending: Atualiza o status para 'loading' enquanto o novo livro está sendo adicionado.
        - fulfilled: Adiciona o novo livro à lista e atualiza o status para 'succeeded'.
        - rejected: Atualiza o status para 'failed' e registra o erro no console.
 */
export const booksSlice = createSlice({
  name: 'books',
  initialState: {
    books: [],
    status: 'idle'
  },
  reducers: {
    // addBook: (books, action) => {
    //   let newBook = action.payload;
    //   newBook.id = books.length ? Math.max(...books.map(book => book.id)) + 1 : 1;
    //   books.push(newBook);
    // },

  },
  extraReducers(builder) {
    builder
      .addCase(fetchBooks.pending, (state, action) => {
        state.status = 'loading';
      })
      .addCase(fetchBooks.fulfilled, (state, action) => {
        state.status = 'succeeded';
        state.books = action.payload;
      })
      .addCase(fetchBooks.rejected, (state, action) => {
        state.status = 'failed';
        console.log(action.error.message);
      })
      .addCase(toggleRead.fulfilled, (state, action) => {
        state.books.map(book => {
          if (book.id == action.payload) {
            book.isRead = !book.isRead;
          }
        });
      })
      .addCase(toggleRead.rejected, (state, action) => {
        state.status = 'failed';
        console.log(action.error.message);
      })
      .addCase(eraseBook.pending, (state, action) => {
        state.status = 'loading';
      })
      .addCase(eraseBook.fulfilled, (state, action) => {
        state.books = state.books.filter(book => book.id != action.payload);
        state.status = 'succeeded';
      })
      .addCase(eraseBook.rejected, (state, action) => {
        state.status = 'failed';
        console.log(action.error.message);
      })
      .addCase(addBook.pending, (state, action) => {
        state.status = 'loading';
      })
      .addCase(addBook.fulfilled, (state, action) => {
        state.books.push(action.payload);
        state.status = 'succeeded';
      })
      .addCase(addBook.rejected, (state, action) => {
        state.status = 'failed';
        console.log(action.error.message);
      })
  }

})

export const selectBooks = state => state.books;

export default booksSlice.reducer;


/*
  - Função assíncrona fetchBooks para buscar livros do Firebase.
  
  * Passos:
     - Cria uma consulta (query) na coleção "books" no Firestore, filtrando livros do usuário atual.
     - Executa a consulta e obtém um snapshot dos documentos correspondentes.
     - Itera pelos documentos retornados, construindo uma lista de objetos de livros com seus IDs e dados.
     - Retorna a lista de livros.
 */
export const fetchBooks = createAsyncThunk('books/fetchBooks', async () => {
  const q = query(collection(db, "books"), where("user_id", "==", auth.currentUser.uid));
  const querySnapshot = await getDocs(q);
  console.log(q);
  let bookList = [];
  querySnapshot.forEach((doc) => {
    bookList.push({ id: doc.id, ...doc.data() })
  });
  return bookList
});

/*
  - Função assíncrona toggleRead para alternar o estado de leitura de um livro no Firebase.
  
  - Parâmetros:
     {Object} payload - Contém o ID do livro e o estado atual de leitura (isRead).
  
  * Passos:
      - Obtém uma referência ao documento do livro no Firestore usando o ID fornecido.
      - Atualiza o campo isRead do documento para o valor oposto do estado atual de leitura.
      - Retorna o ID do livro atualizado.
 */
export const toggleRead = createAsyncThunk('books/toggleRead', async (payload) => {
  const bookRef = doc(db, "books", payload.id);
  await updateDoc(bookRef, {
    isRead: !payload.isRead
  });
  return payload.id;
});

/**
  - Função assíncrona eraseBook para deletar um livro no Firebase.
  
 - Parâmetros:
     {string} payload - ID do livro a ser deletado.

  Passos:
    - Obtém uma referência ao documento do livro no Firestore usando o ID fornecido.
    - Deleta o documento correspondente no Firestore.
    - Retorna o ID do livro deletado.
 */
export const eraseBook = createAsyncThunk('books/eraseBook', async (payload) => {
  await deleteDoc(doc(db, "books", payload));
  return payload;
});

/*
  - Função assíncrona addBook para adicionar um novo livro no Firebase.

  - Parâmetros:
    {Object} payload - Objeto contendo os dados do novo livro.
 
  * Passos:
    - Cria uma cópia do payload e adiciona o ID do usuário atual.
    - Adiciona o novo livro à coleção "books" no Firestore.
    - Obtém a referência do documento criado e adiciona o ID do documento ao novo livro.
    - Retorna o objeto do novo livro com o ID atribuído.
 */
export const addBook = createAsyncThunk('books/addBook', async (payload) => {
  let newBook = payload;
  newBook.user_id = auth.currentUser.uid;
  const docRef = await addDoc(collection(db, "books"), newBook);
  newBook.id = docRef.id;
  return newBook;
});

