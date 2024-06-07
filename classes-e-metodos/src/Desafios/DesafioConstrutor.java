package Desafios;

public class DesafioConstrutor {
    int dia;
    int mes;
    int ano;

    DesafioConstrutor(){
        dia = 1;
        mes = 1;
        ano = 1970;
    }

    DesafioConstrutor(int d, int m, int a){
        dia = d;
        mes = m;
        ano = a;
    }
    public String obterDataFormatada(){
        return dia+"/"+mes+"/"+ano;
    }
}
