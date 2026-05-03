import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Criando lista
        List Agenda = new List();

        // Dados de Teste
        dadosParaTeste(Agenda);

        // Inicializando o sistema
        menu(Agenda);

        // Mensagem de aviso de fim de codigo
        System.out.println("FIM DO CODIGO");
    }

    public static void printMenu() {
        System.out.println(" |--------------------------------------------------|");
        System.out.println(" |                  MENU DE OPÇÕES                  |");
        System.out.println(" |--------------------------------------------------|");
        System.out.println(" | 1  - Cadastrar Novo Contato                      |");
        System.out.println(" | 2  - Ordenar Lista de Contatos                   |");
        System.out.println(" | 3  - Editar Informações de Contato               |");
        System.out.println(" | 4  - Consultar Dados de Contato                  |");
        System.out.println(" | 5  - Remover Contato                             |");
        System.out.println(" | 6  - Mostrar Lista de Contatos                   |");
        System.out.println(" | 0  - Sair                                        |");
        System.out.println(" |--------------------------------------------------|");
        System.out.print(  " Escolha uma Opção: ");
    }

    public static void limparTela() {
        try { // Tenta esse
            if (System.console() == null) {
                for (int i = 0; i < 50; ++i) {
                    System.out.println();
                }
            } else {
                String sistemaOperacional = System.getProperty("os.name");

                if (sistemaOperacional.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            }
        } catch (Exception e) { // ERRO - Executa esse
            for (int i = 0; i < 50; ++i) {
                System.out.println();
            }
        }
    }

    public static void cabecalho(String texto) {
        int tam = texto.length();
        int qtdEspacos = ((50 - tam) / 2);

        limparTela();
        System.out.println(" |--------------------------------------------------|");
        System.out.print(" |");

        for (int i = 0; i < qtdEspacos; i++) {
            System.out.print(" ");
        }

        System.out.printf("%s", texto);

        if ((tam % 2) == 1) {
            qtdEspacos++;
        }

        for (int i = 0; i < qtdEspacos; i++) {
            System.out.print(" ");
        }

        System.out.println("|");
        System.out.println(" |--------------------------------------------------|");
        System.out.print("\n\n");
    }

    public static void menu(List Agenda) {
        Scanner s = new Scanner(System.in);
        int opcao = -1;

        do {
            limparTela();
            printMenu();

            if (s.hasNextInt()) {
                opcao = s.nextInt();
                s.nextLine(); // Limpa o buffer de quebra de linha
            } else {
                s.nextLine();
                continue;
            }

            switch (opcao) {
                case 1:
                    cabecalho("CADASTRAR NOVO CONTATO");
                    cadastrarNovoContato(Agenda, s);
                    enterParaContinuar(s);
                    break;

                case 2:
                    cabecalho("ORDENAR LISTA DE CONTATOS");
                    System.out.println("Ordenar por:");
                    System.out.println("1 - Por Nome");
                    System.out.println("2 - Por Idade");
                    System.out.print("Sua escolha: ");

                    int opcao2 = s.nextInt();
                    s.nextLine();

                    if (opcao2 == 1) {
                        Agenda.insertionSort_Name();
                        System.out.println("Ordenação por Nome concluída!");
                    } else if (opcao2 == 2) {
                        Agenda.insertionSort_Idade();
                        System.out.println("Ordenação por Idade concluída!");
                    } else {
                        System.out.println("Opção inválida!");
                    }

                    enterParaContinuar(s);
                    break;

                case 3:
                    cabecalho("EDITAR INFORMACOES DE CONTATO");
                    System.out.print("Digite o nome do contato: ");
                    String nomeEdicao = s.nextLine();

                    Node atualEdicao = Agenda.consultar(nomeEdicao);

                    if (atualEdicao.getElement() != null) {
                        Contato c = atualEdicao.getElement();
                        System.out.println("Contato encontrado: " + Agenda.exibirInformacao(nomeEdicao));
                        System.out.println("\nDigite os novos dados (ou repita os antigos):");

                        System.out.print("Nome do contato: ");
                        String novoNome = s.nextLine();

                        System.out.print("Idade do contato: ");
                        int novaIdade = s.nextInt();

                        System.out.print("CPF do contato: ");
                        long novoCpf = s.nextLong();

                        System.out.print("Telefone do contato: ");
                        long novoTelefone = s.nextLong();

                        s.nextLine();
                        System.out.print("Email do contato: ");
                        String novoEmail = s.nextLine();

                        c.contatoUpdate(novoNome, novaIdade, novoCpf, novoTelefone, novoEmail);
                        System.out.println("\nContato atualizado com sucesso!");
                    } else {
                        System.out.println("Contato não encontrado na agenda.");
                    }

                    enterParaContinuar(s);
                    break;

                case 4:
                    cabecalho("CONSULTAR DADOS DE CONTATO");
                    System.out.print("Digite o nome do contato a ser buscado: ");
                    String nomeBusca = s.nextLine();

                    Node atualBusca = Agenda.consultar(nomeBusca);

                    if (atualBusca.getElement() != null) {
                        System.out.println("\nDados do contato:");
                        System.out.println(Agenda.exibirInformacao(nomeBusca));
                    } else {
                        System.out.println("Contato não encontrado na agenda.");
                    }

                    enterParaContinuar(s);
                    break;

                case 5:
                    cabecalho("REMOVER CONTATO");
                    System.out.print("Digite o CPF do contato a ser removido (apenas números): ");
                    long cpfBusca = s.nextLong();
                    s.nextLine();

                    Node atualRemocao = Agenda.consultar(cpfBusca);

                    if (atualRemocao.getElement() != null) {
                        Agenda.remove_CPF(cpfBusca);
                        System.out.println("Contato removido com sucesso!");
                    } else {
                        System.out.println("CPF não encontrado na agenda.");
                    }

                    enterParaContinuar(s);
                    break;

                case 6:
                    cabecalho("MOSTRAR LISTA DE CONTATOS");
                    System.out.println("1 - Imprimir do Início ao Fim (Cabeça -> Cauda)");
                    System.out.println("2 - Imprimir do Fim ao Início (Cauda -> Cabeça)");
                    System.out.print("Sua escolha: ");

                    int ordem = s.nextInt();
                    s.nextLine();

                    System.out.println();
                    if (ordem == 1) {
                        System.out.println(Agenda.toString_Header());
                    } else if (ordem == 2) {
                        System.out.println(Agenda.toString_Tail());
                    } else {
                        System.out.println("Opção inválida.");
                    }

                    enterParaContinuar(s);
                    break;
            }
        } while (opcao != 0);

        System.out.println("Encerrando o terminal...");
    }

    public static void cadastrarNovoContato(List Agenda, Scanner s) {
        System.out.print("Nome do contato: ");
        String nome = s.nextLine();

        System.out.print("Idade do contato: ");
        int idade = s.nextInt();

        System.out.print("CPF do contato: ");
        long CPF = s.nextLong();

        System.out.print("Telefone do contato: ");
        long telefone = s.nextLong();

        s.nextLine();
        System.out.print("Email do contato: ");
        String email = s.nextLine();

        Contato contato = new Contato(nome, idade, CPF, telefone, email);
        Node contato_new = new Node(contato, null, null);
        Agenda.add_ordenado(contato_new);

        System.out.println("\nContato cadastrado com sucesso!");
    }

    public static void enterParaContinuar(Scanner s) {
        System.out.print("\n>>> Pressione a tecla Enter para continuar <<<");
        s.nextLine();
    }

    public static void dadosParaTeste(List Agenda) {
        // Contatos
        Contato c_1 = new Contato("Eduardo", 19, 11122233345L, 18981101017L, "eduardobougo@gmail.com");
        Contato c_2 = new Contato("Andrea", 48, 11100022245L, 18997523822L, "andrea@gmail.com");
        Contato c_3 = new Contato("Flavio", 53, 44477788899L, 1836525845L, "flavio@gmail.com");

        // Criando Nodos
        Node contato_1 = new Node(c_1, null, null);
        Node contato_2 = new Node(c_2, null, null);
        Node contato_3 = new Node(c_3, null, null);

        // Adicionando os Contatos a lista
        Agenda.add_ordenado(contato_1);
        Agenda.add_ordenado(contato_2);
        Agenda.add_ordenado(contato_3);
    }
}