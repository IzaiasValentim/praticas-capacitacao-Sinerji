-- Consulta todas as informações da tabela.
SELECT * FROM estados;

-- Consulta apenas a sigla e nome de todas os cadastros na tabela.
SELECT sigla, nome FROM estados;

-- Conlsulta apenas os estados da regiao nordeste.
SELECT sigla, nome as 'Nome do estado' FROM estados WHERE regiao='NORDESTE';

-- Consulta estados com população maior que 3milhoes em ordem crescente.
SELECT populacao, nome as 'Nome do estado' FROM estados WHERE populacao>=3 order by populacao;