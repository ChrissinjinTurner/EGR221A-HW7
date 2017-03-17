package datastructures.worklists;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.worklists.LIFOWorkList;

import java.util.NoSuchElementException;

/**
 * See egr221a/interfaces/worklists/LIFOWorkList.java
 * for method specifications.
 */
public class ArrayStack<E> extends LIFOWorkList<E> {
    private E[] array;
    private static final int DEFAULT_SIZE = 10;
    private int index;

    public ArrayStack() {
        clear();
    }

    @Override
    public void add(E work) {
        if (index >= array.length) {
            @SuppressWarnings("unchecked")
            E[] largeArray = (E[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                largeArray[i] = array[i];
            }
            array = largeArray;
        }
        array[index] = work;
        index++;
    }

    @Override
    public E peek() {
        if (!hasWork()) {
            throw new NoSuchElementException();
        }
        return array[index - 1];
    }

    @Override
    public E next() {
        if (!hasWork()) {
            throw new NoSuchElementException();
        }
        E temp = array[index - 1];
        array[index - 1] = null;
        index--;
        return temp;
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        E[] newArray = (E[])new Object[DEFAULT_SIZE];
        array = newArray;
        index = 0;
    }
}
