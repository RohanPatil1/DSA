
import java.util.*;

public class MaxAreaHistogram {

    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

    }

    public static int maxHistogram(int[] arr) {
        int result = 0;

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        Stack<Pair> stack = new Stack<>();
        int n = arr.length;

        // Left => NSL
        for (int i = 0; i < n; i++) {

            if (stack.isEmpty()) {
                left.add(-1);
            } else if (!stack.isEmpty() && stack.peek().value < arr[i]) {
                left.add(stack.peek().index);
            } else if (!stack.isEmpty() && stack.peek().value >= arr[i]) {
                while (!stack.isEmpty() && stack.peek().value >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    left.add(-1);
                } else {
                    left.add(stack.peek().index);
                }
            }

            stack.push(new Pair(arr[i], i));
        }

        System.out.println(left.toString());

        // NSR
        stack.clear();

        for (int i = n - 1; i >= 0; i--) {

            if (stack.isEmpty()) {
                right.add(-1);
            } else if (!stack.isEmpty() && stack.peek().value < arr[i]) {
                right.add(stack.peek().index);
            } else if (!stack.isEmpty() && stack.peek().value >= arr[i]) {
                while (!stack.isEmpty() && stack.peek().value >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    right.add(-1);
                } else {
                    right.add(stack.peek().index);
                }
            }

            stack.push(new Pair(arr[i], i));
        }
        Collections.reverse(right);
        System.out.println(right.toString());

        // Make width array
        ArrayList<Integer> width = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int element = right.get(i) - left.get(i) - 1;
            width.add(element);
        }

        // Calculate Area
        for (int i = 0; i < n; i++) {
            result = Math.max(result, arr[i] * width.get(i));
        }
        System.out.println("Max Area : " + result);
        return result;
    }

    public static void main(String[] args) {

        // List<Integer> r = leftSmaller(7, new int[] { 19, 19, 19, 19, 19, 19, 19 });
        // System.out.println(r.toString());
        maxHistogram(new int[] { 6, 2, 5, 4, 5, 1, 6 });

    }
}
