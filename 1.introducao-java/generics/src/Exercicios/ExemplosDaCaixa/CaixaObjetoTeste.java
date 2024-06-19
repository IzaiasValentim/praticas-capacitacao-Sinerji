package Exercicios.ExemplosDaCaixa;

public class CaixaObjetoTeste {
    public static void main(String[] args) {
        //-> Início CaixaSemGEnerics

            CaixaSemGenerics caixa1 = new CaixaSemGenerics();
            // O java automaticamente passa o 2.3 para um Wrapper.
            caixa1.setCoisa(2.3);

            /* É esperado um erro pois em caixa está armazenado um Double.
               Integer coisa = (Integer) caixa1.getCoisa(); */
            Double coisa = (Double) caixa1.getCoisa();
            System.out.println(coisa);

            caixa1.setCoisa("Agora sou uma String");
            String oqueSou = (String) caixa1.getCoisa();
            System.out.println(oqueSou);
        //<-  Fim CaixaSemGenerics

        //-> Início CaixaComGenerics

            // Desta forma nós deixamos explícito que o objeto que estará na caixa é do tipo String.
            CaixaComGenerics<String> caixa2 = new CaixaComGenerics<>();
            caixa2.setCoisa("Eu sou uma String");
            String oqueSou2 = caixa2.getCoisa();
            System.out.println(oqueSou2);

            CaixaComGenerics<Double> numero = new CaixaComGenerics<>();
            numero.setCoisa(1.353534);
            System.out.println("Numero:" + numero.getCoisa());
        //<-  Fim CaixaComGenerics

        //-> Início CaixaInt
                CaixaInt caixa3 =  new CaixaInt();
                caixa3.setCoisa(1010);

                Integer numeroCaixa3 = caixa3.getCoisa();
                System.out.println("Na caixa3: "+numeroCaixa3);
        //-> Fim CaixaInt

        //-> Início CaixaNumero
            CaixaNumero<Double> numeroDouble = new CaixaNumero<>();
            CaixaNumero<Integer> numeroInteiro = new CaixaNumero<>();

            numeroDouble.setCoisa(1.23242526);
            numeroInteiro.setCoisa(111222333);

        System.out.printf("Double:%f - Inteiro:%d",numeroDouble.getCoisa(),numeroInteiro.getCoisa());
        //<- Fim CaixaNumero
    }
}
