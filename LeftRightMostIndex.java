import java.util.*;

public class LeftRightMostIndex {
    

    public static int getLeft(int[] arr,int target){
        
        int n=arr.length;
        
       int low=0,high=n-1;
        int mid=0;
        while(low<=high){
            mid = low + (high-low)/2;
            
            if(arr[mid]>target){
                high = mid-1;
            }else if(arr[mid]<target){
                low = mid+1;
            }else{
                
                //==
                
                if(mid == low || arr[mid]!=arr[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                    
                }
            }
        }
        return -1;
        
    }

    public static int getRight(int[] arr,int target){
        int n=arr.length;
        
        int low = 0,high = n-1,mid;
        
        while(low<=high){
            
            mid = low + (high-low)/2;
            
            
            if(arr[mid]>target){
                high = mid -1;
            }else if(arr[mid]<target){
                low = mid + 1;
            }else{
                
                if(mid==high || arr[mid]!=arr[mid+1]){
                    return mid;
                }else{
                    low = mid+1;
                }
            }
            
            
        }
        
        return -1;    
    }
    

    public static void main(String[] args) {
        int[] arr = new int[]{5,7,7,8,8,10};

        System.out.println(Arrays.binarySearch(arr, 50));

        System.out.println(getLeft(arr,8));   
        System.out.println(getRight(arr,8));   

    }
}
