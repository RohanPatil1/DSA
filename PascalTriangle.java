import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    //M2
    static ArrayList<Long> nthRowOfPascalTriangle(int n) {
        ArrayList<Long> ans = new ArrayList<Long>();
        if (n == 1) {
            ArrayList<Long> ans1 = new ArrayList<Long>();
            ans1.add(1L);
            return ans1;
        }
        ArrayList<Long> arr = nthRowOfPascalTriangle(n - 1);
        ans.add(1L);
        for (int i = 1; i < arr.size(); i++) {
            ans.add((arr.get(i) + arr.get(i - 1)) % 1000000007);
        }
        ans.add(1L);
        return ans;
    }

    //M1
    public static void printAllPascalTrow(int n) {
        ArrayList res = new ArrayList();

        List<Integer> row, pre = null;
        for (int i = 0; i <= n; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) row.add(1);
                else {
                    row.add(pre.get(j - 1) + pre.get(j));
                }
            }
            pre = row;
            res.add(row);
        }

        System.out.println(res);
    }


    //BEST
    public static List<List<Integer>> pascalTrianglePrint(int rows) {

        /*
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1
         */

        List<List<Integer>> res = new ArrayList<>();
        if (rows == 0) return res;


        //Add 1st row
        List<Integer> firstR = new ArrayList<>();
        firstR.add(1);
        res.add(firstR);

        for (int i = 1; i < rows; i++) {
            List<Integer> iRow = new ArrayList<>();
            iRow.add(1);

            for (int j = 1; j < i; j++) {
                iRow.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }


            iRow.add(1);

            res.add(iRow);
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(nthRowOfPascalTriangle(4).toString());


//        printAllPascalTrow(4);
        System.out.println(pascalTrianglePrint(4));
    }
}
