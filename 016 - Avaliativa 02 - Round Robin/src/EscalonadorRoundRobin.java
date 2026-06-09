public class EscalonadorRoundRobin {

    /// Atributos (Estado/memória do Escalonador)
    private CircleFIFO filaDeProcessos;
    private int quantum;

    /// Construtor
    public EscalonadorRoundRobin(CircleFIFO filaDeProcessos, int quantum) {
        this.filaDeProcessos = filaDeProcessos;
        this.quantum = quantum;
    }

    // Função Principal do Algoritmo
    public void executarProximoTurno() {
        // 1. Validação de segurança
        if (filaDeProcessos.size() == 0) {
            System.out.println("Nenhum processo na fila para ser executado.");
            return;
        }

        // 2. Identificação do processo da vez
        Node processoAtual = filaDeProcessos.getCursor();
        System.out.println("\n>>> Executando Processo: " + processoAtual.getElement());

        // 3. Aplicação das regras de negócio (Tell, Don't Ask)
        processoAtual.registrarExecucao();
        processoAtual.consumirTempo(this.quantum);

        // 4. Tomada de decisão após o uso da CPU
        if (processoAtual.getTimeLeft() == 0) {
            System.out.println("Processo " + processoAtual.getElement() + " CONCLUÍDO com sucesso!");

            // O processo terminou, então o retiramos da fila
            filaDeProcessos.removerAtual();
        } else {
            System.out.println("Processo não terminou. Tempo restante: " + processoAtual.getTimeLeft() + "ms.");

            // O processo não terminou, então movemos o cursor para passar a vez
            filaDeProcessos.advance();
        }
    }
}