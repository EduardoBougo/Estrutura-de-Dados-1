public class CreditCard {

    // Variáveis de instância:
    private String number;
    private String name;
    private String bank;
    private double balance;
    private int limit;

    // Construtor: 
    CreditCard(String number, String name, String bank, double balance, int limit) {
        this.number = number;
        this.name = name;
        this.bank = bank;
        this.balance = balance;
        this.limit = limit;
    }

    //Metodos de acesso:
    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }

    public int getLimit() {
        return limit;
    }

    // Métodos de acao:

    /// Errado ///
    //public boolean chargeIt(double price) { // Debita
    //    if (price + balance > (double) limit) {
    //        return false; // Não há dinheiro suficiente para debitar
    //    }
    //    balance += price;
    //    return true; // Neste caso, o débito foi efetivado
    //}


    public void makePayment(double payment) { // Faz um pagamento com juros de 2%
        balance -= payment + ((payment/100) * 2);
    }

    public static void printCard(CreditCard c) { // Imprime informações sobre o cartao      
        System.out.println("Number = " + c.getNumber());
        System.out.println("Name = " + c.getName());
        System.out.println("Bank = " + c.getBank());
        System.out.println("Balance = " + c.getBalance()); // Conversao implicita 
        System.out.println("Limit = " + c.getLimit()+"\n"); // Conversao implicita
    }
}
