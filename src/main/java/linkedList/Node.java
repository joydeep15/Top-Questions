package linkedList;

import java.util.List;
import java.util.Objects;

public class Node {
    int data;
    Node next;
    Node bottom;
    Node(int d)  { data = d;  next = null; bottom = null; }

    @Override
    public boolean equals(Object o) {
        return this == o;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, next);
    }

    @Override
    public String toString() {
        return data + " -> " + next;
    }
}