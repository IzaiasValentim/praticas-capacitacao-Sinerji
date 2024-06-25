import { useParams, Link, useNavigate } from 'react-router-dom';
import Notes from '../components/Notes.jsx';
import { useState, useEffect } from 'react';
import { useDispatch } from 'react-redux';
import { eraseBook, toggleRead } from '../store/booksSlice.js';
import { doc, getDoc } from "firebase/firestore";
import { db } from '../firebase/config.js';

// Componente para a página do livro individual.
function SingleBookPage() {

  const dispatch = useDispatch();
  const navigate = useNavigate();
  const { id } = useParams();
  const [book, setBook] = useState("");
  const [fetchStatus, setFetchStatus] = useState("idle");

  // Função que cuida da exclusão do livro.
  function handleEraseBook(id) {
    if (confirm('Você deseja excluir este livro juntamente à suas anotações?')) {
      dispatch(eraseBook(id));
      navigate("/");
    }
  }

  // Função que lida com a marcação do livro já estar lido ou não.
  function handleToggleRead(info) {
    dispatch(toggleRead({ id: info.id, isRead: info.isRead }));
    setBook({ ...book, isRead: !info.isRead });
  }

  // Função que busca um livro na base de dados.
  const fetchBook = async (book_id) => {

    try {
      const docRef = doc(db, "books", book_id);
      const docSnap = await getDoc(docRef);

      if (docSnap.exists()) {
        setBook({ ...docSnap.data(), id: docSnap.id });
      }

      setFetchStatus("success");
    } catch (err) {
      console.log('error', err);
      setFetchStatus("error");
    }
  }
  // Usa useEffect para buscar o livro pelo id quando o status é 'idle'.
  useEffect(() => {
    if (fetchStatus == 'idle') {
      fetchBook(id);
    }

  }, []);

  return (
    <>

      <div className="container">
        <Link to="/">
          <button className="btn">
            ← Voltar para os livros
          </button>
        </Link>

        {book ?

          <div>
            <div className="single-book">
              <div className="book-cover">
                <img src={book.cover} />
              </div>

              <div className="book-details">
                <h3 className="book-title">{book.title}</h3>
                <h4 className="book-author">{book.author}</h4>
                <p>{book.synopsis}</p>
                <div className="read-checkbox">
                  <input
                    onClick={() => { handleToggleRead({ id: book.id, isRead: book.isRead }) }}
                    type="checkbox"
                    defaultChecked={book.isRead} />
                  <label>{book.isRead ? "Já li!" : "Ainda não li!"}</label>
                </div>
                <div onClick={() => handleEraseBook(book.id)} className="erase-book">
                  Excluir da lista
                </div>
              </div>
            </div>

            <Notes bookId={id} />
          </div>

          : fetchStatus == 'success' ?

            <div>
              <p>Livro não encontrado! Retorne a lista com todos os livros.</p>
            </div>

            : fetchStatus == 'error' ?

              <div>
                <p>Erro ao obter livro!</p>
              </div> :

              <div>
                <p>Carregando...</p>
              </div>
        }
      </div>

    </>
  )
}

export default SingleBookPage
