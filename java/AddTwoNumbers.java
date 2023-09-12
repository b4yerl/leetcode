/**
 * 2. Add Two Numbers
 *
 * @author b4yerl
 */
public class AddTwoNumbers {
    /**
     * Optei por resolver esse problema sem converter as listas para um número em si, a ideia foi representar uma conta de
     * adição feita no papel, então temos os termos da soma, além de uma variável que carrega valores excedentes para frente.
     *
     * @param l1 Primeiro nó da lista 1
     * @param l2 Primeiro nó da lista 2
     * @return Primeiro nó da lista de soma entre os inputs
     */
    public static ListNode add(ListNode l1, ListNode l2) {
        ListNode output = new ListNode();

        ListNode nextA = l1;
        ListNode nextB = l2;
        ListNode nextOutput = output;

        int carry = 0;

        // A condição aqui é satisfeita com as 2 listas tendo sido zeradas e não havendo mais nenhuma sobra
        while(nextA != null || nextB != null || carry != 0) {
            // Iniciamos a soma atual com o valor vindo de operações anteriores
            int sum = carry;
            // Caso já tenhamos atingido o fim das listas basta finalizar a operação com o excedente restante
            if(nextA != null) {
                sum += nextA.val;
                nextA = nextA.next;
            }
            if(nextB != null) {
                sum += nextB.val;
                nextB = nextB.next;
            }
            // Caso o dígito ultrapasse 9, a parte da dezena segue para a próxima operação, restando apenas a unidade
            if(sum > 9) {
                carry = sum / 10;
                sum = sum % 10;

            }
            else carry = 0;

            nextOutput.val = sum;
            // Coloquei essa condição aqui igual ao do loop, porque eu acabava a operação com um nó a mais sempre, deve
            // ter jeito melhor de resolver isso :P
            if(nextA != null || nextB != null || carry != 0) {
                ListNode newNode = new ListNode();
                nextOutput.next = newNode;
                nextOutput = newNode;
            }
        }
        return output;
    }
}

// Definição de ListNode dada pela questão
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

