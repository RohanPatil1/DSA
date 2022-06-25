import java.util.*;

public class MinimumPlatforms {
    public static int minPlatform(int[] arr, int[] dept, int n) {
        PriorityQueue<MyPair> pq = new PriorityQueue<>(new CustomCComparator2());
        ArrayList<MyPair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new MyPair(arr[i], dept[i]));
        }

        Collections.sort(list, new CustomCComparator2());
        for(MyPair p:list){
            System.out.println(p.a);
        }

        int platform = 1;
        //PQ - (Dept-Platform)
        //List- (Arr-Dept)
        pq.offer(new MyPair(list.get(0).b, platform));

        for (int i = 1; i < n; i++) {
            MyPair currT = list.get(i);

            if (currT.a >= pq.peek().a) {
                int samePlatform = pq.peek().b;
                pq.poll();
                pq.offer(new MyPair(currT.b, samePlatform));
            } else {
                //Need new platform - Prev dept is greater than next arrival
                platform++;
                pq.offer(new MyPair(currT.b, platform));
            }

        }


        return platform;
    }

    public static int getPlatforms(int[] arr, int[] dept, int n) {
        int result = 0;
        Arrays.sort(arr);
        Arrays.sort(dept);

        int platNeeded = 1;
        int i = 1, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dept[j]) {
                platNeeded++;
                i++;
            } else if (arr[i] > dept[j]) {
                platNeeded--;
                j++;
            }

            result = Math.max(result, platNeeded);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = new int[] {50,120,200,550,700,850};
        int[] dept = new int[] {500,550,600,700,900,1000};
        int result =getPlatforms(arr, dept, 6);
        System.out.println(result);
    }
}
