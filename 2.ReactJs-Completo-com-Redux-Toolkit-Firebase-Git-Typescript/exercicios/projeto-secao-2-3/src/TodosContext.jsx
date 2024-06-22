import { createContext, useReducer, useContext, useState, useEffect } from "react";
export const TodosContext = createContext("");

// Array inicial com os todos armazenados obtidos no localStorage.
const initialTodos = localStorage.getItem('todos') ?
    JSON.parse(localStorage.getItem('todos'))
    : [];

export function TodosProvider({ children }) {

    // Definição do state para os todos.
    const [todos, dispatch] = useReducer(todosReducer, initialTodos);

    // Definição do state para o formulário de cadastro de uma nova tarefa/todo.
    const [modalIsActive, setModalIsActive] = useState(false);

    // Definição do state para o filtro que será aplicado na lista de todos.
    const [filterBy, setFilterBy] = useState('');

    /*
        A função filteredTodos irá retornar a lista de todo de acordo com o state.
        Ela é chamada no componente Filter a partir dos botões correspondentes a filtro desejado.
        Casos: 
            -> 'todo': retorna todas as tarefas ainda não realizadas
            -> 'done': retorna todas as tarefas feitas.
            -> default: retorna todas as tarefas(realizadas ou não).
    
    */
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

    // Salva a lista de todos atual no localStorage.
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

// Função que centraliza o context de toda aplicação.
export function useTodos() {
    return useContext(TodosContext);
}

// Reducer da aplicação que recebe um estado(todos) e ação(action). Retorna o estado atualizado de acordo com a ação.
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

        // Realiza a adição de uma nova tarefa a lista de todos. É realizada a definição de um novo id. 
        case 'added': {
            let newTodo = action.newTodo;
            newTodo.id = todos.length ? Math.max(...todos.map(todo => todo.id)) + 1 : 1;
            return [...todos, newTodo];
        }

    }
}