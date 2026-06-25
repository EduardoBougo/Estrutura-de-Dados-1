/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author fabricio
 */
public class LTTest {
    
    public static void main(String[] args) {
        LinkedTree<String> arvoregenerica = new LinkedTree();
        TreePosition<String> raiz = arvoregenerica.addRoot("Vendas");
        
        TreePosition<String> nacional = arvoregenerica.createNode("Nacional", raiz, null);
        TreePosition<String> internacional = arvoregenerica.createNode("Internacional", raiz, null);
        
        NodePositionList<Position<String>> filhos1 = new NodePositionList<Position<String>>();
        filhos1.addFirst(nacional);
        filhos1.addLast(internacional);
        
        raiz.setChildren(filhos1);
        
        TreePosition<String> canada = arvoregenerica.createNode("Canada", internacional, null);
        TreePosition<String> americasul = arvoregenerica.createNode("AmericaSul", internacional, null);
        TreePosition<String> ultramar = arvoregenerica.createNode("Ultramar", internacional, null);
        
        NodePositionList<Position<String>> filhos2 = new NodePositionList<Position<String>>();
        
        filhos2.addFirst(ultramar);
        filhos2.addFirst(americasul);
        filhos2.addFirst(canada);
        
        internacional.setChildren(filhos2);
        
        TreePosition<String> africa = arvoregenerica.createNode("Africa", ultramar, null);
        TreePosition<String> europa = arvoregenerica.createNode("Europa", ultramar, null);
        TreePosition<String> asia = arvoregenerica.createNode("Asia", ultramar, null);
        TreePosition<String> australia = arvoregenerica.createNode("Australia", ultramar, null);
        
        NodePositionList<Position<String>> filhos3 = new NodePositionList<Position<String>>();
        filhos3.addFirst(australia);
        filhos3.addFirst(asia);
        filhos3.addFirst(europa);
        filhos3.addFirst(africa);
        ultramar.setChildren(filhos3);
        
        arvoregenerica.preorderPositions(raiz, new NodePositionList<Position<String>>());
        
    }
}
