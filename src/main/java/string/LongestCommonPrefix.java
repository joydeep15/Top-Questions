package string;

import utilities.Trie;
import utilities.TrieNode;

import java.util.Map;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] words = {"geeksforgeeks", "geeks", "geek",  "geezer"};
        System.out.println(getLongestCommonPrefix(words));
    }
    public static String getLongestCommonPrefix(String[] words) {

        Trie trie = new Trie();
        for (String word : words) {
            trie.insertWord(word);
        }

        StringBuilder sb = new StringBuilder();
        TrieNode iterator = trie.getRoot();
        while (iterator!=null && iterator.getNodes().size() == 1 && iterator.getTerminating() ==0) {

            for (Map.Entry<Character, TrieNode> entry : iterator.getNodes().entrySet()) {
                sb.append(entry.getKey());
                iterator = entry.getValue();
            }

        }

        return sb.toString();

    }
}
