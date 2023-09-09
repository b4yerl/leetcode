import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
  /**
   * Após enviar a primeira solução fui pesquisar como melhorar o desempenho do código. 
   * Inicialmente fica fácil de se perceber que permanecer retornando o loop acaba trazendo uma lentidão desnecessária.
   * Trombei então com a ideia de Sliding Window. A ideia é manter ponteiros como se fossem limites da nossa janela, 
   * com isso é possível avançar um lado e quando necessário trazer o outro até onde for preciso.
   * 
   * @param s Input do problema
   * @return Tamanho da maior substring de chars distintos.
   */
  public static int lengthOfLongestSubstringUsingSlidingWindow(String s) {
    // Aqui utilizaremos um Set, principalmente pelo retorno booleano do seu add e claro pelo seu princípio básico, 
    // ser uma lista de elementos distintos.
    Set<Character> substringChars = new HashSet<>();
    int maxLength = 0;
    int left = 0;

    for(int right = 0; right < s.length(); right++) {
      // Enquanto pudermos adicionar elementos distintos, a condicional não é satisfeita
      while(!substringChars.add(s.charAt(right))) {
        // Aqui começamos a trazer o "lado esquerdo" removendo tudo que vem antes da repetição
        // Ao mesmo tempo usamos o operador de pós incremento para seguir o avanço.
        substringChars.remove(s.charAt(left++));
      }
      // O tamanho então é atualizado com a distância entre os lados.
      maxLength = Math.max(maxLength, right - left + 1);
    }
    // Essa solução conseguiu ser muito mais rápida do que a minha original
    // justamente por otimizar o começo da noa substring
    return maxLength;
  }
}
