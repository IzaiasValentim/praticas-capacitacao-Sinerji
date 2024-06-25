import { createSlice } from '@reduxjs/toolkit';

/**
  - usersSlice gerencia o estado relacionado aos usuários na aplicação usando createSlice do Redux Toolkit.
  
  - Estrutura inicial:
    - currentUser: Inicialmente null, armazenará as informações do usuário atualmente autenticado.
  
  - Redutores:
    - setUser: Atualiza o estado currentUser com os dados do usuário fornecido na ação.
  
  - Ações Exportadas:
    - setUser: Ação para definir o usuário atual.
  
  - Seletores Exportados:
    - selectUsers: Função seletora para acessar o estado dos usuários na store.
  
  - Exporta o reducer gerado pelo slice para ser utilizado na configuração da store.
 */
export const usersSlice = createSlice({
  name: 'users',
  initialState: {
    currentUser: null
  },
  reducers: {
    setUser: (users, action) => {
      users.currentUser = action.payload;
    }
  }
})

export const { setUser } = usersSlice.actions;

export const selectUsers = state => state.users;

export default usersSlice.reducer;