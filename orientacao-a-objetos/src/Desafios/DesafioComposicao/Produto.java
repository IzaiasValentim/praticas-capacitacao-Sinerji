package Desafios.DesafioComposicao;

public class Produto {
    String nome;
    double preco;
    int estoque;

    Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = quantidade;
    }
}
