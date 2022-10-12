import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

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
