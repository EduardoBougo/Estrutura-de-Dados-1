import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int [] primos = {2, 3, 5, 7, 11, 13, 17, 19, 23};
        double [] a = new double[10];

        for (int i = 0; i < a.length; i++) {
            a[i] = Math.random();
        }

        Arranjo.printArray(a);

        System.out.println("=================================");

        Arranjo.printArray(primos);

        Arranjo.printMaxAndMin(primos);

        System.out.println("=================================");

        Arranjo.printReverseArray(primos);
    }
}


