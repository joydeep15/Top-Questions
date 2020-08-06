import linkedList.*;

import java.io.*;
import java.util.List;

public class Runner {

    private static List<String> run;
    public static void main(String[] args) throws IOException {

        Node n = Node.createLinkedList(2,1,0,2,2,1,2,1,1,0,0,0);
        n = Sort012.segregate(n);
        Node.printNodes(n);
    }

}
