import { NavLink } from "react-router-dom";

function Header({ pageTitle }) {
  /* 
  infos:
    <NavLink to="path"> já direciona diretamente para um path declarado em <Route/>..
  */
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


      </div>

    </>
  )
}

export default Header
