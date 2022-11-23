import java.util.PriorityQueue;
import java.util.Scanner;

public class CAdvantage {

    static class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

///You try nlogk where k will be 2 largest and secondLargest
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.val - a.val);
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                pq.offer(new Pair(arr[i], i));
            }

            for (int i = 0; i < n; i++) {
                Pair ansP = pq.peek();
                if(ansP.index == i){
                    pq.poll();
                    arr[i] -= pq.peek().val;
                    pq.add(ansP);
                }else{
                    arr[i] -= ansP.val;
                }
            }

            for (int j : arr) {
                System.out.print(j + " ");
            }
        }
    }

}

/*
for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        if (arr[i] > maxi1)
        {
            maxi2 = maxi1;
            maxi1 = arr[i];
        }
        else if (arr[i] > maxi2)
        {
            maxi2 = arr[i];
        }
    }
 */