import java.util.Arrays;

public class MinimumJump {


    public static int minimumJump(int arr[]) {

        int n = arr.length;
        if (n == 1)
            return 0;

        if (n == 0)
            return -1;

        int jump = 1;
        int step = arr[0], reachable = arr[0];
        for (int i = 0; i < n; i++) {

            if (i == n - 1) {
                return jump;
            }
            reachable = Math.max(reachable, arr[i] + i);
//            System.out.println("i: " + i + "Reachable: " + reachable + " Steps: " + step);
            step--;
            if (step == 0) {
                jump++;
                if (i >= reachable) {
//                    System.out.println("NOt Reachable : " + reachable + " i:" + i);
                    return -1;
                }
                step = reachable - i;
//                System.out.println("Jump: " + jump + " Steps: " + step);
            }
        }

        return jump;
    }

    public static int minimumJumpDP(int[] arr) {
        int n = arr.length;

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;



        for (int i = 1; i < n; i++) {
            System.out.println("i :"+i);
            for (int j = 0; j < i; j++) {
                System.out.println("j: "+j+" canReachJ: "+(arr[j] + j));
                boolean canReach = arr[j] + j >= i;
                if (dp[j] != Integer.MAX_VALUE && canReach) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }

            }
        }

        WordWrapDP.printArr(dp);
        if (dp[n - 1] == Integer.MAX_VALUE) return -1;
        return dp[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(minimumJump(new int[]{2, 3, 1, 1, 0}));
        System.out.println(minimumJumpDP(new int[]{1,4,3,2,6,7}));
    }

}


