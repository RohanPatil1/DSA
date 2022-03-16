import java.util.*;

public class BuySellStock {

    //Brute Force O(n^2)
    public static int buySellStock1(int[] arr) {
        int profit = 0;
        for (int i = 0; i < arr.length; i++) {
            int currStock = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                profit = Math.max(profit, arr[j] - currStock);
            }
        }
        return profit;
    }

    //O(n) space O(n)
    public static int buySellStock2(int[] arr){
        int profit = 0;
        int size = arr.length;
        int[] aux = new int[size];

        //Fill Aux Arr
        int currMax=0;
        for(int i=size-1;i>=0;i--){
            currMax = Math.max(currMax,arr[i]);
            aux[i] = currMax;
        }

        //Compare the currStock with its maxStock
        for(int i=0;i<size;i++){
            profit = Math.max(profit,aux[i]-arr[i]);
        }

        return profit;
    }


    //O(n) space O(1)
    public static int buySellStock3(int[] arr){
        int profit = 0;

        int min=arr[0];
        for(int i=0;i<arr.length;i++){
            min = Math.min(min,arr[i]);
            System.out.print("MinSoFar :"+min+" For i:"+i);
            profit = Math.max(profit,arr[i]-min);
            System.out.print(" Profit:"+profit);

            System.out.println();
        }
        return profit;
    }

    public static void main(String[] args) {

        int[] arr = { 3, 1, 4, 8, 7, 2, 5 };
        int maxProfit = buySellStock1(arr);
        int maxProfit2 = buySellStock2(arr);
        int maxProfit3 = buySellStock3(arr);
        System.out.println(maxProfit);
        System.out.println(maxProfit2);
        System.out.println(maxProfit3);

    }
}
