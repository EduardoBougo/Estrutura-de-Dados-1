import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /// Dados experimentais de jogadores ///

        Scores scores = new Scores();

        GameEntry j1 = new GameEntry ("Mike", 1105);
        GameEntry j2 = new GameEntry ("Rob", 750);
        GameEntry j3 = new GameEntry ("Jill", 740);
        GameEntry j4 = new GameEntry ("Paul", 720);
        GameEntry j5 = new GameEntry ("Anna", 660);
        GameEntry j6 = new GameEntry ("Rose", 590);
        GameEntry j7 = new GameEntry ("Jack", 510);

        scores.add(j7);
        scores.add(j6);
        scores.add(j5);
        scores.add(j4);
        scores.add(j3);
        scores.add(j2);
        scores.add(j1);

        scores.insertionSort();

        System.out.println(scores);

    }



}
