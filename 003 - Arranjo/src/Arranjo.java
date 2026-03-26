public class Arranjo {


    public static int sum(int[] a) {
        int total = 0;
        for (int i = 0; i < a.length; i++) // observe-se o uso da variável length
        {
            total += a[i];
        }
        return total;
    }

    /**
     * Conta o numero de vezes que um inteiro k aparece em um arranjo a
     */
    public static int findCount(int[] a, int k) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                count++;
            }
        }
        return count;
    }

    /// Função que exibe na tela o maior e menor valor de um Array ///
    public static void printMaxAndMin(int [] entrada){
        int max = entrada[findMax(entrada)];
        int min = entrada[findMin(entrada)];
        System.out.printf("O maior valor do Array é %d e o menor é %d", max, min);
    }

    /// Encontra o menor valor de um Array e retorna sua posição///
    public static int findMin(int[] entrada){
        int min = 0;

        for (int i = 0; i < entrada.length; i++){
            if  (entrada[i] < entrada[min]){
                min = i;
            }
        }
        return min;
    }

    /// Encontra o maior valor de um Array e retorna sua posição///

    public static int findMax(int[] entrada){
        int max = 0;

        for (int i = 0; i < entrada.length; i++){
            if  (entrada[i] > entrada[max]){
                max = i;
            }
        }
        return max;
    }

    /// Função que imprime o Array invertido  ///
    public static void printReverseArray(int[] entrada){
        for (int i = entrada.length - 1; i >= 0; i--){
            System.out.print(entrada[i] + " ");
        }
    }

/// *********************************************************************************************** ///
/// Função printArray - Mesmo tendo o mesmo nome, são diferenciadas automaticamente pelos parametros///
/// *********************************************************************************************** ///
    public static void printArray(int[] entrada){
        for (int i = 0; i < entrada.length; i++) {
            System.out.println(entrada[i]);
        }
    }

    public static void printArray(double[] entrada){
        for (int i = 0; i < entrada.length; i++) {
            System.out.println(entrada[i]);
        }
    }
}



