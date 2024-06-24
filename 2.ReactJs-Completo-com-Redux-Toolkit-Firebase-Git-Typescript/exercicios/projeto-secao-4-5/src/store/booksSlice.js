import { createSlice } from '@reduxjs/toolkit';

export const booksSlice = createSlice({
  name: 'books',
  initialState: [
    // Lista inicial de livros.
    {
      id: 1,
      title: "Em algum lugar nas estrelas",
      cover:
        "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEgbRnM1BmcOP0RDhn3wB3etomjANmKcB46REixmrZMiDv2nJpwA2L3O0BUFBpWTxP8yUynFvgW819nlRum0errY8xkZ4rYdIVLCeEd18IlXVb8X_c9ldlYDtx4FwjzsVFXBOwRLhBEBOoTV/s320/capa+em+algum+lugar+nas+estrelas.png",
      isRead: true,
      author: "Clare Vanderpool",
      synopsis: "Em algum lugar nas estrelas é um livro sobre dois jovens que precisam lidar com perdas, dor e solidão desde cedo. É um livro maravilhoso para se ler debaixo das cobertas com uma xícara de bebida quentinha nas mãos. É uma história que te tira do seu mundo por alguns instantes e te apresenta uma realidade inocente e doce."
    },
  ],
  reducers: {
    addBook: (books, action) => {
      // Adiciona um novo livro a lista  de livros.
      let newBook = action.payload;
      newBook.id = books.length ? Math.max(...books.map(book => book.id)) + 1 : 1;
      books.push(newBook);
    },
    eraseBook: (books, action) => {
      // Exclusãao, refaz a lista de livros sem o livro informado.
      return books.filter(book => book.id != action.payload);
    },
    toggleRead: (books, action) => {
      // Modifica o valor isRead de uma ocorrência de livro.
      books.map(book => {
        if (book.id == action.payload) {
          book.isRead = !book.isRead;
        }
      });
    }
  }
})

export const { addBook, eraseBook, toggleRead } = booksSlice.actions;

export const selectBooks = state => state.books;

export default booksSlice.reducer;