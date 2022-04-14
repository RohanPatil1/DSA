import java.util.*;

public class CountSubsetWithSum {

    // just initaite j =0 while filling remaining cells instead of initialising it
    // with 1

    // int dp[n+1][sum+1];
    // int mod= (int) (pow(10,9)+7);

    // for(int i=0;i<=n;i++){
    // for(int j=0;j<=sum;j++){
    // if(i==0){
    // dp[i][j]= 0;
    // }
    // if(j==0){
    // dp[i][j]= 1;
    // }
    // }
    // }

    // for(int i=1;i<=n;i++){
    // for(int j=0;j<=sum;j++){ //initaite j with 0

    // if(arr[i-1]>j){
    // dp[i][j]=(dp[i-1][j]%mod);
    // }
    // else{
    // dp[i][j]=( (dp[i-1][j]%mod )+ (dp[i-1][j-arr[i-1]]%mod) )%mod;
    // }
    // }
    // }

    // return dp[n][sum]%mod;

    public static int countSubset(int[] arr, int s) {

        int n = arr.length;
        System.out.println("S1: " + s);
        int[][] t = new int[n + 1][s + 1];

        // Init matrix
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < s + 1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        // Fill the rest
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < s + 1; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];

                } else if (arr[i - 1] > j) {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        // for (int i = 1; i < n + 1; i++) {
        // for (int j = 1; j < s + 1; j++) {
        // System.out.println(t[i][j]);
        // }
        // System.out.println();

        // }

        return t[n][s];
    }

    public static void main(String[] args) {
        System.out.println(countSubset(new int[] { 2, 3, 5, 6, 8, 10 }, 10));

    }
}
