/**
 * 125. Valid Palindrome
 *
 * @author b4yerl
 */
public class ValidPalindrome {
    /**
     * A minha primeira ideia para resolver este problema foi usar ReGex para limpar o input e assim poder iterar sobre ele
     * sem maiores preocupações, o único problema é que essa abordagem apanhou em eficiência, então parti pra outra depois.
     *
     * @param s Input
     * @return É um palíndromo ou não
     */
    public static boolean isPalindromeUsingRegex(String s) {
        if(s.isEmpty()) return true;
        // Aqui basicamente o replaceAll troca tudo que não for letra ou dígito por um nada kkkkkk
        // Usei [^a-zA-Z0-9], porque o \w inclui _ e eu não lembro como contorna isso
        // Por fim mandei tudo para LowerCase, assim comparamos direto os chars
        String sanitized = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = sanitized.length() - 1;

        while(left < right) {
            // Usei o operador de pós incremento só pra diminuir o número de linhas, porque sim :)
            if(sanitized.charAt(left++) != sanitized.charAt(right--)) return false;
        }
        return true;
    }

    /**
     * Nessa abordagem mais direta utilizei os métodos isLetterOrDigit() e toLowerCase() da própria classe Character.
     *
     * @param s Input
     * @return É um palíndromo ou não
     */
    public static boolean isPalindrome(String s) {
        if(s.isEmpty()) return true;
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);

            // Caso um dos ponteiros esteja em um char não alfanumérico, andamos na string e começamos uma nova iteração
            if(!Character.isLetterOrDigit(leftChar)) { left++; continue; }
            if(!Character.isLetterOrDigit(rightChar)) { right--; continue; }

            if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) return false;
            left++; right--;
        }
        return true;
    }
}
