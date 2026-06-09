public class Main {
    public static void main(String[] args) {

        ///  Criação e preenchimento da FILA
        CircleFIFO  circleFIFO = new CircleFIFO();

        for (int i = 1; i <= 10; i++) {
            circleFIFO.add(new Node(i, null, (int)(Math.random() * 100)));
        }



    }
}