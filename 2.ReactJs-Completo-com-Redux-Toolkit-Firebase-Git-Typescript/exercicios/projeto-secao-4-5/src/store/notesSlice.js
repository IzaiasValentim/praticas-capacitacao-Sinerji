import { createSlice } from '@reduxjs/toolkit';

export const notesSlice = createSlice({
  name: 'notes',
  initialState: [
    // Lista inicial de anotações. 
    {
      id: 1,
      book_id: 1,
      title: "Nota base para o livro de id = 1",
      text: "Apenas para visualização da aplicação."
    },
  ],
  reducers: {
    addNote: (notes, action) => {
      // Adiciona uma anotação de um livro. 
      let newNote = action.payload;
      newNote.id = notes.length ? Math.max(...notes.map(note => note.id)) + 1 : 1;
      notes.push(newNote);
    },
    eraseNote: (notes, action) => {
      // Exclusãao, refaz a lista de anotações sem a nota informada..
      return notes.filter(note => note.id != action.payload);
    },
    eraseBookNotes: (notes, action) => {
      // Exclusão de todas as anotações ligadas a um livro.
      return notes.filter(note => note.book_id != action.payload);
    }
  }
})

export const { addNote, eraseNote, eraseBookNotes } = notesSlice.actions;

export const selectNotes = state => state.notes;

export default notesSlice.reducer;