package trie;

import org.junit.Assert;
import org.junit.Test;
import utilities.Trie;
import utilities.TrieNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class WordSearch {

    @Test
    public void WordSearchTest(){

        WordDictionary wordDictionary = new WordDictionary();
        List<String> words = Arrays.asList("mad", "bull", "made", "maiden", "great", "pull");
        List<String> search = Arrays.asList("maiden", "m..", "poll", ".rea.", ".....", "...");
        List<Boolean> expectedResults = Arrays.asList(true, true, false, true, true, true);

        List<Boolean> actualResults = new ArrayList<>();

        words.forEach(wordDictionary::addWord);
        search.forEach( s -> actualResults.add(wordDictionary.search(s)) );
        Assert.assertEquals(expectedResults, actualResults);

    }

}

class WordDictionary{

    private final Trie trie;

    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insertWord(word);
    }

    public boolean search(String word) {
        return search(word, 0, trie.getRoot());
    }

    private boolean search(String word, int index, TrieNode node){

        if(node == null){
            return false;
        }

        if(index == word.length()){
           //last char
            return node.getTerminating() > 0;
        }

        Character current = word.charAt(index);
        if(current != '.'){
            return search(word, index+1, node.getNextNode(current));
        }

        // '.' character
        for (Map.Entry<Character, TrieNode> entry : node.getNodes().entrySet()){
                boolean status = search(word, index + 1, entry.getValue());
                if (status) {
                    return true;
                }
        }

        return false;
    }


}

