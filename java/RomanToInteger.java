import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 *
 * @author b4yerl
 */
public class RomanToInteger {
    /**
     * Já deixar claro de início que esse método tem graves erros na validação do Input, só que é isso aqui mesmo que
     * o leetcode quer, então...
     *
     * Essa solução aqui possui O(N), a ideia é manter um Map com os valores de cada símbolo e montar o resultado em um
     * único for loop.
     *
     * @param s Input em algarismos romanos.
     * @return Número convertido
     */
    public static int romanToInt(String s) {
        Map<Character, Integer> conversionMap = new HashMap<>();
        conversionMap.put('I', 1);
        conversionMap.put('V', 5);
        conversionMap.put('X', 10);
        conversionMap.put('L', 50);
        conversionMap.put('C', 100);
        conversionMap.put('D', 500);
        conversionMap.put('M', 1000);

        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            // Caso o algarismo seguinte tenha um valor maior do que o atual, entende-se que ele está subtraindo do total
            // Note que a primeira condição serve para garantir a adição do último elemento verificado
            if((i < s.length() - 1) && (conversionMap.get(s.charAt(i)) < conversionMap.get(s.charAt(i + 1)))) {
                result -= conversionMap.get(s.charAt(i));
            } else {
                result += conversionMap.get(s.charAt(i));
            }
        }

        return result;
    }
}
