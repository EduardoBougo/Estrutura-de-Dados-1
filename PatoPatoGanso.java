
import java.util.Random;

/**
 * @author O Trecho de Código 3.26 apresenta o código Java que simula o jogo
 * do Pato, Pato, Ganso.
 */
//* Simulação do Pato, Pato, Ganso usando uma lista encadeada circular */
public class PatoPatoGanso {

    /**
     * Simulação do Pato, Pato, Ganso usando uma lista encadeada circular
     */
    public static void main(String[] args) {
        CircleList C = new CircleList();
        int N = 3;	// quantidade de iterações do jogo 
        Node it;	// jogador que é o “pegador” 
        Node goose; // ganso 
        Random rand = new Random();
        rand.setSeed(System.currentTimeMillis()); // usa o tempo corrente como semente
        // Os jogadores 
        String[] names = {"Bob", "Jen", "Pam", "Tom", "Ron", "Vic", "Sue", "Joe"};
        for (int i = 0; i < names.length; i++) {
            C.add(new Node(names[i], null));
            C.advance();
        }

        for (int i = 0; i < N; i++) {	// joga Pato, Pato, Ganso N vezes
            System.out.println("Playing Duck, Duck, Goose for " + C.toString());
            it = C.remove();
            System.out.println(it.getElement() + " is it.");
            while (rand.nextBoolean() || rand.nextBoolean()) { // anda ao redor do círculo
                C.advance(); // avança com probabilidade de 3⁄4 
                System.out.println(C.getCursor().getElement() + " is a duck.");
            }
            goose = C.remove();
            System.out.println(goose.getElement() + " is the goose!");

            if (rand.nextBoolean()) {
                System.out.println("The goose won!");
                C.add(goose); // coloca o ganso de volta no seu lugar antigo 
                C.advance(); // agora o cursor é o ganso 
                C.add(it);// o pegador será o mesmo na próxima rodada
            } else {
                System.out.println("The goose lost!");
                C.add(it);// coloca o pegador no lugar do ganso 
                C.advance();// agora o cursor está no pegador
                C.add(goose); // o ganso será o pegador na próxima rodada

            }

        }
        System.out.println("Final circle is " + C.toString());
    }
}