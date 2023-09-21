/**
 * 557. Reverse Words in a String III
 *
 * @author b4yerl
 */
public class ReverseWordsInAString3 {
    /**
     * Nessa primeira abordagem fiz diretão em O(N*M) com dois loops aninhados, o externo iterando por cada palavra do input e
     * o segundo por cada caracter da palavra atual.
     *
     * @param s Input
     * @return Palavras invertidas, mas na ordem original
     */
    public static String reverseWords(String s) {
        String[] originalWords = s.split(" ");
        StringBuilder output = new StringBuilder();
        for(String word : originalWords) {
            for(int i = word.length() - 1; i >= 0; i--) output.append(word.charAt(i));
            output.append(" ");
        }
        // Fatalmente tem um espaço a mais no final
        output.deleteCharAt(output.length() - 1);
        return output.toString();
    }

    /**
     * A ideia em si é a mesma, mas dessa vez a manipulação é feita totalmente com StringBuilder, principalmente com o
     * método reverse(), acho que por ele trabalhar a nível de bits acabou tendo uma performance melhor, sei lá também
     * no fim o tradeoff foi um consumo maior de memória.
     *
     * @param s Input
     * @return Palavras invertidas, mas na ordem original
     */
    public static String reverseWordsUsingSBReverse(String s) {
        String[] originalWords = s.split(" ");
        StringBuilder[] output = new StringBuilder[originalWords.length];
        for(int i = 0; i < originalWords.length; i++) {
            StringBuilder word = new StringBuilder(originalWords[i]);
            output[i] = word.reverse();
        }
        return String.join(" ", output);
    }
}
