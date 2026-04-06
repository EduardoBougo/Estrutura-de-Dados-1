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
                        s += "X";
                        break;
                    case O:
                        s += "O";
                        break;
                    case EMPTY:
                        s += " ";
                        break;
                }
                if (j < 2) {
                    s += "|";// limite da coluna 
                }
            }
            if (i < 2) {
                s += "\n-----\n";// limite da linha
            }
        }
        return s;
    }

// Testa a execução de um jogo simples 
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.putMark(1, 1); ///* Jogada de X */ 
        game.putMark(0, 2); ///* Jogada de O */ 
        game.putMark(2, 2); ///* Jogada de X */ 
        game.putMark(0, 0); ///* Jogada de O */ 
        game.putMark(0, 1); ///* Jogada de X */ 
        game.putMark(2, 1); ///* Jogada de O */ 
        game.putMark(1, 2); ///* Jogada de X */ 
        game.putMark(1, 0); ///* Jogada de O */ 
        game.putMark(2, 0); ///* Jogada de X */ 

        System.out.println(game.toString());
        int winningPlayer = game.winner();
        if (winningPlayer != 0) {
            System.out.println(winningPlayer + " wins");
        } else {
            System.out.println("Tie");
        }
    }
}
