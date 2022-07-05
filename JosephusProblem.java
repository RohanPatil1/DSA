import java.util.*;

public class JosephusProblem {

    //Follows 0-based indexing
    int josephusA2Helper(int n,int k ){
        if(n==1) return 0;


        int ans = josephusA2(n-1,k);

        return (ans+k)&n;

    }
    int josephusA2(int n,int k){
        //Ans should be 1-base indexing
        int ans = josephusA2Helper(n,k);
        return ans+1;
    }

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
