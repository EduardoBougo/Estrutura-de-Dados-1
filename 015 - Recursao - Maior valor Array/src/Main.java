/*
* Descreva um algoritmo recursivo para encontrar
* o maior elemento em um arranjo A de n elementos inteiros.
* Qual é o tempo de execução e a memória utilizada?
*/

/*
* Utilizando recursão Binária.
* Primeiro, o código verifica a quantidade de elementos na porção do arranjo que está sendo analisada.
* Se esse tamanho for maior que cinco elementos, o algoritmo divide o problema ao meio, calculando o ponto central,
* e faz duas chamadas recursivas a si mesmo: uma para buscar o índice do maior elemento na metade esquerda e outra para a metade direita.
* Ao receber os retornos dessas chamadas, ele compara os valores armazenados nesses dois índices e devolve o que apontar para o maior número.
*
* No entanto, se as divisões sucessivas reduzam o tamanho do sub-arranjo para cinco elementos ou menos,
* o algoritmo atinge seu caso base e interrompe a recursão.
* Nesse momento, ele utiliza um laço de repetição simples para percorrer linearmente esse pequeno bloco,
* encontrando e retornando o índice do maior elemento de forma direta.
*
* O tempo de execução é linear, com tempo de O(n),
* já a memória utilizada no algoritmo é logarítmica, com complexidade de O(log n).
*/
void main() {

    int[] array = {25, 2, 3, 4, 5, 6, 7, 8, 9, 100, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24};

    int position_max = maiorNumArray.maiorNumArray(array, 0, array.length - 1);

    System.out.printf("O maior número do Array é %d e sua posição é %d", array[position_max], position_max);
}


