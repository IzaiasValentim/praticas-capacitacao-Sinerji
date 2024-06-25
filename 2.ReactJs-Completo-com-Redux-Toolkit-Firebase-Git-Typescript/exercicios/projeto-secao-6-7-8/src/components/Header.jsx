import { NavLink } from "react-router-dom";
import { signOut } from "firebase/auth";
import { auth } from '../firebase/config.js';
import { useDispatch } from 'react-redux';
import { setUser } from '../store/usersSlice.js';

function Header({ pageTitle }) {

  const dispatch = useDispatch();

  function handleSignOut() {
    if (confirm('Certeza que deseja sair?')) {
      signOut(auth).then(() => {
        dispatch(setUser(null));
        location.reload();
      }).catch((error) => {
        console.log(error);
      });

    }
  }

  return (
    <>

      <h1>{pageTitle}</h1>

      <div className="header-btns">

        <NavLink to="/">
          <button className="btn">
            Todos os livros
          </button>
        </NavLink>

        <NavLink to="/add-book">
          <button className="btn">
            Adicionar livro +
          </button>
        </NavLink>

        <button onClick={handleSignOut} className="btn transparent">
          Logout
        </button>


      </div>

    </>
  )
}

export default Header
