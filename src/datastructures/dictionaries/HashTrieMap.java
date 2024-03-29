package datastructures.dictionaries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import egr221a.exceptions.NotYetImplementedException;
import egr221a.interfaces.trie.BString;
import egr221a.interfaces.trie.TrieMap;

/**
 * See egr221a/interfaces/trie/TrieMap.java
 * and egr221a/interfaces/misc/Dictionary.java
 * for method specifications.
 */
public class HashTrieMap<A extends Comparable<A>, K extends BString<A>, V> extends TrieMap<A, K, V> {
    /**
     * Our beautiful node declaration
     */
    public class HashTrieNode extends TrieNode<Map<A, HashTrieNode>, HashTrieNode> {
        /**
         * default
         */
        public HashTrieNode() {
            this(null);
        }

        /**
         * given a value
         * @param value
         */
        public HashTrieNode(V value) {
            this.pointers = new HashMap<A, HashTrieNode>();
            this.value = value;
        }

        @Override
        public Iterator<Entry<A, HashTrieNode>> iterator() {
            return pointers.entrySet().iterator();
        }
    }

    /**
     * default constructor
     * @param KClass
     */
    public HashTrieMap(Class<K> KClass) {
        super(KClass);
        this.root = new HashTrieNode();
    }

    /**
     * Inserts a new value into the map given its key as well
     * @param key
     *            key with which the specified value is to be associated
     * @param value
     *            value to be associated with the specified key
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public V insert(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }
        HashTrieNode current = (HashTrieNode) this.root;
        for (A index : key) {
            if (current.pointers.get(index) == null) {
                current.pointers.put(index, new HashTrieNode());
            }
            current = current.pointers.get(index);
        }
        V val = current.value;
        current.value = value;
        if (val == null) {
            this.size++;
        }
        return val;
    }

    /**
     * Returns the value given its key
     * @param key
     *            the key whose associated value is to be returned
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public V find(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        HashTrieNode current = (HashTrieNode) this.root;
        for (A index : key) {
            current = current.pointers.get(index);
            if (current == null) {
                return null;
            }
        }
        return current.value;
    }

    /**
     * Checks to see if node is empty
     * @param key
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean findPrefix(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        HashTrieNode current = (HashTrieNode) this.root;
        for (A index : key) {
            current = current.pointers.get(index);
            if (current == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Removes the value given the key
     * @param key
     *            key whose mapping is to be removed from the map
     */
    @Override
    @SuppressWarnings("unchecked")
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        boolean accepted = true;
        HashTrieNode current = (HashTrieNode) this.root;
        if (key.isEmpty()) {
            if (current.value != null) {
                current.value = null;
                size--;
            }
        } else {
            HashTrieNode val = (HashTrieNode) this.root;
            Iterator<A> counter = key.iterator();
            A nextNode = (A) counter.next();
            for (A index : key) {
                if (current.pointers.get(index) != null) {
                    if (current.pointers.size() >= 2 || current.value != null) {
                        val = current;
                        nextNode = index;
                    }
                    current = current.pointers.get(index);
                } else {
                    accepted = false;
                    break;
                }
            }
            if (accepted) {
                val.pointers.remove(nextNode);
                size--;
            } else {
                if (current.value != null) {
                    current.value = null;
                    size--;
                }
            }
        }

    }

    /**
     * Resets its back to its original state
     */
    @Override
    public void clear() {
        this.root = new HashTrieNode();
    }
}
