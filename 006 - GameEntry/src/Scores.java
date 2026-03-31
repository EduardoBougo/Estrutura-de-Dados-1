public class Scores {

    public static final int maxEntries = 10; // quantidade de escores que serao armazenados 
    protected int numEntries; // numero real de registros
    protected GameEntry[] entries; // arranjo de registros (nomes e escores)

    /**
     * Construtor default
     */
    public Scores() {
        entries = new GameEntry[maxEntries];
        numEntries = 0;

    }

    /**
     * Retorna uma representação string da lista de escores
     */
    public String toString() {
        String s = "[";
        for (int i = 0; i < numEntries; i++) {
            if (i > 0) {
                s += ", "; // separa os registros por virgulas
            }
            s += entries[i];
        }
        return s + "]";
    }
    // ... os metodos para atualizar o conjunto de escores vao aqui...

    /**
     * trecho de codigo 3.3 Tenta inserir um novo escore na coleção (se ele
     * for grande o suficiente)
     */
    public void add(GameEntry e) {
        int newScore = e.getScore();
        // o novo registro e corresponde mesmo a um dos maiores escores? 
        if (numEntries == maxEntries) { // o arranjo está cheio
            if (newScore <= entries[numEntries - 1].getScore()) {
                return; // nesse caso, a nova entrada, e, nao eh um dos maiores escores
            }
        } else {
            // o arranjo nao esta cheio
            numEntries++; // localiza o lugar onde o novo registro e (com escore grande) deve ficar 
        }
        int i = numEntries - 1;
        for (; (i >= 1) && (newScore > entries[i - 1].getScore()); i--) {
            entries[i] = entries[i - 1];	// move a entrada i uma posição para direita 
        }
        entries[i] = e;	// acrescenta o novo escore as entradas
    }

    /**
     * trecho de codigo 3.4 Remove e retorna o escore armazenado no indice i
     */
    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if ((i < 0) || (i >= numEntries)) {
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        }
        GameEntry temp = entries[i];// armazena temporariamente o objeto a ser removido
        for (int j = i; j < numEntries - 1; j++) {// conta a partir de i 
            entries[j] = entries[j + 1];// move uma célula para esquerda 
        }
        entries[numEntries - 1] = null; // anula o ultimo escore
        numEntries--;
        return temp; // retorna o objeto removido
    }
}
