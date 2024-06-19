package Desafios.DesafioComposicao;

import java.util.ArrayList;

public class Cliente {
    String nome;
    ArrayList<Compras> comprasDoCliente = new ArrayList<>();

    Cliente(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    void realizarUmaCompra(Produto produto, int quantidade) {
        // Cria um item com a quantiade a ser comprada e verifica se é possível adicionar um item.
        Item item = new Item(produto, quantidade);
        Compras compra = new Compras(this);
        if (compra.adicionarProdutoALista(item, quantidade)) {
            comprasDoCliente.add(compra);
        }
    }

    void verTodasAsCompras() {
        for (Compras compra : comprasDoCliente) {
            compra.verItens();
        }
    }

    double totalDeTodasCompras() {
        double total = 0.0;
        for (Compras compra : comprasDoCliente) {
            total += compra.totalDaCompra();
        }
        return total;
    }

    double totalDaCompra(int id) {
        return comprasDoCliente.get(id - 1).totalDaCompra();
    }

}
