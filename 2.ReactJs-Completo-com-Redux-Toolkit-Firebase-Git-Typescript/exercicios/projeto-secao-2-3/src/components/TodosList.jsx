import { useTodos } from '../TodosContext.jsx';
import Todo from './Todo.jsx';

// Função que define o componente que aglomera a lista de Todos.
function TodosList() {
  // Definição do state para os todos.
  const store = useTodos();

  return (
    /*
      Map itera todos os todos da lista e possibilita a construção de todos os componentes relativo a um Todo
      com as props(todo, key) enviadas.
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