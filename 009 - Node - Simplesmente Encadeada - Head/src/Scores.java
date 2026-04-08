public class Scores {

    public static final int maxEntries = 10; // Quantidade de escores que serao armazenados
    protected int numEntries; // Número real de registros
    protected GameEntry[] entries; // Arranjo de registros (nomes e escores)

    /// Construtor default
    public Scores() {
        entries = new GameEntry[maxEntries];
        numEntries = 0;
    }

    /// Retorna uma representação string da lista de escores

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
    public void add(GameEntry novoRegistro) {
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


    /// Algoritimo de Inserção Ordenada ///
    public void insertionSort(){

        for (int i = 1; i < numEntries; i++){
            GameEntry atual = entries[i];

            int j = i - 1;

            while ((j >= 0) && (entries[j].getScore() < atual.getScore())) {
                entries[j + 1] = entries[j];
                j--;
            }
            entries[j+1] = atual;
        }
    }
}
