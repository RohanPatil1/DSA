import java.util.*;

public class MaxSubArray {
    


    //Brute Force O(n^2)
    public static int getMaxSubArray(int[] arr){
        int n= arr.length;
        int currMax =0;
        for(int i =0;i<n;i++){
           int sum= arr[i];
            int j=i+1;
            while(j<n){
                sum += arr[j];
                if(sum>currMax){
                    currMax = sum;
                }
                j++;
            }
        }
        return currMax;
    }


    //Kadane Algo O(n)
    //If including a any number gives a negative sum, skip that and start again from next index
    public static int getMaxSubArrayOp(int arr[]){
        int currMax =0;

        int n = arr.length;
        int currSum =0;
        for(int i=0;i<n;i++){
            currSum += arr[i];
            if(currSum>currMax){
                currMax = currSum;
            }
            if(currSum<0){
                currSum =0;
            }
        }

        return currMax;
    }


    public static int getMaxSubArrayGOG(int arr[]){
        int currMax =0;
        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int currSum =0;
        int start = 0;
        for(int i=0;i<n;i++){
            currSum += arr[i];
            if(currSum>currMax){
                result.clear();
                start = i;
                currMax = currSum;
                System.out.println("i: "+i+" Start:"+start);
            }
            if(currSum<0){
                currSum =0;
                start =i+1;
            }
        
        }

        return currMax;
    }


    //All Negative Elements
    public static int getMaxSubArrayAllNeg(int arr[]){
        int currMax =arr[0];
        int n = arr.length;
        int currSum =arr[0];

        for(int i=1;i<n;i++){
         
            currSum = Math.max(arr[i],currSum+arr[i]);
            currMax = Math.max(currMax,currSum);
        }

        return currMax;
    }

    public static void main(String[] args){
        int[] arr =new int[]{-5,4,6,-3,4,-1};
        int[] arr1 =new int[]{-5,-4,-6,-3,-4,-1};

       // int res = getMaxSubArray(arr);
       // int res1 = getMaxSubArrayOp(arr);
       // int res2 = getMaxSubArrayAllNeg(arr1);
       int res3 = getMaxSubArrayGOG(arr);

        // System.out.println(res);
        // System.out.println(res1);
        // System.out.println(res2);
        System.out.println(res3);

    }
}
