package Desafios;

public class DesafioDoProduto {
    static double desconto = 0.25;
    String nome;
    double preco;

    DesafioDoProduto(){}

    DesafioDoProduto(String nomeProduto, double precoProduto){
        nome = nomeProduto;
        preco = precoProduto;
    }

    double precoComDesconto(){
        return preco * (1-desconto);
    }
}
