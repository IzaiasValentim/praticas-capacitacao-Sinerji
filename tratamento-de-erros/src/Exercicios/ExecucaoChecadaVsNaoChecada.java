package Exercicios;

public class ExecucaoChecadaVsNaoChecada {
    public static void main(String[] args) {
        // Aula sobre exceções checadas vs não checadas.

        try {
            /* Apesar dentro de um bloco try-catch, geraErro1(); não comunica explicitamente
               que gera exceção.*/
            geraErro1();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        try {
            // Ao chamar geraErro2(); logo é informado que é informado que lançará exceção.
            geraErro2();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Fim!");
    }

    // Exceção não checada ou não verificada
    static void geraErro1() {
        throw new RuntimeException("Ocorreu um erro!");
    }

    // Exceção checada ou verificada - É explicito que este método irá gerar uma exceção.
    static void geraErro2() throws Exception {
        throw new RuntimeException("Ocorreu outro erro :c");
    }
}
