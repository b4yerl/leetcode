/**
 * 203. Remove Linked List Element
 *
 * @author b4yerl
 */
public class RemoveLinkedListElement {
    /**
     * Para esse problema optei por uma solução recursiva. Muito provavelmente da pra fazer ela bem concisa com
     * poucas linhas, essa era a ideia, mas tive dificuldade com NullPointerException, logo optei por ter uma função
     * auxiliar que utilizasse uma referência ao nó anterior.
     *
     * @param head Primeiro nó da lista
     * @param val Valor dos nós que serão removidos
     * @return Primeiro nó da lista atualizada
     */
    public static ListNode removeElements(ListNode head, int val) {
        if(head == null) return head;
        if(head.val == val) head = head.next;
        recursiveRemoval(head, head.next, val);
        return head;
    }
    private static void recursiveRemoval(ListNode previous, ListNode current, int val) {
        if(current == null) return;
        if(current.val == val) {
            previous.next = current.next;
            recursiveRemoval(previous, previous.next, val);
        }
        else recursiveRemoval(current, current.next, val);
        return;
    }
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
