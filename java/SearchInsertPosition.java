/**
 * 35. Search Insert Postion
 *
 * @author b4yerl
 */
public class SearchInsertPosition {
    /**
     * Aqui pede-se basicamente para implementar uma busca binária, já que querem uma busca em um array ordenado com O(log n).
     *
     * @param nums Array que receberá o alvo
     * @param target Alvo a ser inserido no array nums
     * @return Index no qual o target será inserido
     */
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;
            // Essa condição maior que o normal é pra cobrir alguns casos, já que os números podem se repetir e devemos retornar o menor index
            // Ex: nums = [1,2,3,3,3,4,5]; target = 3; tem que retornar 2 e não 3
            // Já a checagem de mid == 0 serve pra casos como nums = [1,1,1]; target = 1; não buscarem no nums[-1]
            if(nums[mid] == target && (mid == 0 || nums[mid - 1] != target)) return mid;
            if(nums[mid] >= target) end = mid - 1;
            else start = mid + 1;
        }
        return start;
    }
}
