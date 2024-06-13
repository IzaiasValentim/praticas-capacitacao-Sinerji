package Exercicios.ExemplosDaCaixa;
// Aqui é feita a definição: <T>.
// Geralmente é utilizado apenas uma letra maiuscula.

public class CaixaComGenerics<TIPO> {
    private TIPO coisa;

    public TIPO getCoisa() {
        return coisa;
    }

    public void setCoisa(TIPO coisa) {
        this.coisa = coisa;
    }
}
