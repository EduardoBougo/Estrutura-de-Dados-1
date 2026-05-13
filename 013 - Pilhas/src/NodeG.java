
/// Nó de uma lista simplesmente encadeada,
/// que armazena referências do seu elemento e aponta para o próximo nó da lista.

public class NodeG<E> {

  // Atributos
  private E element;
  private NodeG<E> next;

  // Cria um nó generico com elemento e proximo nó com valor NULl
  public NodeG() {
    this(null, null);
  }
  // Cria um nó com o elemento fornecido e o próximo nó
  public NodeG(E e, NodeG<E> n) {
    element = e;
    next = n;
  }

  // Accessor methods:
  public E getElement() {
    return element; 
  } // Retorna o elemento do nó

  public NodeG<E> getNext() { 
    return next;
  } // Retorna o proximo nó


  // Modifier methods:
  public void setElement(E newElem) { 
    element = newElem; 
  } // Modifica o elemento pelo fornecido

  public void setNext(NodeG<E> newNext) {
    next = newNext; 
  } // Modifica o proximo nó que aponta
}
