import java.util.*;

public class PivotIndex {
    

    public static int pivotIndex(int[] arr) {
        
        int n = arr.length;
        
        int left =0;
        int right = 0;
        
        for(int k=0;k<n;k++){
            
            int i = 0;
            int j=k+1;
            
            //Get Left
            while(i<=(k-1)){
                left += arr[i];
                i++;
            }
            System.out.println("Left for "+k+" ="+left);
            while(j<n){
                right += arr[j];
                j++;
                           
            }
            System.out.println("Right for "+k+" ="+right);

            
            if(left==right){
                return k;
            }else{
                left =0;
                right =0;
            }

            
        }
        return  -1;
        
    }

    public static int pivotIndex2(int[] arr) {
        
        int n = arr.length;
        
        int left =0;
        int right = 0;
        
        for(int x:arr){
            right +=x;
        }

        for(int k=0;k<n;k++){
            
            right -=arr[k];
            
            if(left==right){
                return k;
            }

            left +=arr[k];

            
        }
        return  -1;
        
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));   
    }
}
