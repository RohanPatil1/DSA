import java.util.*;

public class FirstRepeatingElement {

    public static int getFirst(int[] arr) {
        int result = -1;
        int n = arr.length;


        for (int i = 0; i < n; i++) {
            int j=i+1;
            while(j<n){
                if(arr[i]==arr[j]){
                    result = i+1;
                    return result;
                }else{
                    j++;
                }
           }
        }
        


        return result;
    }

    static String printFirstRepeating(List<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            if (Collections.frequency(a, a.get(i)) > 1)
                return String.valueOf(a.get(i));
        }
        return "there is no repetition number";
    }
    public static void main(String[] args) {

        int[] arr = new int[]{1, 5, 3, 4, 3, 5, 6};
        int res= getFirst(arr);
        System.out.println(res);
    }

}
