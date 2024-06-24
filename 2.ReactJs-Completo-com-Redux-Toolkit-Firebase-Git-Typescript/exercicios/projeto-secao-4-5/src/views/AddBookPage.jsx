import Header from '../components/Header.jsx';
import { useNavigate } from 'react-router-dom';
import { useDispatch } from 'react-redux';
import { addBook } from '../store/booksSlice.js';

function AddBookPage() {

    const dispatch = useDispatch();
    const navigate = useNavigate();

    /* 
        infos: 
        -> handleAddBook é a função chamada para adicionar um novo livro a lista.
        -> É realizada a validação dos dados.
        -> A adição do livro  é de fato feito por meio da chamada do dispatch do reducer. 
        -> navigate("/"); É utilizada para redirecionar a aplicação para o path informado.

    */
    function handleAddBook(e) {
        e.preventDefault();

        const newBook = {
            title: document.querySelector('input[name=title]').value,
            cover: document.querySelector('input[name=cover]').value,
            isRead: false,
            author: document.querySelector('input[name=author]').value,
            synopsis: document.querySelector('textarea[name=synopsis]').value
        }

        if (newBook.title && newBook.cover && newBook.author) {
            dispatch(addBook(newBook));
            alert('O livro criado com sucesso!');
            navigate("/");
        } else {
            alert('Por favor, preencha os campos necessários!');
        }

    }

    const pageTitle = "Adicionar Livro";

    return (
        <>
            <div className="container">
                <Header pageTitle={pageTitle} />

                <form className="add-form">
                    <div className="form-control">
                        <label>Título *</label>
                        <input type="text" name="title" placeholder="Adicione o título do livro" />
                    </div>
                    <div className="form-control">
                        <label>Capa *</label>
                        <input type="text" name="cover" placeholder="Informe o endereço da capa do livro" />
                    </div>

                    <div className="form-control">
                        <label>Autor *</label>
                        <input
                            type="text" name="author" placeholder="Informe o autor" />
                    </div>

                    <div className="form-control">
                        <label>Sinopse</label>
                        <textarea
                            type="text" name="synopsis" placeholder="Adicione a sinopse" />
                    </div>

                    <button onClick={(e) => handleAddBook(e)} className="btn btn-block">Salvar livro</button>
                </form>

            </div>


        </>
    )
}

export default AddBookPage
