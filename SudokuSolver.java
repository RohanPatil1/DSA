import java.util.*;

public class SudokuSolver {

    public static  boolean isSafe(char[][] board,int row,int col,int number){
        //row and column
        for(int  i=0;i<board.length;i++){
            if(board[i][col] == (char)(number+'0')){
                return false;
            }
            if(board[row][i] == (char)(number+'0')){
                return false;
            }
        }


        //Grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;

        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j] == (char)(number+'0')){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean helper(char[][] board, int row, int column) {

        if(row == board.length){
             return true;
        }
    
        int nRow = 0;
        int nCol = 0;

        // Not reached last column, increment column
        if (column != board.length - 1) {
            nRow = row;
            nCol = column + 1;
        } else {
            // Reached last column, move to next row
            nRow = row + 1;
            nCol = 0;
        }


        if(board[row][column] != '.'){
            if(helper(board,nRow,nCol)){
                //We got solution
                return true;
            }
        }else{
            //No number assigned, so assign!
            for(int i=1;i<=9;i++){
                if(isSafe(board,row,column,i)){
                    board[row][column] =(char)(i+'0');
                    //Callagain
                    if(helper(board,nRow,nCol)){
                         return true;
                     }else{
                         board[row][column] ='.';
                     }
                }

            }
        }

        return false;
    }

    public static void solveSudoku(char[][] board) {
        helper(board, 0, 0);

    }

    public static void main(String[] args) {

    }
}
