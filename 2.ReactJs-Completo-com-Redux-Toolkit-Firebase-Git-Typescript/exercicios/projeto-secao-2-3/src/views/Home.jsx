import Filter from '../components/Filter.jsx';
import TodosList from '../components/TodosList.jsx';
import AddTodoModal from "../components/modals/AddTodoModal.jsx"
import ModalWindow from "../components/modals/ModalWindow.jsx"


function Home() {

    return (
    <>
        <ModalWindow>
            <AddTodoModal/>
        </ModalWindow>
        <div className="container">
            <Filter />

            <TodosList />
        </div>

    </>
    )
  }
  
  export default Home
