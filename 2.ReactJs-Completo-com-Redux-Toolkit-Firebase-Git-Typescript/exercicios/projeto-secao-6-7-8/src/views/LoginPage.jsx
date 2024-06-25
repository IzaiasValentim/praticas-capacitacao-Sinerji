import FullPageLoader from '../components/FullPageLoader.jsx';
import { useState } from 'react';
import { auth } from '../firebase/config.js';
import {
  createUserWithEmailAndPassword,
  signInWithEmailAndPassword,
  sendPasswordResetEmail,
  onAuthStateChanged
} from "firebase/auth";
import { useDispatch } from 'react-redux';
import { setUser } from '../store/usersSlice.js';

// Componente para a página de login e cadastro.
function LoginPage() {

  const dispatch = useDispatch();
  const [isLoading, setIsLoading] = useState(true);
  const [loginType, setLoginType] = useState('login');
  const [userCredentials, setUserCredentials] = useState({});
  const [error, setError] = useState('');
  
  // Monitora o estado de autenticação do usuário.
  onAuthStateChanged(auth, (user) => {
    if (user) {
      dispatch(setUser({ id: user.uid, email: user.email }));
    } else {
      dispatch(setUser(null));
    }
    if (isLoading) { setIsLoading(false) };

  });

  // Atualiza as credenciais do usuário conforme ele digita.
  function handleCredentials(e) {
    setUserCredentials({ ...userCredentials, [e.target.name]: e.target.value });
  }

  // Função do cadastro de um novo usuário.
  function handleSignup(e) {
    e.preventDefault();
    setError("");
    createUserWithEmailAndPassword(auth, userCredentials.email, userCredentials.password)
      .then((userCredential) => {
        dispatch(setUser({ id: userCredential.user.uid, email: userCredential.user.email }));
      })
      .catch((error) => {
        setError(error.message);
      });
  }
  // Função do login do usuário.
  function handleLogin(e) {
    e.preventDefault();
    setError("");

    signInWithEmailAndPassword(auth, userCredentials.email, userCredentials.password)
      .then((userCredential) => {
        dispatch(setUser({ id: userCredential.user.uid, email: userCredential.user.email }));
      })
      .catch((error) => {
        setError(error.message);
      });
  }

  // Função que cuida da redefinição de senha.
  function handlePasswordReset() {
    const email = prompt('Informe o seu e-mail');
    sendPasswordResetEmail(auth, email);
    alert('E-mail enviado! Confira a sua entrada de e-mails para as instruções de redefinição de senha.');
  }

  return (
    <>
      {isLoading && <FullPageLoader></FullPageLoader>}

      <div className="container login-page">
        <section>
          <h1>Bem vindo à sua estante de livros</h1>
          <p>Realize o login ou cadastre-se para continuar...</p>
          <div className="login-type">
            <button
              className={`btn ${loginType == 'login' ? 'selected' : ''}`}
              onClick={() => setLoginType('login')}>
              Login
            </button>
            <button
              className={`btn ${loginType == 'signup' ? 'selected' : ''}`}
              onClick={() => setLoginType('signup')}>
              Signup
            </button>
          </div>
          <form className="add-form login">
            <div className="form-control">
              <label>Email *</label>
              <input onChange={(e) => { handleCredentials(e) }} type="text" name="email" placeholder="Informe o seu e-mail" />
            </div>
            <div className="form-control">
              <label>Senha *</label>
              <input onChange={(e) => { handleCredentials(e) }} type="password" name="password" placeholder="Informe a sua senha" />
            </div>
            {
              loginType == 'login' ?
                <button onClick={(e) => { handleLogin(e) }} className="active btn btn-block">Login</button>
                :
                <button onClick={(e) => { handleSignup(e) }} className="active btn btn-block">Sign Up</button>
            }

            {
              error &&
              <div className="error">
                {error}
              </div>
            }

            <p onClick={handlePasswordReset} className="forgot-password">Esqueceu sua senha?</p>

          </form>
        </section>
      </div>
    </>
  )
}

export default LoginPage
