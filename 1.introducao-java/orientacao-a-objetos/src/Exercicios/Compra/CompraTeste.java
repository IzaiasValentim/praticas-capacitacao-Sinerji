package Exercicios.Compra;

public class CompraTeste {
    public static void main(String[] args) {
        // Relacionamento 1 para muitos, bidirecional. 1 compra pode conter vários itens.

        // - Criação de itens:
        Item celular = new Item("Celular", 1, 2000.0);
        Item case_celular = new Item("Case para celular x", 2, 45.00);

        // Criação e adição dos itens da compra:
        Compra compraUm = new Compra("Izaias");
        System.out.println("O valor total da compra no momento é: "+compraUm.totalDaCompra());

        compraUm.adicionarItem(celular);
        System.out.println("O valor total da compra no momento é: "+compraUm.totalDaCompra());

        compraUm.adicionarItem(case_celular);
        System.out.println("O valor total da compra no momento é: "+compraUm.totalDaCompra());

        // De qual compra o item pertence:
        System.out.println("O celular comprado é de:"+celular.compraDesteItem);
        System.out.println("O celular comprado é de:"+case_celular.compraDesteItem);
    }
}
