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

    /**
     * Default constructor
     * @param capacity
     */
    public CircularArrayFIFOQueue(int capacity) {
        super(capacity);
        clear();
    }

    /**
     * Adds a work object to the WorkList
     * @param work
     *            the work to add to the worklist
     */
    @Override
    public void add(E work) {
        if(isFull()) {
            throw new IllegalStateException();
        }
        array[end] = work;
        end = (end + 1) % capacity();
        size++;
    }

    /**
     * Returns the next element in the list
     * @return
     */
    @Override
    public E peek() {
        return peek(0);
    }

    /**
     * Returns the ith element in the WorkList. Due to the FIFO nature of the list it has a defined order
     * @param i
     *            the index of the element to peek at
     * @return
     */
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

    /**
     * Returns and then removes the next element in the WorkList
     * @return
     */
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

    /**
     * Replaces the ith element in the WorkList
     * @param i
     *            the index of the element to update
     * @param value
     */
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

    /**
     * returns the number of elements in the worklist
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * resets the WorkList to an empty one
     */
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
        throw new NotYetImplementedException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (!(obj instanceof FixedSizeFIFOWorkList<?>)) {
            return false;
        }
        else {
            FixedSizeFIFOWorkList<E> other = (FixedSizeFIFOWorkList<E>) obj;

//            if (size() != other.size()) {
//                return false;
//            }
//            for (int i = 0; i < size(); i++) {
//                if(!peek(i).equals(other.peek(i))) {
//                    return false;
//                }
//            }
            throw new NotYetImplementedException();
        }
        //return true;
    }


    @Override
    public int hashCode() {
//        int code = 37;
//        int i = 0;
//        for (E count : this) {
//            code += count.hashCode() * Math.pow(31, i);
//            i++;
//        }
//        return code;
        throw new NotYetImplementedException();
    }
}
