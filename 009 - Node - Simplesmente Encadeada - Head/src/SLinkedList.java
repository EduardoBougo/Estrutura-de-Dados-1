public class SLinkedList {

    protected Node head;	// Nodo cabeça da lista
    protected long size;	// Número de nodos da lista

    /// Construtor default que cria uma lista vazia ///
    public SLinkedList() {
        head = null; // "Cabeça" do vetor
        size = 0; // Quantidade de Nodes
    }
    //...os metodods de pesquisa e atualizacao vao aqui...

    public void addFirst (Node first) {
        first.setNext(head);
        head = first;
        size++;
    }


    public void ImprimeLista() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getElement() + "--> ");
            temp = temp.getNext();
        }
    }
}
