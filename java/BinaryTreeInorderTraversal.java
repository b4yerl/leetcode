import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 *
 * @author b4yerl
 */
public class BinaryTreeInorderTraversal {
    /**
     * Existem 3 maneiras de se percorrer uma árvore binária.
     * Fazer isso "em ordem" implica sempre buscar o elemento mais "à esquerda" da árvore, para então visitarmos a raíz e
     * após isso "descer" para "a direita".
     *
     * @param root Raíz da árvore binária
     * @return Lista dos nós em ordem.
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        // Condição de parada do algoritmo recursivo, impede aqui um NullPointerException
        if(root == null) return output;
        output.addAll(inorderTraversal(root.left));
        output.add(root.val);
        output.addAll(inorderTraversal(root.right));
        return output;
    }
}

// Definição do TreeNode utilizado no problema
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode() {}
  TreeNode(int val) { this.val = val; }
  TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
  }
}
