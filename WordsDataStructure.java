public class WordsDataStructure {
    class TrieNode {

        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;

        public TrieNode() {

        }

    }


    TrieNode root;

    public void WordDictionary() {
        root = new TrieNode();
    }

    /*
    Time Complexity:
addWord() - O(n), n = length of the new word
search() - Worst case: O(m), m = the total number of characters in the Trie
but for search(), although O(m) as described above is a tighter bound than O(26^n),
 because you won't always have 26 children at every trie node, it's just the absolute worste case.
     */

    public void addWord(String word) {

        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];

        }
        node.isEnd = true;

    }


    public boolean search(String word) {
        TrieNode temp = root;
        return searchHelper(word, 0, temp);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (node == null) return false;

        if (word.length() == index) return node.isEnd;

        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (searchHelper(word, index + 1, node.children[i])) return true;
            }
        } else {
            if (searchHelper(word, index + 1, node.children[c - 'a'])) return true;
        }

        return false;
    }


}
