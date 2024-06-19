package Desafios;

public class DesafioDoProduto {
    private static double desconto = 0.25;
    private String nome;
    private double preco;

    DesafioDoProduto(String nomeProduto, double precoProduto) {
        this.nome = nomeProduto;
        this.preco = precoProduto;
    }

    public static double getDesconto() {
        return desconto;
    }

    public static void setDesconto(double desconto) {
        DesafioDoProduto.desconto = desconto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double precoComDesconto() {
        return preco * (1 - desconto);
    }

}
