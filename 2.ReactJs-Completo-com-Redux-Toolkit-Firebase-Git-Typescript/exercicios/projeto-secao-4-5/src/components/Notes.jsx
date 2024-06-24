
import {useSelector, useDispatch} from 'react-redux';
import {selectNotes, eraseNote, addNote} from '../store/notesSlice.js';

function Notes({bookId}) {
    
    const dispatch = useDispatch();
    
    function handleEraseNote(id) {
      if(confirm('Realmente deseja excluir esta anotação?')) {
        dispatch(eraseNote(id));
      }
    }

    function handleAddNote(e) {
      e.preventDefault();

      const newNote = {
        book_id: bookId,
        title: document.querySelector('input[name=title]').value,
        text: document.querySelector('textarea[name=note]').value
      }
      if (newNote.title && newNote.text) {
          dispatch(addNote(newNote));
          document.querySelector('input[name=title]').value = "";
          document.querySelector('textarea[name=note]').value = "";
      } else {
          alert('Por favor, preencha os os campos necessários');
      }

  }

    const notes = useSelector(selectNotes).filter(note => note.book_id == bookId);
    
    return (
      <>

        <div className="notes-wrapper">

            <h2>Minhas anotações</h2>

            {notes.length ?

              <div className="notes">
              {notes.map(note => 
                  <div key={note.id} className="note">
                      <div onClick={()=>handleEraseNote(note.id)} className="erase-note">Excluir esta anotação</div>
                      <h3>{note.title}</h3>
                      <p>{note.text}</p>
                  </div>
                  )}
              </div>

              :

              <p>Este livro ainda não possui anotações. Crie uma, se quiser :D</p>
            }
            

            <details>
                <summary>Adicionar uma anotação</summary>
                <form className="add-note">
                    <div className="form-control">
                        <label>Titulo *</label>
                        <input type="text" name="title" placeholder="Título da anotação" />
                    </div>
                    <div className="form-control">
                        <label>Anotação *</label>
                        <textarea type="text" name="note" placeholder="Qual a sua anotação?" />
                    </div>
                    
                    <button onClick={(e)=>{handleAddNote(e)}}className="btn btn-block">Adicionar</button>
                </form>
            </details>

        </div>

      </>
    )
  }
  
  export default Notes
  