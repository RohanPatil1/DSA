import java.util.Arrays;

public class LongestConsecSubseq {
    public int longestConsecutive(int[] arr) {
        if(arr.length==0) return 0;
        if(arr.length==1) return 1;

        Arrays.sort(arr);

        int maxCount = Integer.MIN_VALUE;

        int count = 1;
        for(int i=0;i<arr.length-1;i++){


            if(arr[i]==arr[i+1]){
                continue;
            }
            if(arr[i]+1 == arr[i+1]){
                count+=1;
                maxCount = Math.max(maxCount,count);
            } else {
                count = 1;
            }

        }

        return Math.max(maxCount,count);

    }
}
