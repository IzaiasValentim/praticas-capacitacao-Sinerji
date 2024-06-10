package Exercicios.Carro;

public class Carro {
    Motor motor = new Motor();

    void acelerar(){
        if(!motor.ligado){
            System.out.println("Ligue o carro para acelerar");
            return;
        }
        motor.fatorInjecao += 0.4;
    }

    void frear(){
        motor.fatorInjecao -= 0.4;
    }
    void ligar(){
        motor.ligado = true;
    }
    void desligar(){
        motor.ligado = false;
    }

    void estaLigado(){
        System.out.printf("O carro está ligado: %s\n",motor.ligado);
    }
}
