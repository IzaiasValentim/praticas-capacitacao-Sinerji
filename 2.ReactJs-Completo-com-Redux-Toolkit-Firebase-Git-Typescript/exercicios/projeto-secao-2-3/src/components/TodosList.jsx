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

        {store.todos.map(todo =>

          <Todo
            todo={todo}
            key={todo.id}
          />

        )}

      </div>
    </>
  )
}

export default TodosList