import java.io.*;
import java.util.Scanner;

public class InputExample {

    public static void main(String args[]) throws IOException {

        Scanner s = new Scanner(System.in);

        System.out.print("insira sua idade em anos: ");
        double age = s.nextDouble();

        System.out.print("Insira sua frequência cardiaca maxima: ");
        double rate = s.nextDouble();

        double fb = (rate - age) * 0.65;
        System.out.println("Sua frequência cardíaca alvo para queima de gordura é" + fb + ".");

        // testar se a entrada e um numero inteiro.
        Scanner input = new Scanner(System.in);
        System.out.print("Por favor digite um inteiro: ");
        while (!input.hasNextInt()) {
            input.nextLine();
            System.out.print("Isso não é um inteiro, porfavor digite um inteiro: ");
        }
        int i = input.nextInt();

        
        System.out.println("Console " + System.console() );
    }
}
