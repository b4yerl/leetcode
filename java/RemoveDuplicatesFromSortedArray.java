import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 26. Remove Duplicates From Sorted Array
 *
 * Esse problema é muito mal explicado, mas enfim kkkkk
 * @author b4yerl
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * Tendo em mente que devemos tanto retornar a quantidade de elementos distintos, quanto modificar o input colocando
     * esses elementos ordenados no início do array, aqui o que fazemos é iterar pelo input enquanto contamos os elementos únicos
     * e alteramos as posições.
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int counter = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[counter]) {
                counter++;
                nums[counter] = nums[i];
            }
        }
        return counter;
    }

    /**
     * Para esta solução utilizamos o princípio básico do Set, ser uma lista de elementos distintos, com LinkedHashSet,
     * garantimos a ordem de inserção que posteriormente será utilizada para modificar o array de entrada.
     *
     * @param nums
     * @return
     */
    public static int removeDuplicatesUsingSet(int[] nums) {
        Set<Integer> numsSet = new LinkedHashSet<>();
        for(int n : nums) numsSet.add(n);

        int i = 0;
        for(Integer n : numsSet) nums[i++] = n;
        return i;
    }
}
