public class Main {
    public static void main(String[] args) {
        SLinkedList score = new SLinkedList();

        Node v10 = new Node(1000, null);
        Node v9 = new Node(900, null);
        Node v8 = new Node(800, null);
        Node v7 = new Node(700, null);
        Node v6 = new Node(600, null);
        Node v5 = new Node(500, null);
        Node v4 = new Node(400, null);
        Node v3 = new Node(300, null);
        Node v2 = new Node(200, null);
        Node v1 = new Node(100, null);


        score.addFirst(v1);
        score.addFirst(v2);
        score.addFirst(v3);
        score.addFirst(v4);
        score.addFirst(v5);
        score.addFirst(v6);
        score.addFirst(v7);
        score.addFirst(v8);
        score.addFirst(v9);
        score.addFirst(v10);

        score.ImprimeLista();

        // score.ImprimeLista();
    }
}

