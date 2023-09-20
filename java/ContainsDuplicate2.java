import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 *
 * @author b4yerl
 */
public class ContainsDuplicate2 {
    public static boolean hasDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(numsMap.containsKey(nums[i])) {
                int value = numsMap.get(nums[i]);
                if(Math.abs(numsMap.get(nums[i]) - i) <= k) return true;
            }
            numsMap.put(nums[i], i);
        }
        return false;
    }
}
