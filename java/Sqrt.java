/**
 * 69. Sqrt(x)
 *
 * @author b4yerl
 */
public class Sqrt {
    /**
     *  Com essa abordagem aqui consegui ocupar os piores desempenhos do leetcode kkkkkkkkkkkkkkkk,
     *  mas ralei pra fazer isso aqui passar sem estourar nos casos extremos. Em compensação ficou na parte de cima da
     *  tabela em uso de memória :P
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
}
