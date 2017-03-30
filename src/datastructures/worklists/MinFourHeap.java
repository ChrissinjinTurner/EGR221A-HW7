package datastructures.worklists;

import egr221a.interfaces.worklists.PriorityWorkList;
import egr221a.exceptions.NotYetImplementedException;

import java.util.NoSuchElementException;

/**
 * See egr221a/interfaces/worklists/PriorityWorkList.java
 * for method specifications.
 */
public class MinFourHeap<E extends Comparable<E>> extends PriorityWorkList<E> {
    /* Do not change the name of this field; the tests rely on it to work correctly. */
    private E[] data;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAP = 256;
    private static final int HEAP_SIZE = 4;

    public MinFourHeap() {
        data = (E[]) new Comparable[DEFAULT_CAP];
        capacity = DEFAULT_CAP;
        ;
    }

    @Override
    public boolean hasWork() {
        return size != 0;
    }

    @Override
    public void add(E work) {
        if (size + 1 == capacity) {
            addHelper();
        }
        data[size] = work;
        size++;
        int childIndex = size - 1;
        int parentIndex = (int) Math.floor((childIndex - 1) / 4);
        while (childIndex > 0) {
            if (data[childIndex].compareTo(data[parentIndex]) >= 0) {
                break;
            }
            E temp = data[parentIndex];
            data[parentIndex] = data[childIndex];
            data[childIndex] = temp;
            childIndex = parentIndex;
            parentIndex = (int) Math.floor((childIndex - 1) / 4);
        }
    }
    private void addHelper() {
        int newCapacity = capacity * 2;
        E[] newArray = (E[]) new Comparable[newCapacity];
        for (int i = 0; i < size(); i++) {
            newArray[i] = data[i];
        }
        data = newArray;
        capacity = newCapacity;
    }

    @Override
    public E peek(){
    verifyNext();
    	return data[0];
    }

    private void verifyNext() {
        if (!hasWork()) {
            throw new NoSuchElementException();
        }
    }

        @Override
        public E next() {
            verifyNext();
            E removed = data[0];
            data[0] = data[size - 1];
            size--;
            int parentIndex = 0;

            int[] children = new int[4];
            for (int i = 0; i < 4; i++) {
                children[i] = 4 * parentIndex + i + 1;
            }

            int minIndex = children[0];
            while (children[0] < size) {
                int test = size() - children[0];
                for (int i = 0; i < Math.min(HEAP_SIZE, size() - children[0]); i++) {
                    if (data[minIndex].compareTo(data[children[i]]) > 0) {
                        minIndex = children[i];
                    }
                }
                if (data[parentIndex].compareTo(data[minIndex]) <= 0) {
                    break;
                }
                E temp = data[parentIndex];
                data[parentIndex] = data[minIndex];
                data[minIndex] = temp;
                parentIndex = minIndex;
                for (int i = 0; i < 4; i++) {
                    children[i] = 4 * parentIndex + i + 1;
                }
                minIndex = children[0];
            }
            return removed;
        }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        size = 0;
    }
}
