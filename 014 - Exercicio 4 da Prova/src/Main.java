public class Main {
    public static void main(String[] args) {

        CircleList circleList_1 = new CircleList();
        CircleList circleList_2 = new CircleList();


        Node node_01 = new Node("A", null);
        Node node_02 = new Node("B", null);
        Node node_03 = new Node("C", null);
        Node node_04 = new Node("D", null);

        Node node_05 = new Node("A", null);
        Node node_06 = new Node("B", null);
        Node node_07 = new Node("C", null);
        Node node_08 = new Node("D", null);


        circleList_1.add(node_01);
        circleList_1.add(node_02);
        circleList_1.add(node_03);
        circleList_1.add(node_04);

        circleList_2.add(node_07);
        circleList_2.add(node_08);
        circleList_2.add(node_05);
        circleList_2.add(node_06);

        System.out.println(circleList_1);
        System.out.println(circleList_2);

        System.out.println("==============================");

        System.out.println(CircleList.isEqualCircleList(circleList_1, circleList_2));
    }
}