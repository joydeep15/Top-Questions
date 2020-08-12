import linkedList.*;
import stack.LRUCache;
import stack.MinStack;
import utilities.DLNode;
import utilities.DoublyLinkedList;

import java.io.*;
import java.util.List;

public class Runner {

    private static List<String> run;
    public static void main(String[] args) throws Exception {

        LRUCache lruCache = new LRUCache(4);
        LRUCache.set(1, 11);
        LRUCache.set(2, 22);
        LRUCache.set(3, 33);
        LRUCache.set(4, 44);

        System.out.println(LRUCache.printCache());

        LRUCache.get(2);

        System.out.println(LRUCache.printCache());

        LRUCache.set(5,55);
        LRUCache.set(6,66);
        LRUCache.set(7,77);

        System.out.println(LRUCache.get(5));
        System.out.println(LRUCache.get(7));
        System.out.println(LRUCache.printCache());



    }

}
