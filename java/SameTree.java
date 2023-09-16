/**
 * 100. Same Tree
 *
 * @author b4yerl
 */
public class SameTree {
    /**
     * Isso aqui acabou sendo parecido com um preorder traversal, a diferença é que ocorre em duas árvores ao mesmo tempo.
     * @param p Raíz da árvore 1
     * @param q Raíz da árvore 2
     * @return {@code true} caso as árvores sejam iguais, senão {@code false}
     */
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        // Caso cheguemos ao final de um caminho com as duas ok, retornamos true para a próxima call
        if(p == null && q == null) return true;
        // Se apenas 1 árvore chegar no null, retorna logo o false até pra não tomar NullPointerException
        if(p == null || q == null) return false;
        // Enfim confere os valores de cada nó
        if(p.val != q.val) return false;

        // Aqui retornamos a conjução entre os caminhos da esquerda e os da direita
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
