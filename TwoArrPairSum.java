import java.util.*;
public class TwoArrPairSum {
    


  public  static int getPairsCount(int[] arr,int n, int sum)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
 
        for (int i = 0; i < n; i++) {
 
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);
 
            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int twice_count = 0;
 
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null)
                twice_count += hm.get(sum - arr[i]);
 
            if (sum - arr[i] == arr[i])
                twice_count--;
        }
 
        return twice_count / 2;
    }

    public  static int sumPair(int N,int M,int[] A,int[] B){

        int ans = 0;

        for(int x:A){
            ans += getPairsCount(B,M,x);
        }

        return ans;


    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6};
        int[] b = new int[]{1,2,3,10};
        System.out.println(sumPair( a.length, b.length,a,b));
    }

}
