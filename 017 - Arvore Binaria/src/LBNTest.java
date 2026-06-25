/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fabricio
 */
public class LBNTest {

    public static void main(String[] args) {
        //BTNode<String> node1 = new BTNode("Presidente", null, null, null);

        LinkedBinaryTree<String> arvoreb = new LinkedBinaryTree();
        Position vendas = arvoreb.addRoot("Vendas");
        Position nacional = arvoreb.insertLeft(vendas, "Nacional");
        Position internacional = arvoreb.insertRight(vendas, "Internacional");

        Position canada = arvoreb.insertLeft(internacional, "Canada");
        Position ultramar = arvoreb.insertRight(internacional, "ultramar");

        Position africa = arvoreb.insertLeft(ultramar, "Africa");
        Position europa = arvoreb.insertRight(ultramar, "Europa");

        arvoreb.preorderPositions(vendas, new NodePositionList<Position<String>>());

        System.out.println(arvoreb.size);
    }
}
