/**
 * 58. Length of Last Word
 *
 * @author b4yerl
 */
public class LengthOfLastWord {
    /**
     * Aqui é só mesmo separar a string em um array, isso porque sabemos que o input é uma string de palavras separadas
     * por espaço.
     *
     * Depois basta retornar o tamanho do último elemento '-'
     *
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        return words[words.length - 1].length();
    }
}
