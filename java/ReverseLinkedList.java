import java.util.Stack;

/**
 * 206. Reverse Linked List
 *
 * @author b4yerl
 */
public class ReverseLinkedList {
    /**
     * Como precisamos reverter uma lista, resolvi usar uma pilha e retornar o elemento originalmente no topo dela.
     *
     * @param head Primeiro nó da lista
     * @return Primeiro nó da lista reversa
     */
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        Stack<ListNode> nodeStack = new Stack<>();

        // Insere todos os nós da lista na nossa pilha, note que o último elemento da lista, será nosso topo, graças ao LIFO
        for(ListNode node = head; node != null; node = node.next) {
            nodeStack.push(node);
        }
        // Já reservo aqui a saída do método
        ListNode output = nodeStack.peek();

        // Enquanto houverem elementos na pilha, remove-os, alterando as referências de next
        while(!nodeStack.isEmpty()) {
            ListNode node = nodeStack.pop();
            if(nodeStack.isEmpty()) node.next = null;
            else node.next = nodeStack.peek();
        }
        return output;
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
}
