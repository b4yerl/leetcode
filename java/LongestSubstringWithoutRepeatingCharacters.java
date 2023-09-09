import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * 
 * @author b4yerl
 */
public class LongestSubstringWithoutRepeatingCharacters {
  /**
   * Inicialmente achei simples e válido utilizar um Map para guardar o char da substring e seu index, 
   * assim é possível contar os chars da substring, além de voltar ao ponto certo quando esta se encerrar.
   * 
   * @param s Input do problema.
   * @return Tamanho da maior substring de chars distintos.
   */
  public static int lengthOfLongestSubstring(String s) {
    Map<Character, Integer> substringChars = new HashMap<>();
    char[] input = s.toCharArray();
    int maxLength = 0;

    for(int i = 0; i < s.length(); i++) {
      // Quando encontrar um char já registrado, modifica "i" voltando o loop para o ponto da nova substring
      if(substringChars.containsKey(input[i])) {
        maxLength = Math.max(maxLength, substringChars.size());
        i = substringChars.get(input[i]) + 1;
        substringChars.clear();
      }
      // O controle é feito com o char e seu index atual
      substringChars.put(input[i], i);
    }
    maxLength = Math.max(maxLength, substringChars.size());
    return maxLength;
  }
}
