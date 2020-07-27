package linkedList;

import java.util.Objects;

public class Node {
    int data;
    Node next;
    Node(int d)  { data = d;  next = null; }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }
}