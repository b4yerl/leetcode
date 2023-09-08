import java.util.Map;
import java.util.HashMap;

/**
 * 1. Two Sum
 * @author b4yerl
 */
public class TwoSum {
  public static void main(String[] args) {
    int[] testArray = new int[100000];
    for(int i = 0; i < 100000; i++) {
      testArray[i] = i + 1;
    }

    long startTime = System.currentTimeMillis();
    twoSumOrderN(testArray, 199999);
    long finishTime = System.currentTimeMillis();
    System.out.println("Time taken for O(N): " + (finishTime - startTime) + "ms");

    startTime = System.currentTimeMillis();
    twoSumOrderSquared(testArray, 199999);
    finishTime = System.currentTimeMillis();
    System.out.println("Time taken for O(N^2): " + (finishTime - startTime) + "ms");
  }
  
  /**
   * Método mais simples de solucionar o problema, basicamente aninhando dois loops e
   * gerando uma complexidade de O(N^2). O que fazemos é conferir cada soma possível até encontrar a resposta.
   * 
   * @param nums Array de input.
   * @param target Resultado a ser alcançado pela soma de dois elementos de nums.
   * @return Array de tamanho 2 com os index dos elementos da soma.
   */
  public static int[] twoSumOrderSquared(int[] nums, int target) {
    for(int i = 0; i < nums.length - 1; i++) {
      for(int j = i + 1; j < nums.length; j++) {
        if(nums[i] + nums[j] == target) return new int[]{i, j};
      }
    }
    return null;
  }
  /**
   *  Nessa solução implementamos um Map, com isso é possível rodar o algoritmo em O(N).
   *  A ideia básica é realizar uma operação contrária para registrar as possibilidades de somas.
   * @param nums Array de input.
   * @param target Resultado a ser alcançado pela soma de dois elementos de nums.
   * @return Array de tamanho 2 com os index dos elementos da soma.
   */
  public static int[] twoSumOrderN(int[] nums, int target) {
    Map<Integer, Integer> possibilities = new HashMap<>();
    int[] indexes = new int[2];

    for(int i = 0; i < nums.length; i++) {
      // Caso o elemento atual já esteja no nosso Map, apenas retornamos o index salvo com o atual
      if(possibilities.containsKey(nums[i])) {
        indexes[0] = possibilities.get(nums[i]);
        indexes[1] = i;
        return indexes;
      }
      // Salvamos o complemento do resultado como a chave e o index do elemento atual como valor.
      else {
        possibilities.put(target - nums[i], i);
      }
    }
    return indexes;
  }
}
