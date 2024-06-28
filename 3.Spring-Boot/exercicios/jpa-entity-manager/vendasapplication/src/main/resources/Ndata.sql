-- Arquivo SQL que possibilita a criação das tabelas a cada inicialização da aplicação.
	-- Tabela do cliente
	CREATE TABLE IF NOT EXISTS CLIENTE(
		ID INTEGER PRIMARY KEY AUTO_INCREMENT,
		NOME VARCHAR(100)
	);

	-- Tabela do produto.
	CREATE TABLE IF NOT EXISTS PRODUTO(
		ID INTEGER PRIMARY KEY AUTO_INCREMENT,
		DESCRICAO VARCHAR(100),
		PRECO NUMERIC(20,2)
	);

	-- Tabela que representa um pedido, ela relaciona um pedido a um cliente.
	CREATE TABLE IF NOT EXISTS PEDIDO(
		ID INTEGER PRIMARY KEY AUTO_INCREMENT,
		CLIENTE_ID INTEGER REFERENCES CLIENTE(ID),
		DATA_PEDIDO TIMESTAMP,
		TOTAL_PEDIDO NUMERIC(20,2)
	);

	-- Tabela que relaciona um pedido a vários itens pedidos.
	CREATE TABLE IF NOT EXISTS ITEM_PEDIDO(
		ID INTEGER PRIMARY KEY AUTO_INCREMENT,
		PEDIDO_ID INTEGER REFERENCES PEDIDO(ID),
		PRODUTO_ID INTEGER REFERENCES PRODUTO(ID),
		QUANTIDADE INTEGER
	);