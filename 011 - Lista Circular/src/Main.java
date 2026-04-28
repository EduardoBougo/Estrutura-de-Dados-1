import java.net.SocketOption;

public class Main {
    public static void main(String[] args) {
        CircleList circleList = new CircleList();
        CircleList circleList2 = new CircleList();

        Node node_1 = new Node("ABC", null);
        Node node_2 = new Node("DEF", null);
        Node node_3 = new Node("GHI", null);
        Node node_4 = new Node("JKL", null);
        Node node_5 = new Node("MNO", null);
        Node node_6 = new Node("PQR", null);
        Node node_7 = new Node("TUV", null);
        Node node_8 = new Node("WXYZ", null);
        Node node_9 = new Node("XYZ", null);
        Node node_10 = new Node("ZXY", null);

        circleList.add(node_1);
        circleList.add(node_2);
        circleList.add(node_3);
        circleList.add(node_4);
        circleList.add(node_5);
        circleList.add(node_6);
        circleList.add(node_7);
        circleList.add(node_8);
        circleList.add(node_9);
        circleList.add(node_10);


        System.out.println(circleList.toString());
        System.out.println(circleList.countNodes());
        System.out.println(circleList2.countNodes());

    }
}
