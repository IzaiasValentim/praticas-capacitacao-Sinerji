package Desafios;

public class DesafioConstrutor {
    private int dia;
    private int mes;
    private int ano;

    DesafioConstrutor() {
        this(1, 1, 1970);
    }

    DesafioConstrutor(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;

    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String obterDataFormatada() {
        return String.format("%02d/%02d/%04d", dia, mes, ano);
    }
}
