import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet();

        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                char curr = board[i][j];

                if(curr != '.'){

                    if(
                            !set.add(curr + "found in row "+i) ||
                                    !set.add(curr + "found in col "+j) ||
                                    !set.add(curr + "found in box "+i/3+" - "+j/3)
                    ) return false;
                }

            }
        }


        return true;

    }

}
