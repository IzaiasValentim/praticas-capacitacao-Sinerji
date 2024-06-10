package Desafios.DesafioHeranca;

public class Carro {
    int velocidadeAtual;

    void acelerar() {
        velocidadeAtual += 5;
        System.out.println("acelerou 5km/h");
    }

    void frear() {
        if (velocidadeAtual >= 5) {
            velocidadeAtual -= 5;
            System.out.println("freiou 5km/h");
        } else {
            velocidadeAtual = 0;
        }
    }

    @Override
    public String toString() {
        return "Velocidade atual :"+velocidadeAtual+"km/h";
    }
}
