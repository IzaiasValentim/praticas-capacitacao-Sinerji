package Exercicios.UsoInterfacesFunctionals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class UsoInterfaceConsumer {
    public static void main(String[] args) {

        Consumer<Produto> imprimir = produto -> System.out.println(produto.nome);

        Produto celular = new Produto("Samsung alguma coisa", 2000.0, 0.05);
        imprimir.accept(celular);

        System.out.println("Exemplo uso de foreach e a interface Consumer<T>: ");
        Produto mesa = new Produto("Mesa 5 lugares", 750.0, 0.05);
        Produto cadeira = new Produto("Cadeira", 120.0, 0.05);
        Produto cama = new Produto("Cama", 2000.0, 0.1);
        List<Produto> produtos = Arrays.asList(celular, mesa, cadeira, cama);

        produtos.forEach(imprimir);
    }
}
