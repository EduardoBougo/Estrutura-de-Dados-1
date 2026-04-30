/// Lista duplamente encadeada com nodos do tipo Node que armazenam Contatos ///
public class List {

    //Atributos
    protected int size; // Quantidade de elementos
    protected Node header, tail; //Ponteiros sentinelas para o inicio e fim da lista

    // Função Construtor
    public List() {
        size = 0;
        header = new Node(null, null, null); // cria o cabecalho
        tail = new Node(null, null, null); //cria o final
        header.setNext(tail); // faz o cabecalho e o final apontarem um para o outro
        tail.setPrev(header); //
    }

    /// **************************************************************************** ///
    ///                             Funções de Controle                              ///
    /// **************************************************************************** ///

    /// Retorna o número de elementos na lista ///
    public int size() {
        return size;
    }

    /// Informa se a lista está vazia ///
    public boolean isEmpty() {
        return (size == 0);
    }

    /// Retorna o primeiro nodo da lista ///
    public Node getFirst() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return header.getNext();
    }

    /// Retorna o último nodo da lista ///
    public Node getLast() throws IllegalStateException {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return tail.getPrev();
    }

    /// Retorna o nodo que antecede um dado nodo v. Gera erro se v é o cabecalho ///
    public Node getPrev(Node v) throws IllegalArgumentException {
        if (v == header) {
            throw new IllegalArgumentException("Cannot move back past the header of the list");
        }
        return v.getPrev();
    }

    /// Retorna o nodo que segue um dado nodo v. Gera erro se v é o final ///
    public Node getNext(Node v) throws IllegalArgumentException {
        if (v == tail) {
            throw new IllegalArgumentException("Cannot move forward past the trailer of the list");
        }
        return v.getNext();
    }

    /// Consultar as informações pelo Nome ///
    protected Node consultar(String nome) {
        Node cursor = this.getFirst();

        while (cursor != tail && (cursor.getElement().getNome().compareTo(nome) != 0)){
            cursor = cursor.getNext();
        }

        return cursor;
    }

    protected Node consultar(long CPF) {
        Node cursor = this.getFirst();

        while (cursor != tail && (cursor.getElement().getCPF() != CPF)){
            cursor = cursor.getNext();
        }

        return cursor;
    }

    /// **************************************************************************** ///
    ///                             Funções de Adição                                ///
    /// **************************************************************************** ///

    /// Insere o nodo fornecido no início da lista ///
    public void addFirst(Node new_Node) {
        addAfter(header, new_Node);
    }

    /// Insere o nodo fornecido no fim da lista ///
    public void addLast(Node new_Node) {
        addBefore(tail, new_Node);
    }

    /// Insere um dado nodo z antes de um dado nodo v. Gera um erro se v é o cabecalho ///
    public void addBefore(Node reference_Node, Node new_Node) throws IllegalArgumentException {
        Node prev_reference = getPrev(reference_Node); // Deve lancar uma IllegalArgumentException
        new_Node.setPrev(prev_reference);
        new_Node.setNext(reference_Node);
        reference_Node.setPrev(new_Node);
        prev_reference.setNext(new_Node);
        size++;
    }

    /// Insere um dado nodo z depois de uma dado nodo v. Gera um erro se v é o final ///
    public void addAfter(Node reference_Node, Node new_node) {
        Node next_reference = getNext(reference_Node); // Deve lançar uma IllegalArgumentException
        new_node.setPrev(reference_Node);
        new_node.setNext(next_reference);
        next_reference.setPrev(new_node);
        reference_Node.setNext(new_node);
        size++;
    }

    /// Insere o nodo fornecido de forma ordenada por Nome ///
    public void add_ordenado(Node new_Node) {
        // Lista vazia - Já está ordenada
        if (this.size == 0) {
            this.addFirst(new_Node);
            return;
        }

        // Novo Node é o primeiro da lista
        if (new_Node.getElement().getNome().compareTo(this.getFirst().getElement().getNome()) <= 0) {
            this.addFirst(new_Node);
            return;
        }

        Node cursor = this.getFirst();

        while ((cursor.getNext() != tail) && (cursor.getNext().getElement().getNome().compareTo(new_Node.getElement().getNome())) < 0) {
            cursor = cursor.getNext();
        }

        this.addAfter(cursor, new_Node);
    }

    /// **************************************************************************** ///
    ///                             Funções de Ordenação                             ///
    /// **************************************************************************** ///

    /// Ordenar Lista pelo Nome (Crescente)///
    public void insertionSort_Name() {
        // Lista vazia ou 1 Elemento - Já está ordenada
        if (this.size <= 1) {
            return;
        }

        Node cursor = this.getFirst().getNext(); // Começa direto do segundo nodo

        while (cursor != tail) { // Usar tail, pois a lista termina em tail, e não em null

            Node next_Nodo = cursor.getNext(); // Guarda o próximo
            Node scanner = cursor.getPrev(); // Guarda o anterio para comparar

            // Remove o nodo atual para reinserir na posição correta
            this.remove(cursor);

            // Anda para trás enquanto o elemento for maior (ordem crescente)
            while ((scanner != header) && scanner.getElement().getNome().compareTo(cursor.getElement().getNome()) > 0){
                scanner = scanner.getPrev();
            }

            this.addAfter(scanner, cursor);

            cursor = next_Nodo;
        }
    }

    /// Ordenar Lista pela Idade (Crescente)///
    public void insertionSort_Idade() {
        // Lista vazia ou 1 Elemento - Já está ordenada
        if (this.size <= 1) {
            return;
        }

        Node cursor = this.getFirst().getNext(); // Começa direto do segundo nodo

        while (cursor != tail) { // Usar tail, pois a lista termina em tail, e não em null

            Node next_Nodo = cursor.getNext(); // Guarda o próximo
            Node scanner = cursor.getPrev(); // Guarda o anterio para comparar

            // Remove o nodo atual para reinserir na posição correta
            this.remove(cursor);

            // Anda para trás enquanto o elemento for maior (ordem crescente)
            while ((scanner != header) && scanner.getElement().getIdade() > cursor.getElement().getIdade()){
                scanner = scanner.getPrev();
            }

            this.addAfter(scanner, cursor);

            cursor = next_Nodo;
        }
    }




    /// **************************************************************************** ///
    ///                            Funções de Remoção                                ///
    /// **************************************************************************** ///

    /// Remove um dado nodo v da lista. Gera um erro se v é o cabeçalho ou o final ///
    public void remove(Node referencia) {
        Node prev = getPrev(referencia); // Deve lançar uma IllegalArgumentException
        Node next = getNext(referencia); // Deve lançar uma IllegalArgumentException

        // Desconecta o nodo da lista 
        next.setPrev(prev);
        prev.setNext(next);
        referencia.setPrev(null);
        referencia.setNext(null);
        size--;
    }

    /// Excluir pelo CPF ///
    public void remove_CPF (long CPF){
        Node contato = consultar(CPF);

        remove(contato);
    }


    /// **************************************************************************** ///
    ///                             Funções variadas                                 ///
    /// **************************************************************************** ///

    /// Indica se o nodo indicado possui um antecessor ///
    public boolean hasPrev(Node v) {
        return v != header;
    }

    /// Indica se o nodo indicado possui um sucessor ///
    public boolean hasNext(Node v) {
        return v != tail;
    }

    /// Concatena duas listas duplamente ligadas uma após a outra ///

    public void linkLists(List list_1,  List list_2) {

        // Faz o cursor apontar para o primeiro elemento da primeira lista
        Node cursor = list_1.getFirst();

        // Percorre a lista_1 copiando os valores e adicionando-os em novos Nodes na nova lista
        while(cursor != list_1.tail) {
            this.addLast(new Node (cursor.getElement(), null, null));
            cursor = cursor.getNext();
        }

        // Faz o cursor apontar para o primeiro elemento da primeira lista
        cursor = list_2.getFirst();

        // Percorre a lista_2 copiando os valores e adicionando-os em novos Nodes na nova lista
        while(cursor != list_2.tail) {
            this.addLast(new Node (cursor.getElement(), null, null));
            cursor = cursor.getNext();
        }
    }

    /// **************************************************************************** ///
    ///                               Imprimir Lista                                 ///
    /// **************************************************************************** ///

    /// Retorna uma representação string da lista (Cabeça -> Cauda) ///
    public String toString_Header() {
        String list = "[";
        Node v = header.getNext();
        while (v != tail) {
            // Informações do Contato
            list += "[";
            list += v.getElement().getNome();
            list += ", ";
            list += v.getElement().getIdade();
            list += ", ";
            list += v.getElement().getCPF();
            list += ", ";
            list += v.getElement().getTelefone();
            list += ", ";
            list += v.getElement().getEmail();
            list += "]";

            v = v.getNext();
            if (v != tail) {
                list += ", ";
            }
        }
        list += "]";
        return list;
    }

    /// Retorna uma representação string da lista (Cauda -> Cabeça) ///
    public String toString_Tail() {
        String list = "[";
        Node v = tail.getPrev();
        while (v != header) {
            // Informações do Contato
            list += "[";
            list += v.getElement().getNome();
            list += ", ";
            list += v.getElement().getIdade();
            list += ", ";
            list += v.getElement().getCPF();
            list += ", ";
            list += v.getElement().getTelefone();
            list += ", ";
            list += v.getElement().getEmail();
            list += "]";

            v = v.getPrev();
            if (v != header) {
                list += ", ";
            }
        }
        list += "]";
        return list;
    }

    public String exibirInformacao(String nome) {
        Node contato = consultar(nome);

        String name = contato.getElement().getNome();
        int idade = contato.getElement().getIdade();
        long cpf = contato.getElement().getCPF();
        long telefone = contato.getElement().getTelefone();
        String email = contato.getElement().getEmail();

        String list = String.format("[%s, %d, %d, %d, %s]",name,idade,cpf,telefone,email );

        return list;
    }
}