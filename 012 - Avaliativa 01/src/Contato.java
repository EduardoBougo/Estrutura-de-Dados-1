public class Contato {

    // Atributos
    protected String nome;
    protected int idade;
    protected long CPF;
    protected long telefone;
    protected String email;

    // Função Construtor
    public Contato(String nome, int idade, long CPF, long telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
    }

    // Nome
    public String getNome() {
        return nome;
    }

    // Idade
    public int getIdade() {
        return idade;
    }

    // CPF
    public long getCPF() {
        return CPF;
    }

    // Telefone
    public long getTelefone() {
        return telefone;
    }

    // Email
    public String getEmail() {
        return email;
    }

    /// Atualiza as informações de cadatro de um contato ///
    public void contatoUpdate(String nome, int idade, long CPF, long telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.CPF = CPF;
        this.telefone = telefone;
        this.email = email;
    }


}
