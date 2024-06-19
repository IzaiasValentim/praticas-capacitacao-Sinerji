package Desafios.DesafioModificadoresDeAcesso;

public class Civic extends Carro{
    public Civic(){
        this(212);
        delta = 50;
    }
    public Civic(int velocidadeMaxima){
        super(velocidadeMaxima);
    }
}
