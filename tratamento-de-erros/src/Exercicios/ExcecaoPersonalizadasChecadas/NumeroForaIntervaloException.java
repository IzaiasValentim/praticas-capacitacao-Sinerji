package Exercicios.ExcecaoPersonalizadasChecadas;

//A anotação impede a serialização desta classe. Não é obrigatório, foi apenas por opção do instrutor.
@SuppressWarnings("serial")
public class NumeroForaIntervaloException extends Exception {
    private String nomeDoAtributo;

    public NumeroForaIntervaloException(String nomeDoAtributo) {
        this.nomeDoAtributo = nomeDoAtributo;
    }

    public String getNomeDoAtributo() {
        return nomeDoAtributo;
    }

    public void setNomeDoAtributo(String nomeDoAtributo) {
        this.nomeDoAtributo = nomeDoAtributo;
    }

    public String getMessage() {
        return String.format("O atributo %s está fora do intervalo.", nomeDoAtributo);
    }
}
