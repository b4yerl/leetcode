import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 *
 * @author b4yerl
 */
public class BinaryTreePreorderTraversal {
    /**
     * Existem 3 maneiras de se percorrer uma árvore binária.
     * Fazer isso "pré ordem" implica sempre visitar a raíz para então buscar o elemento mais "à esquerda" da árvore e
     * após isso "descer" para "a direita".
     *
     * @param root Raíz da árvore binária
     * @return Lista dos nós em pré ordem.
     */
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        // Condição de parada do algoritmo recursivo, impede aqui um NullPointerException
        if(root == null) return output;
        output.add(root.val);
        output.addAll(preorderTraversal(root.left));
        output.addAll(preorderTraversal(root.right));
        return output;
    }
}

// Definição do TreeNode utilizado no problema
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//    TreeNode() {}
//    TreeNode(int val) { this.val = val; }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}