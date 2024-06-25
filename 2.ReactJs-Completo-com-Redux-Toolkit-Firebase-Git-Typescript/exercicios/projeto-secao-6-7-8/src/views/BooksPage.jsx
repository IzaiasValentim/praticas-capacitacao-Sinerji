import Book from '../components/Book.jsx';
import Header from '../components/Header.jsx';
import { useSelector, useDispatch } from 'react-redux';
import { selectBooks, fetchBooks } from '../store/booksSlice.js';
import { useEffect } from 'react';
import { Link } from 'react-router-dom';

// Componente para exibir a lista de livros.
function BooksPage() {
  const dispatch = useDispatch();
  const books = useSelector(selectBooks).books;
  const pageTitle = "📖 📖 Minha lista de livros agora no Firebase!";

  const bookStatus = useSelector(selectBooks).status;

  // Usa useEffect para buscar livros quando o status é 'idle'.
  useEffect(() => {
    if (bookStatus == 'idle') {
      dispatch(fetchBooks());
    }

  }, []);



  return (
    <>
      <div className="container">
        <Header pageTitle={pageTitle} />
        <div className="books-container">

          {books.length ?
            <div className="books-list">

              {books.map(book =>

                <Book key={book.id} book={book} />

              )}

            </div> : bookStatus == 'loading' ?
              <div>Carregando...</div> :
              <div>Sua lista de livros está vazia.. <Link to="/add-book">Clique aqui!</Link> Para adicionar um livro</div>
          }

        </div>
      </div>
    </>
  )
}

export default BooksPage
