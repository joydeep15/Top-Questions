package string;

import org.junit.Assert;
import org.junit.Test;
import utilities.Trie;
import utilities.TrieNode;

import java.util.Map;

public class LongestCommonPrefix {

    @Test
    public void lcpTest() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] words = {"geeksforgeeks", "geeks", "geek",  "geezer"};
        String result = "gee";
        Assert.assertEquals(result, longestCommonPrefix.getLongestCommonPrefix(words));
    }

    public String getLongestCommonPrefix(String[] words) {

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
