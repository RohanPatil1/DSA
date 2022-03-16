import java.util.*;

public class ClosestNumbers {
    
    //https://practice.geeksforgeeks.org/problems/find-the-closest-number5513/1#
    //Find the closest number for target from the arr
    public static int findClosest(int arr[], int n, int target) 
    { 
        // Complete the function
        int result = 0;
        int minDiff =Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
            int currDiff =Math.abs(target - arr[i]);
            if(minDiff>currDiff){
                    
                result = i;
                minDiff = currDiff;
            }
            
            if(currDiff == minDiff){
                if(arr[i]>arr[result]){
                    result = i;
                }
            }
            
            
        }
        
     return arr[result];   
    } 


    //Return all 
    public static ArrayList<Integer> closestNumbers(int[] arr){

        int n =arr.length;
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        ArrayList<Integer> result =new ArrayList<Integer>(n);

        //Map Store diff and corresponding List<Integer>
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>(n);

        for(int i=0;i<n-1;i++){
            int currDiff = arr[i+1] - arr[i];
            if(minDiff >= currDiff){
                //Got a minDiff, if currDiff contains in map, apend the list else add new list for currDiff
                if(map.containsKey(currDiff)){
                    map.get(currDiff).add(arr[i]);
                    map.get(currDiff).add(arr[i+1]);

                }else{
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(arr[i]);
                    temp.add(arr[i+1]);
                    map.put(currDiff, temp);
                }
                
                minDiff = currDiff;
            }
        }


        //Fill the result list
        if(map.containsKey(minDiff)){
            result = new ArrayList<Integer>(map.get(minDiff));
        }
        return result;
    }


    public static void main(String[] args){
        //int[] arr = new int[]{1,3,6,7};
        int[] arr = new int[]{5,4,3,2};
        
        int res = findClosest(arr, arr.length, 4);
        ArrayList<Integer> r = closestNumbers(arr);

       // System.out.println(res);        
   
        for(int i=0;i<r.size();i++){
            int e = r.get(i);
            System.out.print(e+" ");        
        }
    }
}
