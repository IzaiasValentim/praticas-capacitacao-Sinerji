import { useParams, Link, useNavigate } from 'react-router-dom';
import Notes from '../components/Notes.jsx';
import { useSelector, useDispatch } from 'react-redux';
import { selectBooks, eraseBook, toggleRead } from '../store/booksSlice.js';
import { eraseBookNotes } from '../store/notesSlice.js';

function SingleBookPage() {

  const dispatch = useDispatch();
  const navigate = useNavigate();

  function handleEraseBook(id) {
    if (confirm('Você deseja excluir este livro juntamente à suas anotações?')) {
      dispatch(eraseBook(id));
      dispatch(eraseBookNotes(id));
      navigate("/");
    }
  }

  // Recebe o id passado no endereço path="book/:id" 
  const { id } = useParams();

  const books = useSelector(selectBooks);

  /* Para exibir a página idividual do livro, as informações dele é obtida
     pelo filtragem do id abaixo */
  const book = books.filter(book => book.id == id)[0];

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
                    onClick={() => { dispatch(toggleRead(book.id)) }}
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

          :

          <div>
            <p>Livro não encontrado! Retorne a lista com todos os livros.</p>
          </div>

        }


      </div>


    </>
  )
}

export default SingleBookPage
