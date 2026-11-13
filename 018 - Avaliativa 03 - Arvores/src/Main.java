import java.util.List;

public class Main {
    public static void main(String[] args) {
        String expressao = "((5 + 4) * (3 - 2))";
        System.out.println("Expressão original: " + expressao);

        ExpressionParser parser = new ExpressionParser();

        try {
            // Quebrar a string em peças lógicas (Tokens)
            List<Token> tokens = parser.tokenize(expressao);
            System.out.println("Tokens gerados: " + tokens);

            // Validar a sintaxe
            if (!parser.isValid(tokens)) {
                System.out.println("Erro: A expressão informada é inválida (verifique parênteses e operadores).");
                return;
            }
            System.out.println("Validação: Expressão correta!");

            // Construir a Árvore Binária de Expressão usando Shunting-Yard
            ExpressionTree arvore = parser.buildTree(tokens);
            System.out.println("Árvore construída com sucesso!");

            // Avaliar (Calcular) percorrendo a árvore em Pós-Ordem
            double resultado = arvore.evaluate();
            System.out.println("===============================");
            System.out.println("Resultado do cálculo: " + resultado);
            System.out.println("===============================");

        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante o processamento: " + e.getMessage());
            e.printStackTrace();
        }
    }
}