
/// Exceção de tempo de execução gerada quando alguém tenta executar a operação top ou pop em uma pilha vazia.

public class EmptyStackException extends RuntimeException {  
  public EmptyStackException(String err) {
    super(err);
  }
}

