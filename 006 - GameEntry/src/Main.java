import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /// Dados experimentais de jogadores ///

        Scores scores = new Scores();

        GameEntry j1 ("Mike", 1105);
        GameEntry j2 ("Rob", 750);
        GameEntry j3 ("Jill", 740);
        GameEntry j4 ("Paul", 720);
        GameEntry j5 ("Anna", 660);
        GameEntry j6 ("Rose", 590);
        GameEntry j7 ("Jack", 510);

        scores(j1);
    }

    /// Algoritimo de Inserção Ordenada ///
    public static void insertionSort(int [] vetor){
        int n = vetor.length;

        for (int i = 1; i < n; i++){
            int var = vetor[i];

            int j = i - 1;

            while ((j >= 0) && (vetor[j] > var)){
                vetor[j+1] = vetor[j];
                j--;
            }
            vetor[j+1] = var;
        }
    }

}
