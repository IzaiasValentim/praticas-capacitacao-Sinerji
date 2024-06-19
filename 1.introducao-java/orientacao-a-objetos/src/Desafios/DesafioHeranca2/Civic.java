package Desafios.DesafioHeranca2;

public class Civic extends Carro{
    Civic(){
        this(212);
        delta = 50;
    }
    Civic(int velocidadeMaxima){
        super(velocidadeMaxima);
    }
}
