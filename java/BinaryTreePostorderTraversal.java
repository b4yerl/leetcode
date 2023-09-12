import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * @author b4yerl
 */
public class BinaryTreePostorderTraversal {
    /**
     * Existem 3 maneiras de se percorrer uma árvore binária.
     * Fazer isso "em ordem" implica sempre buscar o elemento mais "à esquerda" da árvore, "descer" para "a esquerda" e
     * após isso, aí sim, olharmos para a raiz.
     *
     * @param root Raíz da árvore binária
     * @return Lista dos nós em ordem.
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        // Condição de parada do algoritmo recursivo, impede aqui um NullPointerException
        if(root == null) return output;
        output.addAll(postorderTraversal(root.left));
        output.addAll(postorderTraversal(root.right));
        output.add(root.val);
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