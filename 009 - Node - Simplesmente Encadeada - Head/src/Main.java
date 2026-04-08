public class Main {
    public static void main(String[] args) {
        SLinkedList list = new SLinkedList();

        Node v1 = new Node("v1", null);
        Node v2 = new Node("v2", null);
        Node v3 = new Node("v3", null);

        list.addFirst(v1);
        list.addFirst(v2);
        list.addFirst(v3);

        list.ImprimeLista();
    }

}

