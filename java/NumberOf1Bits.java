/**
 * 191. Number of 1 Bits
 *
 * @author b4yerl
 */
public class NumberOf1Bits {
    /**
     * Problema pra ser resolvido com Bitwise e Bitshift operators, aqui não tem muito segredo é mais conhecer os
     * operadores mesmo.
     *
     * @param n Input
     * @return Quantidade de bits 1 no input
     */
    public static int hammingWeight(int n) {
        int counter = 0;
        while(n != 0) {
            // Caso n termine em 1, a operação & retorna 1, senão 0 mesmo
            counter += (n & 1);
            // Usando o >>>, unsigned shift, preenchemos o lado esquerdo do número de zeros, assim em algum momento
            // n será igual a zero. Diferentemente do que ocorreria com >>, caso o número seja negativo ainda conseguimos
            // realizar a operação corretamente
            n = n >>> 1;
        }
        return counter;
    }
}
