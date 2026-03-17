import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Contador c1 =  new Contador();

        System.out.println(c1);
        System.out.println(c1.mostrarValor());
        c1.incrementar();
        c1.incrementar();
        c1.incrementar();
        c1.incrementar();
        System.out.println(c1.mostrarValor());
    }
}