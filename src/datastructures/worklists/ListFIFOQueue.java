package datastructures.worklists;

import egr221a.interfaces.worklists.FIFOWorkList;

import java.util.NoSuchElementException;

/**
 * See egr221a/interfaces/worklists/FIFOWorkList.java
 * for method specifications.
 */
public class ListFIFOQueue<E> extends FIFOWorkList<E> {
    private LinkedNode<E> front;
    private LinkedNode<E> current;
    private int size;
    
    public ListFIFOQueue() {
        this.front = null;
        this.current = null;
        this.size = 0;
    }

    /**
     * Adds a new data object to the list
     * @param data
     */
    @Override
    public void add(E data) {
        if (front == null) {
            front = new LinkedNode<E>(data);
            current = front;
        } else {
            current.next = new LinkedNode(data);
            current = current.next;
        }
        size++;
    }

    /**
     * Returns the next element in the list
     * @return
     */
    @Override
    public E peek() {
        if (!hasWork()) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

    /**
     * Returns and then removes the next element
     * @return
     */
    @Override
    public E next() {
        if (!hasWork()) {
            throw new NoSuchElementException();
        }
        E temp = front.data;
        front = front.next;
        this.size--;
        return temp;
    }

    /**
     * Returns the number of elements in the list
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Removes all elements from the list returning it to its original state
     */
    @Override
    public void clear() {
        this.front = null;
        this.current = front;
        this.size = 0;
    }

    /**
     * Declaration of our LinkedNode
     * @param <E>
     */
    private static class LinkedNode<E> {
        public E data;
        public LinkedNode next;

        public LinkedNode(E data) {
            this.data = data;
        }
    }
}
