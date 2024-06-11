package Exercicios.UsoInterfacesFunctionals;

import java.util.function.Predicate;

public class UsoInterfacePredicate {
    public static void main(String[] args) {
        Predicate<Produto> isCaro = produto ->(produto.preco * (1-produto.desconto))>=2500.0;

        Produto notebook = new Produto("Notebook", 3500.0,0.15);
        System.out.println(isCaro.test(notebook));
    }
}
