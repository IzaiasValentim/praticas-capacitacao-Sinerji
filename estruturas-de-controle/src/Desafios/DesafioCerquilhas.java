package Desafios;

public class DesafioCerquilhas {
    public static void main(String[] args) {
        // Desenvolver a pirâmide de cerquilhas sem o uso de valores númericos no laço for.

        String saida = "#";
        for (String inicio = "#"; !inicio.equals("######"); inicio += "#") {
            System.out.println(saida);
            saida += "#";
        }
    }
}
