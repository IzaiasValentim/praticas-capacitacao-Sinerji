package Desafios.DesafioHeranca2;

public class CarroTeste {
    public static void main(String[] args) {
        Civic civic = new Civic();
        Ferrari ferrari = new Ferrari();
        System.out.println("Civic:");
        civic.acelerar();
        civic.acelerar();
        System.out.println(civic);
        civic.frear();
        System.out.println(civic);
        System.out.println("\nFerrari:");
        ferrari.acelerar();
        ferrari.acelerar();
        ferrari.acelerar();
        ferrari.frear();
        System.out.println(ferrari);
    }
}
