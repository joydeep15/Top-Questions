package utilities;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {

    private final Character name;
    private int terminating;
    private final Map<Character, TrieNode> nodes;

    public TrieNode(Character name) {
        this.name = name;
        terminating = 0;
        nodes = new HashMap<>();
    }

    public int getTerminating() {
        return terminating;
    }

    public void setTerminating(int terminating) {
        this.terminating = terminating;
    }

    public TrieNode getNextNode(Character ch) {
        if (nodes.containsKey(ch)) {
            return nodes.get(ch);
        }
        return null;
    }

    public void insertNode(Character ch) {
        if (!nodes.containsKey(ch)) {
            nodes.put(ch, new TrieNode(ch));
        }
    }

    public void removeNode(Character ch) {
        nodes.remove(ch);
    }

    public Map<Character, TrieNode> getNodes() {
        return nodes;
    }


    public Character getName() {
        return name;
    }

}
