import java.util.HashMap;
import java.util.Map;

public class LargestSubarrayWith0Sum {

    int maxLen(int arr[], int n)
    {
        // Your code here
        Map<Integer,Integer> map = new HashMap<>();

        int maxLen = 0;
        int sum=0;


        for(int i=0;i<n;i++){
            sum += arr[i];

            if(sum == 0){
                int len = i + 1;
                maxLen = Math.max(maxLen,len);
            }

            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen , len);
            }else{
                map.put(sum,i);
            }

        }


        return maxLen;

    }
}
