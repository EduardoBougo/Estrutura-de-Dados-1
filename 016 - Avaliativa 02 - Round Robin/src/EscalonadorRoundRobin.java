public class EscalonadorRoundRobin {

    /// Atributos (Estado/memória do Escalonador)
    private CircleFIFO filaDeProcessos;
    private int quantum;

    /// Construtor
    public EscalonadorRoundRobin(CircleFIFO filaDeProcessos, int quantum) {
        this.filaDeProcessos = filaDeProcessos;
        this.quantum = quantum;
    }


    public void executarProximoTurno() {
        // Fila vazia
        if (filaDeProcessos.size() == 0) {
            System.out.println("Nenhum processo na fila para ser executado.");
            return;
        }

        // Identificação do processo Atual
        Node processoAtual = filaDeProcessos.getCursor();
        System.out.println("\n>>> Executando Processo: " + processoAtual.getElement());

        // Execução da tarefa e consumo do tempo
        // Métodologia (Tell, Don't Ask) Evita ficar passando parâmetros, Funcionamento por baixo dos panos
        processoAtual.registrarExecucao();
        processoAtual.consumirTempo(this.quantum);

        // Fim do processo ou não
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