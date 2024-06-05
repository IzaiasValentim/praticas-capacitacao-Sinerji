package Desafios;

public class ConversaoDeTemperatura {
    public static void main(String[] args) {
        // Implementar a conversão de temperatura de F -> C
        
        final double temperaturaF = 86;
        final  double div = (double)5/9;
        double temperaturaEmCelsius = (temperaturaF - 32) * div;

        System.out.println(temperaturaF+"F em Celcius é: "+temperaturaEmCelsius);
    }
}
