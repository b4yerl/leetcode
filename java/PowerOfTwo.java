/**
 * 231. Power of Two
 *
 * @author b4yerl
 */
public class PowerOfTwo {
    /**
     * Ao invés de fazer uma busca linear em O(N) para encontrar a resposta, apliquei inicialmente algo como uma busca binária,
     * dessa maneira podemos facilmente verificar se o input é uma potência de 2.
     *
     * @param n Input
     * @return {@code true} se o input for potência de 2, senão {@code false}
     */
    public static boolean isPowerOfTwo(int n) {
        int start = 0;
        int end = n / 2;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (Math.pow(2, mid) == n) return true;
            if (Math.pow(2, mid) > n) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }

    /**
     * Essa solução aqui eu fiz para usar o Math.log() na resolução.
     *
     * @param n Input
     * @return {@code true} se o input for potência de 2, senão {@code false}
     */
    public static boolean isPowerOfTwoUsingLog(int n) {
        if(n <= 0) return false;
        double log = Math.log(n) / Math.log(2);
        // Conferimos se o resultado é MUITO próximo de um inteiro
        // Não dá para conferir direto com um inteiro por possível imprecisão
        return Math.abs(log - Math.round(log)) < 1e-10;
    }
}
