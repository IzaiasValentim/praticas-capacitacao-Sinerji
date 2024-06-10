package Desafios.DesafioHeranca2;

public class Carro {
    int velocidadeAtual;
    final int VELOCIDADE_MAXIMA;
    int delta = 5;

    Carro(int velocidadeMaxima) {
        this.VELOCIDADE_MAXIMA = velocidadeMaxima;
    }

    void acelerar() {
        if (velocidadeAtual + delta >= VELOCIDADE_MAXIMA) {
            velocidadeAtual = VELOCIDADE_MAXIMA;
            System.out.println("Carro acelerou ao limite "+velocidadeAtual+"km/h");
        } else {
            System.out.println("Carro acelerou "+delta+"km/h");
            velocidadeAtual += delta;
        }
    }

    void frear() {
        if (velocidadeAtual >= delta) {
            velocidadeAtual -= delta;
            System.out.println("freiou "+delta+"km/h");
        } else {
            velocidadeAtual = 0;
        }
    }

    @Override
    public String toString() {
        return "Velocidade atual :" + velocidadeAtual + "km/h";
    }
}
