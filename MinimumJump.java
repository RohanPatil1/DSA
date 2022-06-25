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
            step--;
            if (step == 0) {
                jump++;
                if (i >= reachable) {
                    return -1;
                }
                step = reachable - i;

            }
        }

        return jump;
    }

    public static void main(String[] args) {

    }

}


