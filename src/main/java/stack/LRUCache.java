package stack;

import utilities.DLNode;
import utilities.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

class Pair<T>{
    public T key;
    public T value;

    Pair(T key, T value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}
public class LRUCache {


    static DoublyLinkedList<Pair> dll;
    static Map<Integer, DLNode<Pair>> cache;
    static int maxSize;

    public LRUCache(int cap)
    {
        dll = new DoublyLinkedList<>();
        cache = new HashMap<>();
        maxSize = cap;
    }

    // This method works in O(1)
    public static int get(int key)
    {
        if (!cache.containsKey(key)) {
            return -1;
        } else {

            dll.remove(cache.get(key));

            dll.addLast(cache.get(key));

            return (int) cache.get(key).getVal().value;
        }
    }

    // This method works in O(1)
    public static void set(int key, int value)
    {
        if (cache.containsKey(key)) {
            cache.get(key).getVal().value = value;
            get(key);
            return;
        }
        if (cache.size() >= maxSize) {
            Integer k = (Integer) dll.getHead().getVal().key;
            dll.removeFirst();
            cache.remove(k);
        }

        DLNode<Pair> node = dll.addLast(new Pair<>(key, value));
        cache.put(key, node);
    }

    public static String printCache() {
        return dll.printList();
    }

}
