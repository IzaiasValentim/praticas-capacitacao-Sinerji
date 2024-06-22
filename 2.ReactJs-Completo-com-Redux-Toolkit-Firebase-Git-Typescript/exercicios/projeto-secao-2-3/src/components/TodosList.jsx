import { useContext } from 'react';
import { TodosContext } from '../TodosContext.js';
import Todo from './Todo.jsx';

function TodosList() {
  // Definição do state para os todos.
  const store = useContext(TodosContext);

  // Função que deleta um todo pelo id.
  function deleteHandler(id) {
    if (confirm(' Tem certeza que desejas apagar a tareffa?')) {
      store.setTodos(store.todos.filter(todo => todo.id !== id));
    }
  }

  // função que muda o valor lógico de isDone de um todo.
  function toggleIsDoneHandler(id) {

    store.setTodos(store.todos.map(todo => {
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

        {store.todos.map(todo =>

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