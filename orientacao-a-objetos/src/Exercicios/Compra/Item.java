package Exercicios.Compra;

public class Item {
    String nome;
    int quantidade;
    double preco;
    Compra compraDesteItem;
    Item(String nome, int quantidade, double preco){
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }
}
