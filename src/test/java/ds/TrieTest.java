package ds;

import org.junit.Assert;
import org.junit.Test;
import utilities.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TrieTest {

    @Test
    public void wordSearchTest(){

        Trie trie = new Trie();
        List<String> words = Arrays.asList("tomato", "potato", "banana", "banjo");
        words.forEach(trie::insertWord);

        List<String> queries = Arrays.asList("banjo", "ban", "tomato", "tango");
        List<Boolean> expected = Arrays.asList(true, false, true, false);

        List<Boolean> result = new ArrayList<>();
        queries.forEach( q -> result.add(trie.searchWord(q)));

        Assert.assertEquals(expected, result);

    }
}
