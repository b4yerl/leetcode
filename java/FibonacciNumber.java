import java.util.HashMap;
import java.util.Map;

/**
 * 509. Fibonacci Number
 *
 * @author b4yerl
 */
public class FibonacciNumber {
    /**
     * Solução mais direta para o cálculo de fibonacci, aqui temos uma boa eficiência, mas um código talvez não tão elegante.
     * A ideia é realizar o cálculo dentro de um único loop, mantendo o controle dos 2 valores anteriores e com mais uma variável auxiliar.
     *
     * @param n
     * @return n-ésimo número da sequência de Fibonacci
     */
    public static int fib(int n) {
        if(n == 0 || n == 1) return n;

        int x1 = 0;
        int x2 = 1;

        for(int i = 1; i < n; i ++) {
            int aux = x1;
            x1 = x2;
            x2 = aux + x1;
        }
        return x2;
    }

    /**
     * Primeira das 2 soluções com recursividade, nesta escrita de forma mais simples, acabamos fazendo as mesmas operações
     * diversas vezes, o que acaba sendo prejudicial para a performance do algoritmo.
     * Ex: no cálculo de fib(4) passamos duas vezes por fib(2), mas a primeira operação não é reaproveitada na segunda.
     *
     * Esse problema acaba fatalmente jogando este algoritmo pro último lugar entre os 3 em termos de desempenho.
     *
     * @param n
     * @return n-ésimo número da sequência de Fibonacci
     */
    public static int fibUsingRecursion(int n) {
        if(n == 0 || n == 1) return n;
        return fibUsingRecursion(n - 2) + fibUsingRecursion(n - 1);
    }

    /**
     * Como devemos usar a assinatura fib(n) é necessário criar um segundo método para auxiliar na execução desejada.
     * Aqui utilizamos memoization para manter os resultados de todas as operações já executadas, dessa maneira reduzimos a
     * complexidade do método de O(2^N) para O(N) exatamente como no for loop simples.
     *
     * @param n
     * @return n-ésimo número da sequência de Fibonacci
     */
    public static int fibUsingMemoization(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return fibMemo(n, memo);
    }
    public static int fibMemo(int n, Map<Integer, Integer> memo) {
        if(n == 0 || n == 1) return n;
        // Caso o resultado não esteja presente no Map, iremos calculá-lo uma única vez
        if(!memo.containsKey(n)) memo.put(n, fibMemo(n - 2, memo) + fibMemo(n - 1, memo));
        // e a partir daí basta retornar o que já foi feito
        return memo.get(n);
    }
}
