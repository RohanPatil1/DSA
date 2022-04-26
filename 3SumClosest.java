import java.util.*;
public class 3SumClosest {
    
    public static int threeSumClosest(int[] arr,int x) {
        int n = arr.length;
        int ans = 0;
        int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){

            int k = n-1;
            int j = i+1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum == x){
                    return x;
                }else if(sum > x){
                    k--;
                }else{
                    j++;
                }

                if(Math.abs(sum - x)<minDiff){
                    minDiff = Math.abs(sum-x);
                    ans  = sum;
                }
            }



        }
        return ans;
    }


    public static void main(String[] args) {
        
    }
}
