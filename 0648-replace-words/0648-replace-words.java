import java.util.List;
import java.util.Arrays;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trie = new TrieNode();
        // Build the Trie
        for (String root : dictionary) {
            TrieNode current = trie;
            for (char letter : root.toCharArray()) {
                if (current.children[letter - 'a'] == null) {
                    current.children[letter - 'a'] = new TrieNode();
                }
                current = current.children[letter - 'a'];
            }
            current.isWord = true;
        }
        
        // Split the sentence into words
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        
        // Process each word
        for (String word : words) {
            TrieNode current = trie;
            StringBuilder replacement = new StringBuilder();
            for (char letter : word.toCharArray()) {
                if (current.children[letter - 'a'] == null || current.isWord) {
                    break;
                }
                replacement.append(letter);
                current = current.children[letter - 'a'];
            }
            if (current.isWord) {
                result.append(replacement);
            } else {
                result.append(word);
            }
            result.append(" ");
        }
        
        // Remove the trailing space
        return result.toString().trim();
    }
    
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }
}
