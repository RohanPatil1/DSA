public class WordSearch {
    static boolean[][] visited;

    public static boolean findWordExist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, int index, String word) {
        if (index == word.length()) {
            return true;
        }

        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }

        visited[i][j] = true;

        if (
                dfs(board, i - 1, j, index + 1, word) ||
                        dfs(board, i + 1, j, index + 1, word) ||
                        dfs(board, i, j + 1, index + 1, word) ||
                        dfs(board, i, j - 1, index + 1, word)
        ) {
            return true;
        }


        visited[i][j] = false;
        return false;
    }


}
