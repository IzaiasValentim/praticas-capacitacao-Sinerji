package Exercicios.Compra;

import java.util.ArrayList;

public class Compra {
    String nomeCliente;
    ArrayList<Item> itens = new ArrayList<>();

    Compra(String nomeCliente){
        this.nomeCliente =  nomeCliente;
    }
    void adicionarItem(Item i){
        itens.add(i);
        i.compraDesteItem = this;
    }
    double totalDaCompra() {
        double total = 0.0;
        for (Item i : itens) {
            total += i.preco;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Compra de "+this.nomeCliente;
    }
}
