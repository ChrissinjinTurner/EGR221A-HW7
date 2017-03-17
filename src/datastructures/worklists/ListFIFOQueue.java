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

    @Override
    public E peek() {
        if (!hasWork()) {
            throw new NoSuchElementException();
        }
        return front.data;
    }

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

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.front = null;
        this.current = front;
        this.size = 0;
    }

    private static class LinkedNode<E> {
        public E data;
        public LinkedNode next;

        public LinkedNode(E data) {
            this.data = data;
        }
    }
}
