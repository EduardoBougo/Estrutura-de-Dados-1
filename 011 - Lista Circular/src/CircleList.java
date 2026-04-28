/// Lista encadeada circular com nodos do tipo Node que armazenam strings ///
public class CircleList {

    protected Node cursor;	// o cursor corrente 
    protected int size;	// a quantidade de nodos da lista

    /// Construtor que cria uma lista vazia ///
    public CircleList() {
        cursor = null;
        size = 0;
    }

    /// Retorna o tamanho corrente ///
    public int size() {
        return size;
    }

    /// Retorna o cursor ///
    public Node getCursor() {
        return cursor;
    }

    /// Move o cursor adiante ///
    public void advance() {
        cursor = cursor.getNext();
    }

    /// Acrescenta um nodo depois do cursor ///
    public void add(Node newNode) {
        if (cursor == null) {	// a lista está vazia 
            newNode.setNext(newNode);
            cursor = newNode;
        } else {
            newNode.setNext(cursor.getNext());
            cursor.setNext(newNode);
        }
        size++;
    }

    /// Remove o nodo que segue o cursor ///
    public Node remove() {
        Node oldNode = cursor.getNext(); // o nodo sendo removido 
        if (oldNode == cursor) {
            cursor = null; // a lista se torna vazia 
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
        if (cursor == null) {
            return "[ ]";
        }
        String s = "[..." + cursor.getElement();
        Node oldCursor = cursor;
        for (advance(); oldCursor != cursor; advance()) {
            s += ", " + cursor.getElement();
        }
        return s + "...]";
    }

}
