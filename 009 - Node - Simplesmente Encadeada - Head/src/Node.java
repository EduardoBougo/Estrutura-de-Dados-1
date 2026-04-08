public class Node {

    private int element;	// Assumimos que os elementos sao strings
    private Node next;

    /// Cria um nodo, com um dado elemento e o endereço do próximo nodo
    public Node(int s, Node n) {
        element = s;
        next = n;
    }

    /// Retorna o elemento deste nodo
    public int getElement() {
        return element;
    }

    /// Retorna o próximo elemento deste nodo
    public Node getNext() {
        return next;
    }

    /// ** Métodos modificadores: ** ///

    /// Define o elemento deste nodo
    public void setElement(int newElem) {
        element = newElem;
    }

    /// Define o próximo elemento deste nodo
    public void setNext(Node newNext) {
        next = newNext;
    }
}
