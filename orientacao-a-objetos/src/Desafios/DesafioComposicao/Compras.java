package Desafios.DesafioComposicao;

import java.util.ArrayList;

public class Compras {
    ArrayList<Item> listaDeItens = new ArrayList<>();
    Cliente cliente;

    Compras(Cliente cliente) {
        this.cliente = cliente;
    }

    void verItens() {
        int cont = 0;
        for (Item i : listaDeItens) {
            System.out.printf("%d -  nome - %s - quant - %d\n", ++cont, i.produto.nome, i.quantidade);
        }
    }

    Boolean adicionarProdutoALista(Item item, int quantidade) {

        if (item.produto.estoque > 0 && item.produto.estoque >= quantidade) {
            listaDeItens.add(item);
            item.produto.estoque -= quantidade;
            System.out.println("\n" + item.produto.nome + " adicionado a lista de " + cliente.nome + " com sucesso!");
            return true;
        } else {
            System.out.println("\nNão há estoque para " + item.produto.nome);
            return false;
        }
    }

    double totalDaCompra() {
        double total = 0.0;
        for (Item item : listaDeItens) {
            total += item.quantidade * item.produto.preco;
        }
        return total;
    }

}
