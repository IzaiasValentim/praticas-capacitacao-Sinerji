import { useState } from 'react';
import Todo from './Todo.jsx';

// Array com alguns todos base.
const initialTodos = [
  { id: 0, title: 'Do Groceries', description: 'Buy apples, rice, juice and toilet paper.', isDone: true },
  { id: 1, title: 'Study React', description: 'Understand context & reducers.', isDone: false },
  { id: 2, title: 'Learn Redux', description: 'Learn state management with Redux', isDone: false }
];

function TodosList() {
  // Definição do state para os todos.
  const [todos, setTodos] = useState(initialTodos);

  // Função que deleta um todo pelo id.
  function deleteHandler(id) {
    if (confirm(' Tem certeza que desejas apagar a tareffa?')) {
      setTodos(todos.filter(todo => todo.id !== id));
    }
  }

  // função que muda o valor lógico de isDone de um todo.
  function toggleIsDoneHandler(id) {

    setTodos(todos.map(todo => {
      if (todo.id === id) {
        todo.isDone = !todo.isDone;
        return todo;
      } else {
        return todo;
      }
    }));

  }

  return (
    /*
      Map itera todos os todos da lista e possibilita a construção de todos os componente Todo com as props(todo, key) enviadas.
    */
    <>
      <div className="todos">

        {todos.map(todo =>

          <Todo
            todo={todo}
            deleteTodo={(id) => deleteHandler(id)}
            toggleIsDone={(id) => toggleIsDoneHandler(id)}
            key={todo.id}
          />

        )}

      </div>
    </>
  )
}

export default TodosList