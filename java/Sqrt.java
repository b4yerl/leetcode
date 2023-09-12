/**
 * 69. Sqrt(x)
 *
 * @author b4yerl
 */
public class Sqrt {
    /**
     *  Com essa abordagem aqui consegui ocupar os piores desempenhos do leetcode kkkkkkkkkkkkkkkk,
     *  mas ralei pra fazer isso aqui passar sem estourar nos casos extremos :P
     *
     * @param x Input
     * @return Retorna o inteiro mais próximo da raiz quadrada
     */
    public static int sqrt(int x) {
        for(int i = 1; i <= x; i++) {
            // Usei a condição assim pra não tomar um Integer Overflow
            if(x / i == i) return i;
            // No momento em que essa condição for satisfeita, nós passamos da resposta
            if(x / i < i) {
                // No fim das contas a raiz seria algo como "i - 1" seguido da parte decimal
                return i - 1;
            }
        }
        return 0;
    }

    /**
     * Como o problema é a busca por um elemento em um conjunto ordenado (números naturais menores que 2^31), podemos implementar
     * algoritmos de busca para solucioná-lo, inclusive a minha primeira solução é uma busca linear, O(N), podemos melhorar
     * sua velocidade com uma busca binária, O(log n).
     *
     * @param x Input
     * @return Retorna o inteiro mais próximo da raiz quadrada
     */
    public static int sqrtBinarySearch(int x) {
        // Tratamos casos de x == 0 e x == 1
        if(x <= 1) return x;

        int start = 1;
        // Cortar por 2 não atrapalha nenhum caso já que o resultado para 2 e 3 tem que ser 1 e para 4 é o próprio 2
        int end = x / 2;
        int mid = 0;

        while(start <= end) {
            mid = (start + end) / 2;
            if(x / mid == mid) return mid;
            if(x / mid > mid) start = mid + 1;
            else end = mid - 1;
        }
        return (x / mid < mid) ? mid - 1 : mid;
    }
}
