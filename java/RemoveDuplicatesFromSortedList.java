/**
 * 83. Remove Duplicates From Sorted List
 *
 * @author b4yerl
 */
public class RemoveDuplicatesFromSortedList {
    /**
     * Nessa primeira solução optei por fazer apenas um loop simples pela lista e assim remover os elementos duplicados.
     * O problema é que esse algoritmo performou mal no uso de memória, então resolvi ir pra algo recursivo depois.
     *
     * @param head Primeiro nó da lista
     * @return Primeiro nó da lista atualizada
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode currentNode = head;
        if(currentNode == null) return currentNode;
        while(currentNode.next != null) {
            // Caso o valor do nó atual seja igual ao do próximo, alteramos o ponteiro de next, eliminando o nó duplicado
            if(currentNode.val == currentNode.next.val) currentNode.next = currentNode.next.next;
            // Se não o loop segue bunitin
            else currentNode = currentNode.next;
        }
        return head;
    }

    /**
     *  Essa solução recursiva acaba sendo mais concisa e performou melhor que a anterior no uso de memória.
     *
     * @param head Primeiro nó da lista
     * @return Primeiro nó da lista atualizada
     */
    public static ListNode deleteDuplicatesRecursively(ListNode head) {
        if(head == null) return null;
        // Caso cheguemos ao fim da lista, não há mais o que comparar, retornamos o próprio elemento
        if(head.next == null) return head;
        // A recursividade acontece aqui na definição do next
        head.next = deleteDuplicatesRecursively(head.next);
        // Caso o nó da iteração atual tenha o mesmo valor do próximo, podemos eliminá-lo retornando o nó seguinte
        // e perdendo a referência para o nó atual... RIP
        return head.val == head.next.val ? head.next : head;
    }
}
