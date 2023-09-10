/**
 * 9. Palindrome Number
 * @author b4yerl
 */
public class PalindromeNumber {
  /**
   * Nessa primeira abordagem, a ideia é manter dois ponteiros para verificar o número.
   * Enquanto um "vai subindo" o outro "volta", retornando falso caso haja diferença entre os chars.
   * 
   * @param x Número a ser verificado
   * @return Se o número é um palíndromo ou não
   */
  public static boolean isPalindrome(int x) {
    // Convertemos o número em string para iterarmos por ele
    String s = String.valueOf(x);
    int left = 0;
    int right = s.length() - 1;

    // As comparações são feitas até que os ponteiros se cruzem
    while(left < right) {
      if(s.charAt(left) != s.charAt(right)) return false;
      left++;
      right--;
    }
    // Saindo tudo ok do loop, constatamos que se trata de um palíndromo
    return true;
  }
  /**
   * Essa segunda abordagem é bem mais simples e utiliza o StringBuilder, classe que representa
   * uma sequência de caracteres mutáveis, ou seja, oposta à imutabilidade das Strings.
   * 
   * @param x Número a ser verificado
   * @return Se o número é um palíndromo ou não
   */
  public static boolean isPalindromeUsingStringBuilder(int x) {
    // Utilizaremos o StringBuilder para ter acesso ao método reverse()
    StringBuilder s = new StringBuilder().append(x);
    // Como ele não implementa o equals(), precisamos convertê-lo para String para garantir
    // a comparação correta do seu conteúdo
    return s.toString().equals(s.reverse().toString());
  }
}
