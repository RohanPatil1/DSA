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
            System.out.println("i: "+i+"Reachable: " + reachable + " Steps: " + step);
            step--;
            if (step == 0) {
                jump++;
                if (i >= reachable) {
                    System.out.println("NOt Reachable : "+reachable +" i:"+i);
                    return -1;
                }
                step = reachable - i;
                System.out.println("Jump: " + jump + " Steps: " + step);
            }
        }

        return jump;
    }

    public static void main(String[] args) {
        System.out.println(minimumJump(new int[]{2, 3, 1, 1, 0}));
    }

}


