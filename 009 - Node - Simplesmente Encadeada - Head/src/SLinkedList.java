public class SLinkedList {

    protected Node head;	// Nodo cabeça da lista
    protected long size;	// Número de nodos da lista

    /// Construtor default que cria uma lista vazia ///
    public SLinkedList() {
        head = null; // "Cabeça" do vetor
        size = 0; // Quantidade de Nodes
    }
    //...os metodods de pesquisa e atualizacao vao aqui...



    public void removeFirst(){
        if (head != null){
            Node temp = head;
            head = head.getNext();
            temp.setNext(null);
            size--;
        }
        else {
            System.out.println("Lista Vazia");
        }
    }

    public void ImprimeLista() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getElement() + "--> ");
            temp = temp.getNext();
        }
        System.out.print("NULL\n\n");
    }

    public void addFirst (Node first) {
        first.setNext(head);
        head = first;
        size++;
    }

    public void addOrdered (Node novo) {
        // Testar se a lista esta cheia - Verificar se o novo Node deve entrar nos maiores scores
        if (size == 10) { // Tamanho Maximo
            Node temp = head;

            for (int i = 0; i < 10; i++) { // Percorrer toda lista de scores
                if (novo.getElement() > temp.getElement()) { // Testa se o Elemento que está tentando ser inserido é menor que o analisado
                    novo.setNext(temp);
                }
                else  {
                    temp = temp.getNext(); // Passa para o proximo na lista para analisar
                }
            }
        }
    }

    public void InsertionSort(){
        /*
                // Caso o vetor esteja cheio - Verificar se o novoRegistro deve entrar nos maiores escores
        if (numEntries == maxEntries) { // O vetor está cheio
            if (novoRegistro.getScore() <= entries[numEntries - 1].getScore()) {
                return; // nesse caso, a nova entrada, novoRegistro, nao eh um dos maiores escores
            }
        }
        else { // O vetor não está cheio
            numEntries++; //  Incrementa o número de entradas
        }

        int i = numEntries - 1;

        for (; (i >= 1) && (novoRegistro.getScore() > entries[i - 1].getScore()); i--) {
            entries[i] = entries[i - 1];	// Desloca o score da possição (i), uma posição para direita
        }

        entries[i] = novoRegistro;	// Acrescenta o novo score no vetor
         */



        /* for (int i = 1; i < numEntries; i++){
            GameEntry atual = entries[i];

            int j = i - 1;

            while ((j >= 0) && (entries[j].getScore() < atual.getScore())) {
                entries[j + 1] = entries[j];
                j--;
            }
            entries[j+1] = atual;
        }
         */
    }
}
