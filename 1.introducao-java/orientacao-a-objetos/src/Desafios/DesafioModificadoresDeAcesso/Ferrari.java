package Desafios.DesafioModificadoresDeAcesso;

public class Ferrari extends Carro {

    public Ferrari() {
        this(315);
    }

    public Ferrari(int velocidadeMaxima) {
        super(velocidadeMaxima);
        delta = 200;
    }
}
