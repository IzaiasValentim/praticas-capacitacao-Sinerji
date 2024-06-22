import { createContext, useReducer, useContext, useState, useEffect} from "react";
export const TodosContext = createContext("");

// Array inicial com os todos armazenados no localStorage.
const initialTodos = localStorage.getItem('todos') ? 
    JSON.parse(localStorage.getItem('todos')) 
    : [];

export function TodosProvider({ children }) {

    // Definição do state para os todos.
    const [todos, dispatch] = useReducer(todosReducer, initialTodos);

    const [modalIsActive, setModalIsActive] = useState(false);

    const [filterBy, setFilterBy] = useState('');

    function filteredTodos() {
        switch (filterBy) {
            case 'todo':
                return todos.filter(todo => !todo.isDone);
            case 'done':
                return todos.filter(todo => todo.isDone);
            default:
                return todos;
        }
    }

    useEffect(() => {
        localStorage.setItem('todos', JSON.stringify(todos))
    }, [todos]);

    return (
        <>
            <main>
                <TodosContext.Provider value={
                    {
                        todos, dispatch,
                        modalIsActive, setModalIsActive,
                        filterBy, setFilterBy, filteredTodos
                    }
                }>
                    {children}
                </TodosContext.Provider>
            </main>
        </>
    )
}

export function useTodos() {
    return useContext(TodosContext);
}

export default function todosReducer(todos, action) {

    switch (action.type) {
        // Deleta um todo da lista de todos.
        case 'deleted': {
            if (confirm('Are you sure you want to delete the to-do?')) {
                return todos.filter(todo => todo.id !== action.id);
            } else {
                return todos;
            }
        }
        // Marca ou desmarca uma tarefa da lista como isDone.
        case 'toggledIsDone': {
            return (todos.map(todo => {
                if (todo.id === action.id) {
                    todo.isDone = !todo.isDone;
                    return todo;
                } else {
                    return todo;
                }
            }));
        }

        // Realiza a adição de uma nova tarefa a lista de todos. É realizada     a definição de um novo id. 
        case 'added': {
            let newTodo = action.newTodo;
            newTodo.id = todos.length ? Math.max(...todos.map(todo => todo.id)) + 1 : 1;
            return [...todos, newTodo];
        }

    }
}