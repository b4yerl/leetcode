import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

/**
 * 225. Implement Stack using Queues
 *
 * Aula de bizarrice desnecessária, mas tá aí...
 *
 * @author b4yerl
 */
public class ImplementStackUsingQueue {
    private Queue<Integer> bizarrice;
    public ImplementStackUsingQueue() {
        this.bizarrice = new ArrayDeque<>();
    }

    public void push(int x) {
        this.bizarrice.add(x);
    }

    public int pop() {
        Iterator<Integer> iterator = this.bizarrice.iterator();
        Integer value = iterator.next();
        while(iterator.hasNext()) {
            value = iterator.next();
        }
        iterator.remove();
        return value;
    }

    public int top() {
        Iterator<Integer> iterator = this.bizarrice.iterator();
        Integer value = iterator.next();
        while(iterator.hasNext()) {
            value = iterator.next();
        }
        return value;
    }

    public boolean empty() {
        return this.bizarrice.isEmpty();
    }
}
