public class Main {
    public static void main(String[] args) {

        DList listadupla = new DList();

        DNode node_1 = new DNode("ABC", null, null);
        DNode node_2 = new DNode("DEF", null, null);
        DNode node_3 = new DNode("GHI", null, null);
        DNode node_4 = new DNode("JKL", null, null);
        DNode node_5 = new DNode("MNO", null, null);

        listadupla.addLast(node_1);
        listadupla.addLast(node_2);
        listadupla.addLast(node_3);
        listadupla.addLast(node_4);
        listadupla.addLast(node_5);

        System.out.println(listadupla.toString());


        listadupla.remove("def");
        System.out.println(listadupla.toString());

    }
}
