package Desafios;

public class Main {
    public static void main(String[] args) {
        // Este arquivo Main é para a visualização da implementação dos desafios.

        // - Início DesafioClasseData
        DesafioClasseData dataUm = new DesafioClasseData();

        dataUm.dia = 6;
        dataUm.mes = 6;
        dataUm.ano = 2024;
        System.out.printf("DesafioClasseData - %d/%d/%d\n", dataUm.dia, dataUm.mes, dataUm.ano);
        // - Fim DesafioClasseData

        // - Início DesafioDataFormatada
        DesafioDataFormatada dataDois = new DesafioDataFormatada();

        dataDois.dia = 7;
        dataDois.mes = 6;
        dataDois.ano = 2024;
        System.out.println("DesafioDataFormatada - "+dataDois.obterDataFormatada());
        // - Fim DesafioDataFormatada

        // - Inicio DesafioConstrutor
        DesafioConstrutor dataDesafio = new DesafioConstrutor();
        System.out.println("DesafioConstrutor - data padrão: "+dataDesafio.obterDataFormatada());

        DesafioConstrutor outraData = new DesafioConstrutor(7,6,2024);
        System.out.println("DesafioConstrutor - data personalizada: "+outraData.obterDataFormatada());
        // - Fim DesafioConstrutor

        // -> Inicio DesafioDoProduto
        DesafioDoProduto produto = new DesafioDoProduto("Água",7.00);

        System.out.println("Preço sem desconto: "+produto.preco);
        System.out.printf("Preço com desconto padrão: %.2f\n", produto.precoComDesconto());
        DesafioDoProduto.desconto = 0.30;
        System.out.printf("Preco com desconto personalizado: %.2f\n", produto.precoComDesconto());
        // -> Fim DesafioDoProduto
    }
}
