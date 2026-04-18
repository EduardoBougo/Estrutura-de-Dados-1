public class Node {

    private String element;	// Assumimos que os elementos sao strings
    private Node next;

    /// Cria um nodo, com um dado elemento e o endereço do próximo nodo
    public Node(String element, Node next) {
        this.element = element;
        this.next = next;
    }

    /// Retorna o elemento deste nodo
    public String getElement() {
        return element;
    }

    /// Retorna o próximo elemento deste nodo
    public Node getNext() {
        return next;
    }

    /// ** Métodos modificadores: ** ///

    /// Define o elemento deste nodo
    public void setElement(String newElem) {
        element = newElem;
    }

    /// Define o próximo elemento deste nodo
    public void setNext(Node newNext) {
        next = newNext;
    }
}
