package Desafios.DesafioHeranca;

public class Ferrari extends Carro{

    @Override
    void acelerar(){
        velocidadeAtual +=15;
        System.out.println("acelerou 15km/h");
    }
}
