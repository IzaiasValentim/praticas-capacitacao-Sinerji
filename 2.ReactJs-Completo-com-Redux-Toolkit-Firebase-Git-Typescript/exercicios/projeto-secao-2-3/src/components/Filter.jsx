import './Filter.scss';
import { useTodos } from '../TodosContext';

/*
    Função que define o componente Filter. Cada botão é relativo a um filtro que será aplicado 
    à lista de todos.
*/
function Filter() {

    const store = useTodos();
    /*
        Em cada botão de opção de filtro:
        -> O visual da seleção é definido pela validação feita pelo operador ternario e o estado filterBy.
        -> A ação de cada botão realizada a chamada de setFilterBy() que muda o estado do filtro.
        -> O estado é importante para a função filteredTodos() em TodosContext, que irá filtrar a lista de todos exibida.
    */
    return (
        <>
            <div className="filters">
                <div>
                    <p>Filter by state</p>
                    <div className="badges">
                        <div
                            className={`badge ${store.filterBy === 'todo' ? 'selected' : ''}`}
                            onClick={() => store.setFilterBy('todo')}>
                            To-Do
                        </div>
                        <div
                            className={`badge ${store.filterBy === 'done' ? 'selected' : ''}`}
                            onClick={() => store.setFilterBy('done')}>
                            Done
                        </div>
                        {
                            store.filterBy &&
                            <span onClick={() => store.setFilterBy('')} className="clear">
                                x clear
                            </span>
                        }

                    </div>
                </div>
            </div>
        </>
    )
}

export default Filter