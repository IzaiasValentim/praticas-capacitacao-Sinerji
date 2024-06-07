package Desafios.DesafioDoModulo;

public class Pessoa {
    String nome;
    double peso;
    Pessoa(){
    }
    Pessoa(String nome, double peso){
       this.nome = nome;
       this.peso = peso;
    }
    void comer(Comida comida){
        peso += comida.peso;
    }
}
