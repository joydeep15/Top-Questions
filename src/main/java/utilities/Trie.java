package utilities;

//TODO delete word
public class Trie {
    private final TrieNode root;

    public Trie(){
        root = new TrieNode('\0');
    }

    public void insertWord(String s) {

        TrieNode parent = root;
        for (int i = 0; i < s.length(); i++) {

            Character ch = s.charAt(i);
            parent.insertNode(ch);
            parent = parent.getNextNode(ch);

        }
        parent.setTerminating(parent.getTerminating() + 1);
    }

    public boolean searchWord(String s) {

        TrieNode parent = root;
        for (int i = 0; i < s.length(); i++) {

            Character ch = s.charAt(i);
            parent = parent.getNextNode(ch);
            if (parent == null) {
                return false;
            }
        }

        return parent.getTerminating() > 0;
    }

    public TrieNode getRoot() {
        return root;
    }

}
