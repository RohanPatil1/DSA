import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoPrime {


    //Time=O(n^2) Space=O(1)
    public static int coPrime(int[] arr) {

        //[1,3,5,2,4,7,7]
        int n = arr.length;
        int i = n - 1;
        int j = n - 1;

        int maxValue = Integer.MIN_VALUE;

        for (i = n - 1; i >= 0; i--) {
            for (j = i; j >= 0; j--) {
                if (gcd(arr[i], arr[j]) == 1) {
                    maxValue = Math.max(maxValue, i + j);
                }
            }
        }

        return maxValue + 2; // + 2 since output needs 1-based index
    }


    public static int coPrime2(int[] arr) {

        //[1,3,5,2,4,7,7]
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i); //store the latest occurrence of arr[i]
        }

        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (gcd(arr[i], arr[j]) == 1) {

                    //Get the latest/max index of occurrence
                    maxValue = map.get(arr[i]) + map.get(arr[j]);
                }
            }
        }

        return maxValue + 2;
    }


    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(coPrime(new int[]{5, 4, 3, 15, 12, 16}));
        System.out.println(coPrime2(new int[]{5, 4, 3, 15, 12, 16}));

    }

    public class Test {

        public static void main (String[] args) throws java.lang.Exception
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();

            while(t-- > 0)
                solve(sc);
        }

        public static void solve(Scanner sc){

            int n = sc.nextInt(), arr[] = new int[1001];
            Arrays.fill(arr, -1);

            for(int i=1; i<=n; i++){
                int x = sc.nextInt();
                arr[x] = i;
            }

            int ans = -1;
            for(int i=1; i<=1000; i++){
                if(arr[i] != -1){
                    for(int j=1; j<=1000; j++){
                        if(arr[j] != -1 && gcd(i, j) == 1)
                            ans = Math.max(ans, arr[i] + arr[j]);
                    }
                }
            }

            System.out.println(ans);
        }

        public static int gcd(int a, int b){
            if(b == 0) return a;
            return gcd(b, a % b);
        }
    }
}


