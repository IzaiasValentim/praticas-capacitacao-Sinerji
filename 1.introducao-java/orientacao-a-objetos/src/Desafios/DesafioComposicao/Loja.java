package Desafios.DesafioComposicao;

public class Loja {
    public static void main(String[] args) {
        // Objetivo -> Fazer o relacionamento: Loja -> cliente 1 - n compras 1 - n item n - 1 produto

        //  Criação de um cliente.
        Cliente umCliente = new Cliente("Izaias");

        //Criação dos produtos e estoque.
        Produto arroz = new Produto("Arroz", 6.50, 50);
        Produto feijão = new Produto("Feijao", 9.00, 35);

        //Realizar a compra de 4arroz:
        umCliente.realizarUmaCompra(arroz, 10);

        //  Total de arroz em estoque apos a compra:
        System.out.println("Estoque de arroz: " + arroz.estoque);
        System.out.println("Todas as compras de " + umCliente.nome);
        umCliente.verTodasAsCompras();

        // Ver o total da compra apenas do arroz
        System.out.printf("\nTotal da primeira compra: ");
        System.out.print(umCliente.totalDaCompra(1));

        umCliente.realizarUmaCompra(feijão, 10);

        System.out.printf("\nTotal de todas as compras de " + umCliente.nome);
        System.out.print(" " + umCliente.totalDeTodasCompras());

        // Estoque do  momento:
        System.out.printf("\nEstoque de arroz %d - feijao - %d", arroz.estoque, feijão.estoque);

        // Compras para outro cliente
        Cliente outroCliente = new Cliente("Jaum");
        outroCliente.realizarUmaCompra(arroz, 30);
        outroCliente.verTodasAsCompras();

        //Novos estoques:
        System.out.printf("\nEstoque de arroz %d - feijao - %d", arroz.estoque, feijão.estoque);
    }
}
