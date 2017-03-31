package datastructures.worklists;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.worklists.FixedSizeFIFOWorkList;

import java.util.NoSuchElementException;

/**
 * See egr221a/interfaces/worklists/FixedSizeLIFOWorkList.java
 * for method specifications.
 */
public class CircularArrayFIFOQueue<E> extends FixedSizeFIFOWorkList<E> {
    private E[] array;
    private int size;
    private int front;
    private int end;

    public CircularArrayFIFOQueue(int capacity) {
        super(capacity);
        clear();
    }

    @Override
    public void add(E work) {
        if(isFull()) {
            throw new IllegalStateException();
        }
        array[end] = work;
        end = (end + 1) % capacity();
        size++;
    }


    @Override
    public E peek() {
        return peek(0);
    }
    
    @Override
    public E peek(int i) {
        if(!hasWork()) {
            throw new NoSuchElementException();
        }
        if(i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        return array[(front + i) % capacity()];
    }

    
    @Override
    public E next() {
        if(!hasWork()) {
            throw new NoSuchElementException();
        }
        E tmp = array[front];
        array[front] = null;
        size--;
        front = (front + 1) % capacity();
        return tmp;
    }
    
    @Override
    public void update(int i, E value) {
        if(!hasWork()) {
            throw new NoSuchElementException();
        }
        if(i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        array[(front + i) % capacity()] = value;
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        @SuppressWarnings("Not Checked")
        E[] newArray = (E[])new Comparable[super.capacity()];
        array = newArray;
        size = 0;
        front = 0;
        end = 0;
    }

    @Override
    public int compareTo(FixedSizeFIFOWorkList<E> other) {
        // You will implement this method in p2. Leave this method unchanged for p1.
        throw new NotYetImplementedException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        // You will finish implementing this method in p2. Leave this method unchanged for p1.
        if (this == obj) {
            return true;
        }
        else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
            return false;
        }
        else {
            FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

            if (size() != other.size()) {
                return false;
            }
            for (int i = 0; i < size(); i++) {
                if(!peek(i).equals(other.peek(i))) {
                    return false;
                }
            }
        }
        return true;
    }


    @Override
    public int hashCode() {
        int code = 37;
        int i = 0;
        for (E count : this) {
            code += count.hashCode() * Math.pow(31, i);
            i++;
        }
        return code;
    }
}
