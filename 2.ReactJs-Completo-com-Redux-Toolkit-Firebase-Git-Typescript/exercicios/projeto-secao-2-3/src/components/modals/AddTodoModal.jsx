import {useTodos} from '../../TodosContext.jsx';


function AddTodoModal() {
    
    const store = useTodos();

    /*
        addTaskHandler realiza a validação do formulário para adicionar uma nova tarefa a lista de todos.
            
            - Em caso positivo, o usuário fornece todos os campos, será acionado o dispatch do reducer
            do tipo 'added' para adicionar uma tarefa. A janela do formulário e fechada ao final.

            - Se todos os campos não forem informados será emitido um alerta solicitando-os.
     */
    function addTaskHandler() {
        let newTodo = {isDone: false};
        newTodo.title = document.querySelector('input[name=title]').value;
        newTodo.description = document.querySelector('textarea[name=description]').value;
        if (newTodo.title && newTodo.description) {
            store.dispatch({type: 'added', newTodo});
            store.setModalIsActive(false);
        } else {
            alert('Informe o nome e a descrição para a tarefa a ser adicionada...');
        }
    }

    return (
    <>
        <div className="form">      
            <h3>Add a new task</h3>
            <label htmlFor="title">Title *</label>
            <input type="text" name="title" placeholder="Enter a title..." /><br />
            <label htmlFor="description">Description *</label>
            <textarea name="description" rows="4" placeholder="Enter a description..." /><br />
            <button onClick={addTaskHandler} className="btn gray">Add Task</button>
        </div>
    </>
    )
  }
  
  export default AddTodoModal