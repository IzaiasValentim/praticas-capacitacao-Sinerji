import { useTodos } from '../TodosContext.jsx';
import Todo from './Todo.jsx';

function TodosList() {
  // Definição do state para os todos.
  const store = useTodos();

  return (
    /*
      Map itera todos os todos da lista e possibilita a construção de todos os componente Todo com as props(todo, key) enviadas.
    */
    <>
      <div className="todos">

        {store.filteredTodos().length ? store.filteredTodos().map(todo =>

          <Todo
            todo={todo}
            key={todo.id}
          />

        ) :
          <p>Nenhuma tarefa a ser apresentada :c</p>
        }
      </div>
    </>
  )
}

export default TodosList