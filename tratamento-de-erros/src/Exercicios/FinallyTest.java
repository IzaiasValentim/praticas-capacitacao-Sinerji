package Exercicios;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class FinallyTest {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // finally será um bloco que quando existente sempre será executado.

        try {
            System.out.println(7 / entrada.nextInt());
            //entrada.close();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro na operação anterior:"+e.getMessage());
        } finally {
            System.out.println("Finalmente...");
            entrada.close();
        }
        System.out.println("Fim!");
    }
}
