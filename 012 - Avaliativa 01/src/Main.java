void main() {

    // Criando lista
    List Agenda = new List();

    //Dados de Teste
    dadosParaTeste(Agenda);

    menu(Agenda);

}

public void printMenu() {
    System.out.println(" |--------------------------------------------------|");
    System.out.println(" |                  MENU DE OPÇÕES                  |");
    System.out.println(" |--------------------------------------------------|");
    System.out.println(" | 1  - Cadastrar Novo Contato                      |");
    System.out.println(" | 2  - Ordenar Lista de Contatos                   |");
    System.out.println(" | 3  - Editar Informações de Contato               |");
    System.out.println(" | 4  - Consultar Dados de Contato                  |");
    System.out.println(" | 5  - Remover Contato                             |");
    System.out.println(" | 6  - Mostrar Lista de Contatos                   |");
    System.out.println(" | 0 - Sair                                         |");
    System.out.println(" |--------------------------------------------------|");
    System.out.print(  " Escolha uma Opção: ");
}

public static void limparTela() {
    try {
        // Verifica se está rodando dentro de uma IDE (Eclipse, NetBeans, IntelliJ)
        if (System.console() == null) {
            // O ambiente é uma IDE. A única forma 100% segura sem imprimir
            // caracteres estranhos (erros de ANSI) é "empurrar" a tela.
            for (int i = 0; i < 50; ++i) {
                System.out.println();
            }
        }
        else {
            // O ambiente é um terminal real (Prompt de Comando, PowerShell, Bash)
            String sistemaOperacional = System.getProperty("os.name");

            if (sistemaOperacional.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }
    } catch (Exception e) {
        // Fallback: Se der qualquer erro bizarro no processo, garantimos a limpeza
        // imprimindo as linhas em branco para o professor não ver o erro estourar.
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }
}

public void cabecalho(String texto)
{ // Imprime um cabeçalho personalizado
    int tam = texto.length();
    int qtdEspacos = ((50 - tam) / 2); // Conta quantos espaços terá antes e depois do texto -- Centralizando


    limparTela();
    System.out.println(" |--------------------------------------------------|");
    System.out.print(" |");

    for (int i = 0; i < qtdEspacos; i++)
    { // Imprime os espaços antes do texto
        System.out.print(" ");
    }

    System.out.printf("%s", texto); // Imprime o texto

    if ((tam % 2) == 1)
    { // Caso a qtd de espaços seja impar -- Soma 1
        qtdEspacos++;
    }

    for (int i = 0; i < qtdEspacos; i++)
    { // Imprime os espaços depois do texto
        System.out.printf(" ");
    }

    System.out.println("|");
    System.out.println(" |--------------------------------------------------|");
    System.out.print("\n\n");
}

public void menu(List Agenda) {
    limparTela();
    printMenu();

    Scanner s =  new Scanner(System.in);

    int opcao = s.nextInt();

    while (opcao != 0) {
        switch (opcao) {
            case 1:
                cabecalho("CADASTRAR NOVO CONTATO");
                cadastrarNovoContato(Agenda);
                enterParaContinuar();

                break;

            case 2:
                cabecalho("ORDENAR LISTA DE CONTATOS");
                System.out.println("Ordenar por:");
                System.out.println("1 - Por Nome");
                System.out.println("2 - Por idade");

                Scanner s2 = new Scanner(System.in);
                int opcao2 = s2.nextInt();

                switch (opcao2) {
                    case 1:
                        Agenda.insertionSort_Name();
                        break;

                    case 2:
                        Agenda.insertionSort_Idade();
                        break;
                }
                System.out.println("Ordenação completa!");
                enterParaContinuar();
                break;

            case 3:

                String nome;
                int idade;
                long CPF;
                long telefone;
                String email;

                cabecalho("EDITAR INFORMACÇÕES DE CONTATO");
                System.out.println("Digite o nome do contato:");

                Scanner s3 = new Scanner(System.in);
                String nome = s3.nextLine();

                Contato c = Agenda.consultar(nome).getElement();

                System.out.print("Nome do contato: ");
                nome = s.nextLine();

                System.out.print("Idade do contato: ");
                idade = s.nextInt();

                System.out.print("CPF do contato: ");
                CPF = s.nextLong();

                System.out.print("Telefone do contato: ");
                telefone = s.nextLong();

                s.nextLine();
                System.out.print("Email do contato: ");
                email = s.nextLine();


                break;

            case 4:
                cabecalho("CONSULTAR DADOS DE CONTATO");


                break;

            case 5:
                cabecalho("REMOVER CONTATO");


                break;

            case 6:
                cabecalho("MOSTRAR LISTA DE CONTATOS");
                System.out.println(Agenda.toString_Header());
                enterParaContinuar();
                break;
        }
        if (opcao != 0) {
            menu(Agenda);
        }
    }


}

public void cadastrarNovoContato(List Agenda) {
    String nome;
    int idade;
    long CPF;
    long telefone;
    String email;

    Scanner s =  new Scanner(System.in);

    System.out.print("Nome do contato: ");
    nome = s.nextLine();

    System.out.print("Idade do contato: ");
    idade = s.nextInt();

    System.out.print("CPF do contato: ");
    CPF = s.nextLong();

    System.out.print("Telefone do contato: ");
    telefone = s.nextLong();

    s.nextLine();
    System.out.print("Email do contato: ");
    email = s.nextLine();

    Contato contato = new Contato(nome, idade, CPF, telefone, email);
    Node contato_new = new Node(contato, null, null);
    Agenda.add_ordenado(contato_new);
}

public void enterParaContinuar() {
    System.out.print("\n>>> Precione a tecla Enter para continuar <<<\n");

    Scanner s = new Scanner(System.in);
    s.nextLine();
}

public void dadosParaTeste(List Agenda) {

    //Contatos
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









