import java.util.Scanner;

/** Dada uma expressão matemática que pode conter
 * os símbolos de abertura ‘(‘, ‘[‘, ‘{‘ e de fechamento ‘)’, ‘]’, ‘}’ além de números e operadores.
 * Implemente uma solução usando uma pilha genérica (tamanho dinâmico)
 * que verifique os símbolos em uma expressão aritmética e retorne se aparecem corretamente na equação.
 * */

public class Main {
    public static void main(String[] args) {

        boolean correct = true;

        // Criando uma ArrayStack (Pilha) Vazia
        ArrayStack<Character> pilha = new ArrayStack<Character>();

        System.out.println("Digite sua expressão matematica : ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        char[] caracteres = input.toCharArray();

        for (int i = 0; i < caracteres.length; i++) {
            char a = caracteres[i];
            if ((a == '(') || (a == '[') || (a == '{')) {
                pilha.push(a);
            } else if ((a == ')') || (a == ']') || (a == '}')) {
                if (pilha.isEmpty()) { // Equação errada
                    correct = false;
                    break;
                }
                else {
                    char aux = pilha.pop();
                    if ((aux == '(' && a != ')' ||
                         aux == '[' && a != ']' ||
                         aux == '{' && a != '}')){ // Equação errada
                        correct = false;
                        break;
                    }
                }
            }
        }
        if (!pilha.isEmpty()) {
            correct = false;
        }


        if (correct) {
            System.out.println("Equação correta!");
        }
        else {
            System.out.println("Equação incorreta!");
        }

        System.out.println("Fim do codigo");
    }
}
