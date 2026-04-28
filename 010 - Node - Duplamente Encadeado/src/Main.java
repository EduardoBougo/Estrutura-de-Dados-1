import java.net.SocketOption;

public class Main {
    public static void main(String[] args) {

        DList listadupla = new DList();

        DNode node_1 = new DNode("ABC", null, null);
        DNode node_2 = new DNode("DEF", null, null);
        DNode node_3 = new DNode("GHI", null, null);
        DNode node_4 = new DNode("JKL", null, null);
        DNode node_5 = new DNode("MNO", null, null);

        DNode node_6 = new DNode("PQR", null, null);
        DNode node_7 = new DNode("TUV", null, null);
        DNode node_8 = new DNode("WXYZ", null, null);
        DNode node_9 = new DNode("XYZ", null, null);
        DNode node_10 = new DNode("ZXY", null, null);

        listadupla.addLast(node_5);
        listadupla.addLast(node_4);
        listadupla.addLast(node_3);
        listadupla.addLast(node_2);
        listadupla.addLast(node_1);

        //System.out.println(listadupla.toString());


        // listadupla.remove("def");
        DList lista_teste =  new DList();
        lista_teste.addLast(node_6);
        lista_teste.addLast(node_7);
        lista_teste.addLast(node_8);
        lista_teste.addLast(node_9);
        lista_teste.addLast(node_10);

        listadupla.insertionSort(listadupla);
        System.out.println(listadupla.toString());
        System.out.println(lista_teste.toString());

        System.out.println("=======================================");

        DList listaSomada = new DList();

        listaSomada.linkLists(listadupla, lista_teste);

        System.out.println(listaSomada.toString());
        System.out.println(listaSomada.size());

    }
}
