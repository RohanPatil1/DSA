import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {
    /*
    let:
N = num of rows
M = num of columns
X = number of words in dictionary
Y = length of the longest word in dictionary

Time complexity of using a set instead of a trie tree

We are doing a 4-child DFS traversal of depth N*M (worst case is traversing entire board). -> 4^(NM)
We are doing this N*M times since we need to check for words starting at each position in the board
-> O(4^(NM)*NM)
Time complexity of using the trie tree

We are doing a 4-child DFS traversal.
The worst case depth in this case is the minimum of [traversing the entire board, traversing until we hit the end of a word].
-> O of each traversal is4^(min(Y, NM))
Note: min accounts for the case where we have words in the dictionary longer than the number of characters in the board itself.
We are doing this N*M times since we need to check for words starting at each position in the board
-> O(4^(min(Y, NM))*NM)

https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
     */

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;

        public TrieNode() {
        }

    }

    boolean[][] visited;

    TrieNode root = new TrieNode();

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> resultSet = new HashSet<>();
        visited = new boolean[board.length][board[0].length];

        addToTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.children[board[i][j] - 'a'] != null) {
                    search(i, j, board, root, "", resultSet);
                }
            }
        }

        return new ArrayList<>(resultSet);
    }

    private void search(int i, int j, char[][] board, TrieNode node, String word, Set<String> resultSet) {
        if (i >= board.length || j >= board[0].length || i < 0 || j < 0 || visited[i][j] || node.children[board[i][j] - 'a'] == null) {
            return;
        }

        visited[i][j] = true;
        node = node.children[board[i][j] - 'a'];

        //is Terminating
        if (!node.isEnd) {
            resultSet.add(word + board[i][j]);
        }

        search(i + 1, j, board, node, word, resultSet);
        search(i - 1, j, board, node, word, resultSet);
        search(i, j + 1, board, node, word, resultSet);
        search(i, j - 1, board, node, word, resultSet);

        visited[i][j] = false;
    }


    private void addToTrie(String[] words) {
        for (String word : words) {
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
    }


}
