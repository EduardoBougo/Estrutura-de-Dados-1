/// Nodo de uma lista duplamente encadeada de Contatos ///
public class Node {

    protected String element; // String armazenada pelo nodo
    protected Node next, prev; // Ponteiros para o nodo seguinte e o anterior

    /// Construtor que cria um nodo com os campos fornecidos ///

    public Node(String element, Node prev, Node next) {
        this.element = element;
        this.prev = prev;
        this.next = next;
    }

    /// Retorna o elemento deste nodo ///
    public String getElement() {
        return element;
    }

    /// Retorna o nodo anterior a este ///
    public Node getPrev() {
        return prev;
    }

    /// Retorna o nodo seguinte a este ///
    public Node getNext() {
        return next;
    }

    /// Atribui o elemento deste nodo ///
    public void setElement(String newElem) {
        element = newElem;
    }

    /// Atribui o nodo anterior deste nodo ///
    public void setPrev(Node newPrev) {
        prev = newPrev;
    }

    /// Atribui o nodo seguinte a este nodo ///
    public void setNext(Node newNext) {
        next = newNext;
    }
}
