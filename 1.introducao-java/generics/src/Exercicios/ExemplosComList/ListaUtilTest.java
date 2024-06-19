package Exercicios.ExemplosComList;

import java.util.Arrays;
import java.util.List;

public class ListaUtilTest {
    public static void main(String[] args) {
        List<String> langs = Arrays.asList("JS", "JAVA", "FLUTTER");
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

        /*  Em ListaUtil.getUltimo() é necessário o cast para String
            pois o retorno é um genérico de Object. */

        String texto = (String) ListaUtil.getUltimo(langs);
        Integer numero = (Integer) ListaUtil.getUltimo(nums);

        System.out.println("A última linguagem:" + texto);
        System.out.println("O último número:" + numero);

         /*  Em ListaUtil.getPenultimo() não é necessário o cast pois o retorno já é explicito
            do valor passado para o método */

        String textoDois = ListaUtil.getPenultimo(langs);
        Integer numeroDois = ListaUtil.getPenultimo(nums);
        System.out.println("A penúltima linguagem:" + textoDois);
        System.out.println("O penúltimo número:" + numeroDois);
    }
}
