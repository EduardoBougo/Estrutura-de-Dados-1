public class GameEntry {

    protected String name;	// nome da pessoa que obteve o escore
    protected int score;	// valor do escore

    /// Construtor que cria um registro do jogo

    public GameEntry(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /// Recupera o campo nome

    public String getName() {
        return name;
    }

    /// Recupera o campo escore

    public int getScore() {
        return score;
    }

    /// Retorna uma string com a representação deste registro

    public String toString() {
        return "(" + name + ", " + score + ")";
    }
}

