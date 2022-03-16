import java.util.*;
public class selectionSort {
    

    
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
  
        int smallest =0; //Smallest index
        for(int i=0;i<arr.length-1;i++){
            smallest = i;
            //Find the smallest 
            for(int j=i+1;j<arr.length-1;j++){
                if(arr[smallest]>arr[j]){
                    //Update the smallest for the current iteration
                    smallest = j;

                }
            }
            //After finding the smallest, swap the smallest
            int temp = arr[i];
            arr[smallest] =temp;
            arr[i] = arr[smallest];
        }

        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }


}
