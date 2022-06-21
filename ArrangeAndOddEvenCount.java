import java.util.*;

public class ArrangeAndOddEvenCount {


    public static int binarySearch(Integer[] arr,int x){

        int start = 0;
        int end = arr.length-1;

        while(start<end){

            int mid = start + (end-start)/2;
            if(arr[mid]==x){
                return mid;
            }else if(arr[mid]>x){
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static int[] inTheMid(int N, int Q, int X, int[] A) {
        int[] result = new int[2];

        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = A[i];
        }

        if (Q == 1) {
            Arrays.sort(arr);
        } else {
            Arrays.sort(arr, Collections.reverseOrder());
        }
        
        int index = binarySearch(arr,X);
        int o = 0;
        int e =0;
        for(int i=0;i<index;i++){
            if(arr[i]%2!=0){
                o++;
            }
        }
        for(int i=N-1;i>index;i--){
            if(arr[i]%2==0){
                e++;
            }
        }

        result[0] = o;
        result[1] = e;

        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[]{6,4,3,5,2,1};
        System.out.println(inTheMid(a.length, 1, 3, a).toString());
    }
}
