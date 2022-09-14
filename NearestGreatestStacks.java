import java.util.ArrayList;
import java.util.Stack;

public class NearestGreatestStacks {

    //NGR
    public static long[] nearestGreatestToRight(long[] arr, int n) {
        long[] ans = new long[n];
        ArrayList<Long> ansL = new ArrayList<>();
        Stack<Long> stack = new Stack<Long>();
        for (int i = n - 1; i >= 0; i--) {

            if (stack.isEmpty()) {
                ansL.add(-1L);
            } else if (!stack.isEmpty() && arr[i] < stack.peek()) {
                ansL.add(stack.peek());
            } else if (!stack.isEmpty() && arr[i] > stack.peek()) {
                while (!stack.isEmpty() && arr[i] > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) ansL.add(-1L);
                else ansL.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        return ans;
    }

    //NSL
    public static void nearestSmallerToLeft(int[] arr, int n) {
        ArrayList<Integer> ansL = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                ansL.add(-1);
            } else if (!stack.isEmpty() && arr[i] > stack.peek()) {
                ansL.add(stack.peek());
            } else if (!stack.isEmpty() && arr[i] <= stack.peek()) {
                while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty()) ansL.add(-1);
                else ansL.add(stack.peek());

            }

            stack.push(arr[i]);
        }


    }


}
