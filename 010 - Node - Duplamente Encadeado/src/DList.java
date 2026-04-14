/// Lista duplamente encadeada com nodos do tipo DNode que armazenam strings ///
public class DList {

    protected int size; // quantidade de elementos
    protected DNode header, tail; //apontadores para o inicio e fim da lista

    /// Construtor que cria uma lista vazia ///
    public DList() {
        size = 0;
        header = new DNode(null, null, null); // cria o cabecalho 
        tail = new DNode(null, null, null); //cria o final 
        header.setNext(tail); // faz o cabecalho e o final apontarem um para o outro
        tail.setPrev(header); //
    }

    /// Retorna o número de elementos na lista ///
    public int size() {
        return size;
    }

    /// Informa se a lista está vazia ///
    public boolean isEmpty() {
        return (size == 0);
    }

    /// Retorna o primeiro nodo da lista ///
    public DNode getFirst() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return header.getNext();
    }

    /// Retorna o último nodo da lista ///
    public DNode getLast() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.getPrev();
    }

    /// Retorna o nodo que antecede um dado nodo v. Gera erro se v é o cabecalho ///
    public DNode getPrev(DNode v) throws IllegalArgumentException {
        if (v == header) {
            throw new IllegalArgumentException("Cannot move back past the header of the list");
        }
        return v.getPrev();
    }

    /// Retorna o nodo que segue um dado nodo v. Gera erro se v é o final ///
    public DNode getNext(DNode v) throws IllegalArgumentException {
        if (v == tail) {
            throw new IllegalArgumentException("Cannot move forward past the trailer of the list");
        }
        return v.getNext();
    }

    /// Insere um dado nodo z antes de um dado nodo v. Gera um erro se v é o cabecalho ///
    public void addBefore(DNode reference_Node, DNode new_Node) throws IllegalArgumentException {
        DNode prev_reference = getPrev(reference_Node); // Deve lancar uma IllegalArgumentException
        new_Node.setPrev(prev_reference);
        new_Node.setNext(reference_Node);
        reference_Node.setPrev(new_Node);
        prev_reference.setNext(new_Node);
        size++;
    }

    /// Insere um dado nodo z depois de uma dado nodo v. Gera um erro se v é o final ///
    public void addAfter(DNode reference_Node, DNode new_node) {
        DNode next_reference = getNext(reference_Node); // Deve lançar uma IllegalArgumentException
        new_node.setPrev(reference_Node);
        new_node.setNext(next_reference);
        next_reference.setPrev(new_node);
        reference_Node.setNext(new_node);
        size++;
    }

    /// Insere o nodo fornecido no início da lista ///
    public void addFirst(DNode new_Node) {
        addAfter(header, new_Node);
    }

    /// Insere o nodo fornecido no fim da lista ///
    public void addLast(DNode new_Node) {
        addBefore(tail, new_Node);
    }

    /// Remove um dado nodo v da lista. Gera um erro se v é o cabeçalho ou o final ///
    public void remove(DNode referencia) {
        DNode prev = getPrev(referencia); // Deve lançar uma IllegalArgumentException
        DNode next = getNext(referencia); // Deve lançar uma IllegalArgumentException

        // Desconecta o nodo da lista 
        next.setPrev(prev);
        prev.setNext(next);
        referencia.setPrev(null);
        referencia.setNext(null);
        size--;
    }

    public void remove (String node){
        DNode temp = header;

        while(!(node.equalsIgnoreCase(temp.getElement()))){
            temp = temp.getNext();
        }
        remove(temp);
    }



    /// Indica se o nodo indicado possui um antecessor ///
    public boolean hasPrev(DNode v) {
        return v != header;
    }

    /// Indica se o nodo indicado possui um sucessor ///
    public boolean hasNext(DNode v) {
        return v != tail;
    }

    /// Retorna uma representação string da lista ///
    public String toString() {
        String s = "[";
        DNode v = header.getNext();
        while (v != tail) {
            s += v.getElement();
            v = v.getNext();
            if (v != tail) {
                s += ",";
            }
        }
        s += "]";
        return s;
    }
}