import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianInStream {

    private static int n = 1;
    private static PriorityQueue<Integer> min = new PriorityQueue<>();
    private static PriorityQueue<Integer> max = new PriorityQueue<>((a, b) -> b - a);
    private static double ans = 0.0d;

    //Function to insert heap.
    public static void insertHeap(int x) {
        // add your code here
        if (n % 2 != 0) {
            min.offer(x);
            max.offer(min.poll());
        } else {
            max.offer(x);
            min.offer(max.poll());
        }
    }

    // //Function to balance heaps.
    public static void balanceHeaps() {
        // add your code here
    }

    //Function to return Median.
    public static double getMedian() {
        // add your code here
        if (n % 2 != 0) {
            ans = max.peek();
            n++;
            return ans;
        }
        //else
        ans = ((double) min.peek() + max.peek()) / 2;
        n++;
        return ans;
    }

//    static Queue<Integer> pq1 = new LinkedList<>();
//
//    public static double findMedian(int a[], int n) {
//        // printArr(a);
//        System.out.println("-");
//        // First we sort the array
//        Arrays.sort(a);
//
//        // check for even case
//        if (n % 2 != 0)
//            return a[n / 2];
//
//        return (a[(n - 1) / 2] + a[n / 2]) / 2;
//    }
//    public static void getANS(int A[], int N) {
//        double currM = 0;
//        int k = 0;
//        while (N != 0) {
//            int curr = A[k++];
//
//            pq1.add(curr);
//            System.out.println(pq1.toString());
//            int n = pq1.size();
//            int[] a = new int[n];
//            int i = 0;
////            while (n!=0) {
////                a[i++] = pq1.peek();
////                n--;
////            }
//            for (Integer item : pq1) {
//                a[i++] = item;
//            }
//            double m = findMedian(a, pq1.size());
//            DecimalFormat format = new DecimalFormat("0.#");
//
//            currM =m;
//            System.out.println((int) Math.floor(currM));
//            a = null;
//            N--;
//        }
//    }
}

