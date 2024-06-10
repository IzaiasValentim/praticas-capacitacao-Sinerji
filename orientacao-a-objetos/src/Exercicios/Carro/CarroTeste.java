package Exercicios.Carro;

public class CarroTeste {
    public static void main(String[] args) {
        // Relacionamento 1 para 1. Um carro possuiu um motor.
        Carro c1 = new Carro();

        c1.estaLigado();
        c1.acelerar();
        c1.ligar();
        c1.estaLigado();
        System.out.println("RPM: " + c1.motor.giros());
        c1.acelerar();
        c1.acelerar();

        System.out.println("RPM: " + c1.motor.giros());
    }
}
