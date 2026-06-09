/// Lista encadeada circular com nodos do tipo Node que armazenam int ///
public class CircleFIFO {

    protected Node cursor; // O cursor corrente
    protected Node tail; // Node sentinela apontando para o Last_In
    protected int size;	// A quantidade de nodos da lista

    /// Construtor que cria uma lista vazia ///
    public CircleFIFO() {
        cursor = null;
        tail = null;
        size = 0;
    }

    /// Retorna o tamanho ///
    public int size() {
        return size;
    }

    /// Retorna o cursor ///
    public Node getCursor() {
        return cursor;
    }

    ///  Retorna o Sentinela Tail ///
    public Node getTail() { return tail; }

    /// Move o cursor adiante ///
    public void advance() {
        cursor = cursor.getNext();
        tail = tail.getNext();
    }

    /// Acrescenta um nodo no final da lista - Depois do tail e antes do cursor ///
    public void add(Node newNode) {
        if (cursor == null) {	// a lista está vazia 
            newNode.setNext(newNode);
            cursor = newNode;
            tail = newNode;
        } else {
            newNode.setNext(cursor); // New node aponta para o cursor
            tail.setNext(newNode); // Tail aponta para o new node
            tail = newNode; // Tail passa a apontar para new node
        }
        size++;
    }

    /// Remove o nodo que o cursor aponta ///
    public Node remove() {
        Node oldNode = cursor.getNext(); // o nodo sendo removido 
        if (oldNode == cursor) {
            cursor = null; // a lista se torna vazia
            tail = null;
        } else {
            cursor.setNext(oldNode.getNext()); // desconecta o nodo antigo
            oldNode.setNext(null);
        }
        size--;
        return oldNode;
    }

    /// Conta a quantidade de elementos numa lista circular ///
    public int countNodes() {
        int count = 0;

        // Lista vazia
        if (cursor == null) {
            return 0;
        }

        Node temp = cursor.getNext();

        while (temp != cursor) {
            temp = temp.getNext();
            count++;
        }

        count++; // Adiciona 1 para corrigir a diferença presente no while

        return count;
    }



    /// Retorna uma representação string da lista, iniciando pelo cursor ///
    public String toString() {
        if (cursor == null) return "[ ]";

        Node temp = cursor;
        String s = "[";

        do {
            s += "(" + temp.getElement() + " - " + temp.getTimeLeft() + " - " + temp.getExecution_count() + ")";
            temp = temp.getNext(); // O temporário avança
            if (temp != cursor) s += ", ";
        } while (temp != cursor);

        return s + "]";
}
