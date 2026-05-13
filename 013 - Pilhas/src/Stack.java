
/// Interface’ para uma pilha:
 /// Uma coleção de objetos que são inseridos e removidos
 /// comforme o princípio do último a entrar, primeiro a sair.
 /// Esta interface inclui os principais métodos de java.util.Stack

public interface Stack<T> {

 /// Retorna o número de elementos na Pilha
 /// @retorna o número de elementos na pilha.
   public int size();

   /// Retorne se a pilha está vazia.
   ///@return true se a pilha estiver vazia, false caso contrário.

  public boolean isEmpty();

  /// Inspecione o elemento na parte superior da pilha.
  /// @retornar elemento superior na pilha.
  /// @exception EmptyStackException se a pilha estiver vazia.
  public T top()
    throws EmptyStackException;  

  /// Insira um elemento no topo da pilha.
  /// @param element a ser inserido.
  public void push (T element);

  /// Remova o elemento superior da pilha.
  /// @elemento de retorno removido.
  /// @exception EmptyStackException se a pilha estiver vazia.
  public T pop()
    throws EmptyStackException; 
}

