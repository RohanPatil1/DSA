import java.util.*;

public class JosephusProblem {
    static int safePos(int n, int k) {
        // code here
        k--;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i<= n; i++){
            arr.add(i);
        }
        int index = 0;
        solve(index, k, arr);
        return arr.get(0);
    }
    
    static void solve(int index, int k, ArrayList<Integer> arr){
        if(arr.size() == 1){
            return;
        }
        index = (index + k) % arr.size();
        arr.remove(index);
        solve(index, k, arr);
    }
    public static void main(String[] args) {
        System.out.println(safePos(4,2));
    }
}
