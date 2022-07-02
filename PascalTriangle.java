import java.util.ArrayList;

public class PascalTriangle {

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

    public static void main(String[] args) {
        System.out.println(nthRowOfPascalTriangle(4).toString());
    }
}
