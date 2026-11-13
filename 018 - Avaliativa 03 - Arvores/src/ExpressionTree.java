public class ExpressionTree {
    // COMPOSIÇÃO - A ExpressionTree "tem uma" BinaryTree dentro dela
    private BinaryTree<Token> tree;

    public ExpressionTree() {
        this.tree = new BinaryTree<>();
    }

    public BinaryTree<Token> getTree() {
        return tree;
    }

    /**
     * Avalia a expressão matemática guardada na árvore
     */
    public double evaluate() {
        if (tree.isEmpty()) {
            throw new IllegalStateException("A árvore de expressão está vazia.");
        }
        // Inicia a recursão passando a raiz da árvore
        return evaluateRecursive(tree.getRoot());
    }

    /**
     * Método recursivo privado que faz o percurso Pós-Ordem
     */
    private double evaluateRecursive(BinaryNode<Token> node) {
        // CASO BASE: Se o nó for um NÚMERO (folha), apenas converta o texto para Double e retorne
        if (node.getValue().getType() == TokenType.NUMBER) {
            return Double.parseDouble(node.getValue().getValue());
        }
        // PÓS-ORDEM
        // Avaliar toda a subárvore da Esquerda
        double leftVal = evaluateRecursive(node.getLeft());
        
        // Avaliar toda a subárvore da Direita
        double rightVal = evaluateRecursive(node.getRight());

        // Avaliar a Raiz (Executar a operação)
        String operator = node.getValue().getValue();
        
        switch (operator) {
            case "+":
                return leftVal + rightVal;
            case "-":
                return leftVal - rightVal;
            case "*":
                return leftVal * rightVal;
            case "/":
                if (rightVal == 0) {
                    throw new ArithmeticException("Erro: Divisão por zero não é permitida.");
                }
                return leftVal / rightVal;
            default:
                throw new UnsupportedOperationException("Operador desconhecido: " + operator);
        }
    }
}