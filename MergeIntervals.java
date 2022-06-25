import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

class Interval {
    int a, b;

    public Interval(int a, int b) {
        this.a = a;
        this.b = b;
    }

}

class IntervalComparator implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.a - o2.a;
    }
}

public class MergeIntervals {


    public static int[][] getMergedIntervals(int[][] arr) {

        int n = arr.length;
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(arr[i][0], arr[i][1]);
        }
        Arrays.sort(intervals, new IntervalComparator());

        Stack<Interval> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < n; i++) {
            if (intervals[i].a > stack.peek().b) {
                //Cant Merge
                stack.push(intervals[i]);
            } else {
                //Merge by updating the ending
                stack.peek().b = Math.max(intervals[i].b, stack.peek().b);  //Edge case miss by stack.peek().b = intervals[i].b;
            }
        }

        Collections.reverse(stack);
        n = stack.size();
        int[][] ans = new int[n][2];
        for (int i = 0; i < n; i++) {
            Interval interval = stack.pop();
            ans[i][0] = interval.a;
            ans[i][1] = interval.b;
        }


        return ans;
    }


}
