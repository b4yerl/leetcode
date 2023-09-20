import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 217. Contains Duplicate
 *
 * @author b4yerl
 */
public class ContainsDuplicate {
    /**
     * Para confirmar a existência de duplicatas, utilizei inicialmente um Map e simplesmente um for loop
     *
     * @param nums Input
     * @return {@code true} se houver algum elemento duplicado, senão {@code false}
     */
    public static boolean hasDuplicates(int[] nums) {
        Map<Integer, Boolean> numsMap = new HashMap<>();
        for(int n : nums) {
            if(numsMap.containsKey(n)) return true;
            numsMap.put(n, true);
        }
        return false;
    }

    /**
     * Aqui a única diferença é o uso do Set, mas por baixo tá rolando o mesmo já que implementei um HashSet.
     * Note que como Set.add() retorna um booleano que informa do sucesso da inserção utilizei isso no if
     *
     * @param nums Input
     * @return {@code true} se houver algum elemento duplicado, senão {@code false}
     */
    public static boolean hasDuplicatesUsingSet(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for(int n : nums) if(!numsSet.add(n)) return true;
        return false;
    }
}
