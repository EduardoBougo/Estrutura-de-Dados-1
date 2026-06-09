/// Para uma Array de historico Dinâmico e sem tamanho fixo
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== INICIANDO SIMULADOR ROUND ROBIN ===\n");

        CircleFIFO circleFIFO = new CircleFIFO();

        // Lista para manter o histórico dos processos e gerar o relatório no final
        List<Node> historicoProcessos = new ArrayList<>();

        // Cria 10 processos com tempos gerados aleatoriamente entre 1 e 100
        for (int i = 1; i <= 10; i++) {
            Node novoProcesso = new Node(i, null, (int)(Math.random() * 100) + 1);

            circleFIFO.add(novoProcesso);
            historicoProcessos.add(novoProcesso); // Salva uma cópia da referência no histórico
        }

        System.out.println("Estado Inicial da Fila:");
        System.out.println(circleFIFO.toString() + " - Tamanho: " + circleFIFO.size());
        System.out.println("--------------------------------------------------");

        int quantum = 5;
        EscalonadorRoundRobin escalonador = new EscalonadorRoundRobin(circleFIFO, quantum);

        System.out.println("Quantum definido: " + quantum + "ms\n");

        int turno = 1;

        while (circleFIFO.size() > 0) {
            System.out.println("--- TURNO " + turno + " ---");
            escalonador.executarProximoTurno();

            System.out.println("Fila atual: " + circleFIFO.toString());
            System.out.println();
            turno++;

        }


        /// GERAÇÃO DO RELATÓRIO FINAL ///

        System.out.println("=== TODOS OS PROCESSOS FORAM CONCLUÍDOS! ===\n");
        System.out.println("================ RELATÓRIO FINAL ================");

        int tempoTotalDoSistema = 0;

        // Percorre a lista histórico e imprime os dados finais de cada processo
        for (Node p : historicoProcessos) {
            System.out.println("Tarefa ID " + p.getElement() +
                    " | Execuções: " + p.getExecution_count() + " vezes" +
                    " | Tempo total gasto: " + p.getTempoTotal() + "ms");

            // Faz a soma do tempo gasto por todas as tarefas juntas
            tempoTotalDoSistema += p.getTempoTotal();
        }

        // Cálculo do total de turno rodados
        int totalDeTurnos = turno - 1;

        // Calculo do número de alternâncias dos turnos
        // Alternâncias = total de Turnos - 1 (que não é uma troca, mas sim o início)
        int alternanciasContexto = 0;
        if (totalDeTurnos > 0) {
            alternanciasContexto = totalDeTurnos - 1;
        }

        System.out.println("-------------------------------------------------");
        System.out.println("Total de Alternâncias de Contexto: " + alternanciasContexto);
        System.out.println("Tempo Total de Execução do Sistema: " + tempoTotalDoSistema + "ms");
        System.out.println("=================================================");
    }
}