/*
    Bennet, T. (2021). CIS 505 Intermediate Java Programming. Bellevue University
*/
package Module_4;

import java.util.LinkedList;

public class GenericQueue<E> {
    
    //private global class variables
    private LinkedList<E> list = new LinkedList<E>();

    /**
     * Default Constructor
     */
    public GenericQueue() {}

    /**
     * Generic Item to queue.
     * @param item E
     */
    public void enqueue(E item) {
        list.addFirst(item);
    }

    /**
     * Dequeues the Generic item in the first position.
     * @return E toString
     */
    public E dequeue() {
        return list.removeFirst();
    }

    /**
     * Lists the Size of the GenericList
     * @return int size
     */
    public int size() {
        return list.size();
    }
}
