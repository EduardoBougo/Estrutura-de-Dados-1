import java.util.Scanner;

public class TicTacToe {

    protected static final int X = 1, O = -1; // Jogadores
    protected static final int EMPTY = 0; // Celula vazia
    protected int board[][] = new int[3][3]; // Tabuleiro
    protected int player; // Jogador corrente

    /// Método construtor ///
    public TicTacToe() {
        clearBoard();
    }

    /// Limpa o tabuleiro ///
    public void clearBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = EMPTY; // Toda celula deve estar vazia
            }
        }
        player = X; // Seleciona o primeiro jogador como ‘X’
    }

    /// Coloca um X ou O na posição i, j ///
    public void putMark(int i, int j) throws IllegalArgumentException {
        if ((i < 0) || (i > 2) || (j < 0) || (j > 2)) {
            throw new IllegalArgumentException("Invalid board position");
        }
        if (board[i][j] != EMPTY) {
            throw new IllegalArgumentException("Board position occupied");
        }
        board[i][j] = player;	// Insere a marca do jogador corrente
        player = -player;	// Troca os jogadores (usa o fato de que O = -X // -1 = -(1))
    }

    /// Verifica se a configuração do tabuleiro é vencedora para algum jogador

    public boolean isWin(int mark) {
        return ((board[0][0] + board[0][1] + board[0][2] == mark * 3) // linha 0 
                || (board[1][0] + board[1][1] + board[1][2] == mark * 3) // linha 1 
                || (board[2][0] + board[2][1] + board[2][2] == mark * 3) // linha 2 
                || (board[0][0] + board[1][0] + board[2][0] == mark * 3) // coluna 0 
                || (board[0][1] + board[1][1] + board[2][1] == mark * 3) // coluna 1 
                || (board[0][2] + board[1][2] + board[2][2] == mark * 3) // coluna 2 
                || (board[0][0] + board[1][1] + board[2][2] == mark * 3) // diagonal 
                || (board[2][0] + board[1][1] + board[0][2] == mark * 3)); // diagonal
    }

    /// Retorna o jogador vencedor ou indica um empate ///
    public int winner() {
        if (isWin(X)) {
            return (X);
        } else if (isWin(O)) {
            return (O);
        } else {
            return (0);
        }
    }

    /// Retorna uma string de caracteres que representa o tabuleiro corrente ///
    public String toString() {
        String s = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case X:
                        s += " X ";
                        break;
                    case O:
                        s += " O ";
                        break;
                    case EMPTY:
                        s += "   ";
                        break;
                }
                if (j < 2) {
                    s += "|";// limite da coluna 
                }
            }
            if (i < 2) {
                s += "\n-----------\n";// limite da linha
            }
        }
        return s;
    }


    public static void main(String[] args) {

        System.out.println("===========================");
        System.out.println(" Vamos jogar jogo da velha ");
        System.out.println("===========================");

        TicTacToe game = new TicTacToe(); // Inicia um novo tabuleiro

        int end = 1;

        while (end != 0) {
            System.out.println("========================================");
            System.out.println("                Tabuleiro               ");
            System.out.println("========================================");
            System.out.println(game.toString());

            Scanner sc = new Scanner(System.in);
            if (end == 1) {
                System.out.println("Jogador (X) jogando - Escolha uma posição: ");
            }
            else if (end == -1) {
                System.out.println("Jogador (O) jogando - Escolha uma posição: ");
            }

            int option = 0;
            option = sc.nextInt();

            switch (option) {
                case 1 -> game.putMark(0, 0);
                case 2 -> game.putMark(0, 1);
                case 3 -> game.putMark(0, 2);
                case 4 -> game.putMark(1, 0);
                case 5 -> game.putMark(1, 1);
                case 6 -> game.putMark(1, 2);
                case 7 -> game.putMark(2, 0);
                case 8 -> game.putMark(2, 1);
                case 9 -> game.putMark(2, 2);
            }
            if (game.isWin(end) == true ) {
                System.out.println("Fim de game");
                end = 0;
            }
            else {
                end = -end;
            }
        }

        System.out.println(game.toString());
        int winningPlayer = game.winner();
        if (winningPlayer != 0) {
            if (winningPlayer == 1) {
                System.out.println("(X) wins");
            }
            else if (winningPlayer == -1) {
                System.out.println("(O) wins");
            }
        } else {
            System.out.println("Tie");
        }
    }
}
