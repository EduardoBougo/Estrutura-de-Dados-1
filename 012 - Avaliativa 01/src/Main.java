void main() {

    // Criando lista
    List Agenda = new List();

    //Contatos
    Contato c_1 = new Contato("Eduardo", 19, 11122233345L, 18981101017L, "eduardobougo@gmail.com");
    Contato c_2 = new Contato("Andrea", 48, 11100022245L, 18997523822L, "andrea@gmail.com");
    Contato c_3 = new Contato("Flavio", 53, 44477788899L, 1836525845L, "flavio@gmail.com");

    // Criando Nodos
    Node contato_1 = new Node(c_1, null, null);
    Node contato_2 = new Node(c_2, null, null);
    Node contato_3 = new Node(c_3, null, null);

    // Adicionando os Contatos a lista
    Agenda.addFirst(contato_1);
    Agenda.addFirst(contato_2);
    Agenda.addFirst(contato_3);

    //Agenda.insertionSort_Idade();

    System.out.println(Agenda.toString_Header());

    //System.out.println(Agenda.toString_Tail());

    System.out.println(Agenda.exibirInformacao("Flavio"));

    //Agenda.remove_CPF(44477788899L);

    //System.out.println(Agenda.toString_Header());
}
