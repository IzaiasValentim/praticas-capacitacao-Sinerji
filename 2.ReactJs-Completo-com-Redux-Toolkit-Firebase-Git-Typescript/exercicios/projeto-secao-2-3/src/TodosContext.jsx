import { createContext, useReducer, useContext, useState } from "react";
export const TodosContext = createContext("");

// Array com alguns todos base.
const initialTodos = [
    { id: 0, title: 'Do Groceries', description: 'Buy apples, rice, juice and toilet paper.', isDone: true },
    { id: 1, title: 'Study React', description: 'Understand context & reducers.', isDone: false },
    { id: 2, title: 'Learn Redux', description: 'Learn state management with Redux', isDone: false }
];

export function TodosProvider({ children }) {

    // Definição do state para os todos.
    const [todos, dispatch] = useReducer(todosReducer, initialTodos);

    const [modalIsActive, setModalIsActive] = useState(false);

    const [filterBy, setFilterBy] = useState('');

    function filteredTodos(){
        switch(filterBy){
            case 'todo':
                return todos.filter(todo => !todo.isDone);
            case 'done':
                return todos.filter(todo => todo.isDone);
            default:
                return todos;
        }
    }

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