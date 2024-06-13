package Exercicios.ExemplosDaCaixa;
// Aqui o tipo genêrico para CaixaNumero está definido como qualquer tipo que herde de Number.
// Isto também é passado para CaixaComGenerics, de quem esta classe herda.
public class CaixaNumero<N extends Number> extends CaixaComGenerics<N> {

}
