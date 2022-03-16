import java.util.*;

public class RainwaterProblem {
    
    public static void printArr(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public static int getRainWater(int[] arr){
        int rain =0;
        int n=arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        //Fill the aux
        left[0] = arr[0];
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],arr[i]);
        }
        printArr(left);

        right[n-1] = arr[n-1];
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],arr[i]);
        }

        printArr(right);
        

        //Get Rain by min(left[i],right[i]) - a[i]
        for(int k=0;k<n;k++){
            rain += Math.min(left[k],right[k]) - arr[k];
        }

        return rain;

    }

    public static void main(String[] args){



        int[] arr = {3,1,2,4,0,1,3,2};
        int ans = getRainWater(arr);
        System.out.println(ans);

    }
}
