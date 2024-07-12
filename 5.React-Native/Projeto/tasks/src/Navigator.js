import React from 'react'
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import { createDrawerNavigator } from '@react-navigation/drawer';

import Auth from './screens/Auth'
import TaskList from './screens/TaskList'

import AuthOrApp from './screens/AuthOrApp'
import Menu from './screens/Menu'
import commonStyles from './commonStyles'

// Criação dos navegadores Stack e Drawer.
const Stack = createStackNavigator();
const Drawer = createDrawerNavigator();

// Configuração do meu Drawer.
const menuConfig = {
    labelStyle: {
        fontFamily: commonStyles.fontFamily,
        fontWeight: 'normal',
        fontSize: 20
    },
    activeTintColor: '#080',
}

/**
 * Foi necessário adequar o Navigator às novas versões do Navigation(>5). Onde toda a estrutura de navegação foi alterada com  relação 
 * a passada no curso.
 */

// Componente do Drawer Navigator 5.
const DrawerNavigator = props => {
    const { email, name } = props.route.params
    return (
        <Drawer.Navigator drawerContentOptions={menuConfig} drawerContent={(props) => <Menu {...props} email={email} name={name} />}>
            <Drawer.Screen name="Today" options={{ title: 'Hoje' }}>
                {props => <TaskList {...props} title='Hoje' daysAhead={0} />}
            </Drawer.Screen>
            <Drawer.Screen name="Tomorrow" options={{ title: 'Amanhã' }}>
                {props => <TaskList {...props} title='Amanhã' daysAhead={1} />}
            </Drawer.Screen>
            <Drawer.Screen name="Week" options={{ title: 'Semana' }}>
                {props => <TaskList {...props} title='Semana' daysAhead={7} />}
            </Drawer.Screen>
            <Drawer.Screen name="Month" options={{ title: 'Mês' }}>
                {props => <TaskList {...props} title='Mês' daysAhead={30} />}
            </Drawer.Screen>
        </Drawer.Navigator>
    );
};


// Pilha de navegação.
const AuthNavigator = () => {
    return (
        <Stack.Navigator screenOptions={{ headerShown: false }}>
            <Stack.Screen name="AuthOrApp" component={AuthOrApp} />
            <Stack.Screen name="Auth" component={Auth} />
            <Stack.Screen name="Home" component={DrawerNavigator} />
        </Stack.Navigator>
    );
};

// Componente Navigator que contém o container de navegação.
const Navigator = () => {
    return (
        <NavigationContainer>
            <AuthNavigator />
        </NavigationContainer>
    );
};

export default Navigator;