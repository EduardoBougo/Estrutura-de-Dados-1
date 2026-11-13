import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionParser {

    /**
     * Converte uma string de expressão matemática numa lista de tokens
     */
    public List<Token> tokenize(String expression) {
        List<Token> tokens = new ArrayList<>();
        StringBuilder numberBuffer = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // Skip os espaços
            if (Character.isWhitespace(c)) {
                continue;
            }

            // Se for um dígito ou ponto decimal, acumule-o
            if (Character.isDigit(c) || c == '.') {
                numberBuffer.append(c);
            } else {
                // Ao encontrar um caractere que não seja um dígito e tiver números acumulados, descarrega o buffer para um token
                if (numberBuffer.length() > 0) {
                    tokens.add(new Token(TokenType.NUMBER, numberBuffer.toString()));
                    numberBuffer.setLength(0); // Clear the buffer
                }

                // Verifique outros tipos de token
                if (isOperator(c)) {
                    tokens.add(new Token(TokenType.OPERATOR, String.valueOf(c)));
                } else if (c == '(') {
                    tokens.add(new Token(TokenType.OPEN_PARENTHESIS, String.valueOf(c)));
                } else if (c == ')') {
                    tokens.add(new Token(TokenType.CLOSE_PARENTHESIS, String.valueOf(c)));
                } else {
                    throw new IllegalArgumentException("Invalid character in expression: " + c);
                }
            }
        }

        // Descarregue qualquer número restante no buffer ao final da string
        if (numberBuffer.length() > 0) {
            tokens.add(new Token(TokenType.NUMBER, numberBuffer.toString()));
        }

        return tokens;
    }

    /**
     * Valida se a sequência de tokens forma uma expressão sintaticamente válida
     */
    public boolean isValid(List<Token> tokens) {
        if (tokens.isEmpty()) return false;

        int balance = 0;
        for (int i = 0; i < tokens.size(); i++) {
            Token current = tokens.get(i);
            Token next = (i + 1 < tokens.size()) ? tokens.get(i + 1) : null;

            if (current.getType() == TokenType.OPEN_PARENTHESIS) balance++;
            if (current.getType() == TokenType.CLOSE_PARENTHESIS) balance--;

            if (balance < 0) return false; // More closing than opening parens

            //Verificações básicas de sintaxe
            if (current.getType() == TokenType.OPERATOR) {
                // O operador não pode ser o último token
                if (next == null) return false;
                // Dois operadores consecutivos são inválidos
                if (next.getType() == TokenType.OPERATOR) return false;
            }

            // Parênteses vazios são inválidos ()
            if(current.getType() == TokenType.OPEN_PARENTHESIS && next != null && next.getType() == TokenType.CLOSE_PARENTHESIS) return false;
        }

        return balance == 0; // Deve terminar com parênteses balanceados
    }

    /**
     * Constrói a árvore de expressão a partir de uma lista de tokens usando o algoritmo Shunting Yard
     */
    public ExpressionTree buildTree(List<Token> tokens) {
        if (!isValid(tokens)) {
            throw new IllegalArgumentException("Invalid expression.");
        }

        Stack<BinaryNode<Token>> nodeStack = new Stack<>();
        Stack<Token> operatorStack = new Stack<>();

        for (Token token : tokens) {
            switch (token.getType()) {
                case NUMBER:
                    // Números sempre se tornam nós-folha imediatamente
                    nodeStack.push(new BinaryNode<>(token));
                    break;

                case OPEN_PARENTHESIS:
                    operatorStack.push(token);
                    break;

                case CLOSE_PARENTHESIS:
                    // Desempilhe operadores e construa subárvores até encontrar um parêntese de abertura
                    while (!operatorStack.isEmpty() && operatorStack.peek().getType() != TokenType.OPEN_PARENTHESIS) {
                        processTopOperator(nodeStack, operatorStack);
                    }
                    if (!operatorStack.isEmpty() && operatorStack.peek().getType() == TokenType.OPEN_PARENTHESIS) {
                        operatorStack.pop(); // Descarta o '('
                    }
                    break;

                case OPERATOR:
                    // Lidar com a precedência de operadores
                    while (!operatorStack.isEmpty() && 
                           operatorStack.peek().getType() == TokenType.OPERATOR &&
                           getPrecedence(operatorStack.peek().getValue()) >= getPrecedence(token.getValue())) {
                        processTopOperator(nodeStack, operatorStack);
                    }
                    operatorStack.push(token);
                    break;
            }
        }

        // Processe quaisquer operadores restantes na pilha
        while (!operatorStack.isEmpty()) {
            processTopOperator(nodeStack, operatorStack);
        }

        // O último nó restante na pilha é a raiz da árvore
        if (nodeStack.size() != 1) {
            throw new IllegalStateException("Failed to parse expression properly.");
        }

        ExpressionTree tree = new ExpressionTree();
        tree.getTree().setRoot(nodeStack.pop());
        return tree;
    }

    /**
     * Função auxiliar para remover um operador e dois nós, combiná-los em uma nova subárvore e inseri-la de volta
     */
    private void processTopOperator(Stack<BinaryNode<Token>> nodeStack, Stack<Token> operatorStack) {
        Token opToken = operatorStack.pop();
        BinaryNode<Token> rightNode = nodeStack.pop();
        BinaryNode<Token> leftNode = nodeStack.pop();

        BinaryNode<Token> newNode = new BinaryNode<>(opToken);
        newNode.setLeft(leftNode);
        newNode.setRight(rightNode);

        nodeStack.push(newNode);
    }

    private boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    private int getPrecedence(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0; // Não deve ser alcançado para operadores válidos
        }
    }
}