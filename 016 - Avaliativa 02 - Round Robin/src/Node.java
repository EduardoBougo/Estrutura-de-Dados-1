public class Node {

    private int element;
    private int timeLeft;
    private int execution_count;
    private Node next;
    private int tempoTotal; // Guarda o tempo total necessário (não é alterado)

    /// Cria um nodo, com um dado elemento e o endereço do próximo nodo
    public Node(int element, Node next, int timeLeft) {
        this.element = element;
        this.timeLeft = timeLeft;
        this.next = next;
        execution_count = 0;
        this.tempoTotal = timeLeft; // Salva o tempo original na criação
    }

    /// Retorna o elemento deste nodo
    public int getElement() {
        return element;
    }

    /// Retorna o timeLeft
    public int getTimeLeft() { return timeLeft; }

    /// Retorna o execution_count
    public int getExecution_count() { return execution_count; }

    /// Retorna o próximo elemento deste nodo
    public Node getNext() {
        return next;
    }

    /// Retorna o tempo total original
    public int getTempoTotal() { return tempoTotal; }

    /// ** Métodos modificadores: ** ///

    /// Define o elemento deste nodo
    public void setElement(int newElem) {
        element = newElem;
    }

    /// Define o próximo elemento deste nodo
    public void setNext(Node newNext) {
        next = newNext;
    }

    /// Reduz o tempo restante baseado no quantum que foi executado
    public void consumirTempo(int quantum) {
        this.timeLeft = Math.max(0, this.timeLeft - quantum); // Impede que o timeLeft seja negativo
    }

    /// Adiciona +1 à contagem de vezes que o processo foi para a CPU
    public void registrarExecucao() {
        this.execution_count++;
    }
}
