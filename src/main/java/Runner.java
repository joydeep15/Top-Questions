import linkedList.*;

import java.io.*;
import java.util.List;

public class Runner {

    private static List<String> run;
    public static void main(String[] args) throws IOException {

        Node n = Node.createLinkedList(9,9,9);
        Node m = Node.createLinkedList(9,9,9);
        n =AddNumbers.addLists(n, m);
        Node.printNodes(n);
    }

}
