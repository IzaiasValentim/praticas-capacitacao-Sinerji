<?php

use App\Controllers\CarsController;
use App\Controllers\CategoriesController;
use App\Controllers\CompanyController;
use App\Controllers\CustomersController;
use App\Controllers\HomeController;
use CodeIgniter\Router\RouteCollection;


/**
 * @var RouteCollection $routes
 * 
 */

// Rota para a página inicial da aplicação, mapeada para o método 'index' do HomeController
$routes->get('/', [HomeController::class, 'index'], ['as' => 'home']); 

# Conjunto de rotas para as funções das categorias.
$routes->group('categories', static function ($routes) {
    $routes->get('/', [CategoriesController::class, 'index'], ['as' => 'categories']); // Rota para listar todas as categorias
    $routes->get('new', [CategoriesController::class, 'new'], ['as' => 'categories.new']); // Rota para exibir o formulário de criação de uma nova categoria
    $routes->post('create', [CategoriesController::class, 'create'], ['as' => 'categories.create']); // Rota para processar a criação de uma nova categoria
    $routes->get('edit/(:segment)', [CategoriesController::class, 'edit/$1'], ['as' => 'categories.edit']); // Rota para exibir o formulário de edição de uma categoria específica
    $routes->put('update/(:segment)', [CategoriesController::class, 'update/$1'], ['as' => 'categories.update']); // Rota para processar a atualização de uma categoria específica
    $routes->delete('delete/(:segment)', [CategoriesController::class, 'delete/$1'], ['as' => 'categories.delete']); // Rota para excluir uma categoria específica
});

# Conjunto de rotas para as funções dos Mensalistas.
$routes->group('customers', static function ($routes) {
    $routes->get('/', [CustomersController::class, 'index'], ['as' => 'customers']); // Rota para listar todos os mensalistas (clientes)
    $routes->get('new', [CustomersController::class, 'new'], ['as' => 'customers.new']); // Rota para exibir o formulário de criação de um novo mensalista
    $routes->get('show/(:segment)', [CustomersController::class, 'show/$1'], ['as' => 'customers.show']); // Rota para exibir detalhes de um mensalista específico
    $routes->post('create', [CustomersController::class, 'create'], ['as' => 'customers.create']); // Rota para processar a criação de um novo mensalista
    $routes->get('edit/(:segment)', [CustomersController::class, 'edit/$1'], ['as' => 'customers.edit']); // Rota para exibir o formulário de edição de um mensalista específico
    $routes->put('update/(:segment)', [CustomersController::class, 'update/$1'], ['as' => 'customers.update']); // Rota para processar a atualização de um mensalista específico
    $routes->delete('delete/(:segment)', [CustomersController::class, 'delete/$1'], ['as' => 'customers.delete']); // Rota para excluir um mensalista específico
});

# Conjunto de rotas para as funções dos Carros.
$routes->group('cars', static function ($routes) {
    $routes->get('all/(:segment)', [CarsController::class, 'all/$1'], ['as' => 'customers.cars']); // Rota para listar todos os carros de um mensalista específico
    $routes->get('new/(:segment)', [CarsController::class, 'new/$1'], ['as' => 'customers.cars.new']); // Rota para exibir o formulário de criação de um novo carro para um mensalista específico
    $routes->get('edit/(:segment)', [CarsController::class, 'edit/$1'], ['as' => 'customers.cars.edit']); // Rota para exibir o formulário de edição de um carro específico
    $routes->post('create', [CarsController::class, 'create'], ['as' => 'customers.cars.create']); // Rota para processar a criação de um novo carro
    $routes->put('update/(:segment)', [CarsController::class, 'update/$1'], ['as' => 'customers.cars.update']); // Rota para processar a atualização de um carro específico
    $routes->delete('delete/(:segment)', [CarsController::class, 'delete/$1'], ['as' => 'customers.cars.delete']); // Rota para excluir um carro específico
});

# Conjunto de rotas para as funções da Company.
$routes->group('company', static function ($routes) {
    $routes->get('/', [CompanyController::class, 'index'], ['as' => 'company']); // Rota para exibir informações sobre a empresa
    $routes->match(['post', 'put'], 'process', [CompanyController::class, 'process'], ['as' => 'company.process']); // Rota para processar dados da empresa (tanto criação quanto atualização)
});
