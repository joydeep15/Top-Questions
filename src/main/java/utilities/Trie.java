package utilities;

public class Trie {
    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insertWord(String s) {

        TrieNode parent = root;
        for (int i = 0; i < s.length(); i++) {

            Character ch = s.charAt(i);
            parent.insertNode(ch);
            parent = parent.getNextNode(ch);

            if (i == s.length() - 1) {
                parent.setTerminating(parent.getTerminating() + 1);
            }
        }
    }

    public boolean searchWord(String s) {

        TrieNode parent = root;
        for (int i = 0; i < s.length(); i++) {

            Character ch = s.charAt(i);
            parent = parent.getNextNode(ch);
            if (parent == null) {
                break;
            }

            if (i == s.length() - 1) {
                if (parent.getTerminating() > 0) {
                    return true;
                }
            }
        }

        return false;
    }

    public TrieNode getRoot() {
        return root;
    }

}
