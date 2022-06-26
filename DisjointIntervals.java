import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;


public class DisjointIntervals {


    public static int getMergedIntervals(int[][] arr) {

        int n = arr.length;
        Interval[] intervals = new Interval[n];
        for (int i = 0; i < n; i++) {
            intervals[i] = new Interval(arr[i][0], arr[i][1]);
        }
        Arrays.sort(intervals, new IntervalComparator());

        Stack<Interval> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < n; i++) {
            if (intervals[i].a <= stack.peek().b) {
                stack.peek().b = Math.min(intervals[i].b, stack.peek().b);

            } else {
                stack.push(intervals[i]);

            }
        }

        Collections.reverse(stack);
        n = stack.size();


        return n;
    }

}
