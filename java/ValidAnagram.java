import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 *
 * @author b4yerl
 */
public class ValidAnagram {
    /**
     * Ocupando as mais baixas posições de eficiência, temos isso aqui, mas suporta UNICODE e ficou nos 3% melhores em uso
     * de memória :)
     *
     * A ideia é simples, vamos iterar por cada char das strings, enquanto uma adiciona valores ao Map, a outra subtrai,
     * dessa maneira caso tenhamos um anagrama, todos os valores do Map devem ser 0. Isso pode ser feito com um array
     * int[26], só que aí ficamos presos ao alfabeto, com o Map temos suporte pra geral.
     *
     * @param s Input 1
     * @param t Input 2
     * @return Se um input é anagrama do outro
     */
    public static boolean isAnagram(String s, String t) {
        if(s.isEmpty() && t.isEmpty()) return true;
        if(s.length() != t.length()) return false;

        Map<Character, Integer> charsTable = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            // Checamos se a key já esxiste para definir então se criamos uma ou atualizamos a existente
            if(charsTable.containsKey(s.charAt(i))) charsTable.put(s.charAt(i), charsTable.get(s.charAt(i)) + 1);
            else charsTable.put(s.charAt(i), 1);
            // Para a segunda String fazemos o mesmo, mas subtraindo o valor das keys
            if(charsTable.containsKey(t.charAt(i))) charsTable.put(t.charAt(i), charsTable.get(t.charAt(i)) - 1);
            else charsTable.put(t.charAt(i), -1);
        }
        // Caso haja um valor diferente de 0 no Map, sabemos que as Strings não são anagramas
        for(Integer n : charsTable.values()) {
            if(n != 0) return false;
        }

        return true;
    }
}
