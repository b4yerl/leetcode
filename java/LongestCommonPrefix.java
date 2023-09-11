import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 14. Longest Common Prefix
 *
 * @author b4yerl
 */
public class LongestCommonPrefix {
    /**
     * Para esta solução a ideia é manter uma referência ao tamanho máximo do prefixo, dessa maneira podemos ajustar o
     * espaço de busca, impedindo, no caso médio, uma complexidade de O(N^2) nos loops aninhados.
     *
     * @param strs Input
     * @return Maior prefixo em comum
     */
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length <= 1) return strs[0];

        // Inicialmente o tamanho máximo deve ser o tamanho da menor string do Array de entrada
        int prefixMaxLength = Integer.MAX_VALUE;
        for(String s : strs) prefixMaxLength = Math.min(prefixMaxLength, s.length());
        for(int i = 1; i < strs.length; i++) {
            int counter = 0;
            // Note que iremos iterar apenas sobre os caracteres possíveis para o maior prefixo em comum e não sobre todos
            for(int j = 0; j < prefixMaxLength; j++) {
                // O contador sobe apenas enquanto os caracteres das strings forem iguais
                if(strs[0].charAt(j) == strs[i].charAt(j)) counter++;
                else break;
            }
            prefixMaxLength = counter;
            // Se em algum momento o tamanho máximo for 0, já podemos quebrar o loop e retornar a string vazia
            if(prefixMaxLength == 0) return "";
        }
        return strs[0].substring(0, prefixMaxLength);
    }

    /**
     * Nesse método primeiro ordenamos o array, dessa maneira teremos uma ordem alfabética e consequentemente
     * o primeiro e o último elementos cobrirão nosso maior prefixo possível.
     *
     * @param strs Input
     * @return Maior prefixo em comum
     */
    public static String longestCommonPrefixSortingArray(String[] strs) {
        // Ordenação utilizando a Streams API
        String[] sortedInput = Arrays.stream(strs).sorted().toArray(String[]::new);
        String head = sortedInput[0];
        String tail = sortedInput[sortedInput.length - 1];
        int counter = 0;
        for(int i = 0; i < head.length(); i++) {
            if(i >= tail.length()) break;
            // Quando os caracteres não forem iguais quebramos o loop e assim, ficamos com o contador definindo o tamanho
            // do maior prefixo em comum dentro do array de input
            if(head.charAt(i) == tail.charAt(i)) counter++;
            else break;
        }
        return (counter == 0) ? "" : head.substring(0, counter);
    }
}
