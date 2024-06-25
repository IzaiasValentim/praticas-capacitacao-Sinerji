import { collection, query, where, getDocs, doc, deleteDoc, addDoc } from "firebase/firestore";
import { useEffect, useState } from 'react';
import { db } from '../firebase/config.js';

function Notes({ bookId }) {

  const handleEraseNote = async (id) => {
    if (confirm('Realmente deseja excluir esta anotação?  ')) {
      try {
        await deleteDoc(doc(db, "notes", id));
        setNotes(notes.filter(note => note.id != id));
      } catch (error) {
        alert('Error deleting note');
      }
    }
  }

  const handleAddNote = async (e) => {
    e.preventDefault();

    const newNote = {
      book_id: bookId,
      title: document.querySelector('input[name=title]').value,
      text: document.querySelector('textarea[name=note]').value
    }
    if (newNote.title && newNote.text) {

      try {
        const docRef = await addDoc(collection(db, "notes"), newNote);
        newNote.id = docRef.id;
        setNotes([...notes, newNote]);
        document.querySelector('input[name=title]').value = "";
        document.querySelector('textarea[name=note]').value = "";

      } catch (error) {
        alert('Erro ao salvar nota!');
      }

    } else {
      alert('Por favor, preencha os os campos necessários');
    }

  }

  const fetchNotes = async (book_id) => {

    try {
      const q = query(collection(db, "notes"), where("book_id", "==", book_id));
      const querySnapshot = await getDocs(q);
      let notesList = [];
      querySnapshot.forEach((doc) => {
        notesList.push({ ...doc.data(), id: doc.id });
      });
      setNotes(notesList);
      setFetchStatus("success");
    } catch (err) {
      console.log('error', err);
      setFetchStatus("error");
    }
  }

  const [notes, setNotes] = useState("");
  const [fetchStatus, setFetchStatus] = useState("idle");

  useEffect(() => {
    if (fetchStatus == 'idle') {
      fetchNotes(bookId);
    }

  }, []);


  return (
    <>

      <div className="notes-wrapper">

        <h2>Minhas anotações</h2>

        {notes.length ?

          <div className="notes">
            {notes.map(note =>
              <div key={note.id} className="note">
                <div onClick={() => handleEraseNote(note.id)} className="erase-note">Excluir esta anotação</div>
                <h3>{note.title}</h3>
                <p>{note.text}</p>
              </div>
            )}
          </div>

          : fetchStatus == 'success' ?

            <div>
              <p>Este livro ainda não possui anotações. Crie uma, se quiser :D</p>
            </div>

            : fetchStatus == 'error' ?

              <div>
                <p>Erro ao consultar notas!</p>
              </div> :

              <div>
                <p>Carregando...</p>
              </div>


        }

        <details>
          <summary>Adicionar uma anotação</summary>
          <form className="add-note">
            <div className="form-control">
              <label>Title *</label>
              <input type="text" name="title" placeholder="Título da anotação" />
            </div>
            <div className="form-control">
              <label>Note *</label>
              <textarea type="text" name="note" placeholder="Qual a sua anotação?" />
            </div>

            <button onClick={(e) => { handleAddNote(e) }} className="btn btn-block">Adicionar</button>
          </form>
        </details>

      </div>

    </>
  )
}

export default Notes
