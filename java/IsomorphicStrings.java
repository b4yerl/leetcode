import java.util.HashMap;
import java.util.Map;

/**
 * 205. Isomorphic Strings
 *
 * @author b4yerl
 */
public class IsomorphicStrings {
    /**
     * Usando o Map podemos manter o controle sobre a relação entre os chars e assim garantir a validação.
     *
     * @param s Input 1
     * @param t Input 2
     * @return Se são strings isomórficas
     */
    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> characterMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char keyChar = s.charAt(i);
            char valueChar = t.charAt(i);
            // Essa verificação garante que uma key sempre apontará para um único value
            if(characterMap.containsKey(keyChar)) {
                if(characterMap.get(keyChar) != valueChar) return false;
            }
            // Da mesma forma um value não poderá estar em mais de uma key
            else if(characterMap.containsValue(valueChar)) return false;
            characterMap.put(keyChar, valueChar);
        }
        return true;
    }
}
