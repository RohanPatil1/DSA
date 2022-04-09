import java.util.*;

public class NGR {

    // Nearest Greatest to Right
    public static ArrayList<Integer> ngr(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            if (stack.size() == 0) {
                result.add(-1);
            } else if (stack.size() > 0 && arr[i] < stack.peek()) {
                // Got ans
                result.add(stack.peek());
            } else if (stack.size() > 0 && arr[i] > stack.peek()) {
                // Util we get near max, pop from stack
                while (stack.size() > 0 && arr[i] >= stack.peek()) {
                    stack.pop();
                }
                // Now get the ans
                if (stack.size() == 0) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(result);

        return result;
    }

    // Nearest Greatest to Left
    public static ArrayList<Integer> ngl(int[] arr) {

        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (stack.size() == 0) {
                result.add(-1);
            } else if (stack.size() > 0 && arr[i] < stack.peek()) {
                // Got ans
                result.add(stack.peek());
            } else if (stack.size() > 0 && arr[i] > stack.peek()) {
                // Util we get near max, pop from stack
                while (stack.size() > 0 && arr[i] >= stack.peek()) {
                    stack.pop();
                }
                // Now get the ans
                if (stack.size() == 0) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(result);

        return result;
    }

    //Nearest smaller to left
    public static List<Integer> leftSmaller(int n, int arr[]) {
        // code here
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (stack.size() == 0) {
                result.add(-1);
            } else if (stack.size() > 0 && arr[i] > stack.peek()) {
                // Got ans
                result.add(stack.peek());
            } else if (stack.size() > 0 && arr[i] < stack.peek()) {
                // Util we get near max, pop from stack
                while (stack.size() > 0 && arr[i] < stack.peek()) {
                    stack.pop();
                }
                // Now get the ans
                if (stack.size() == 0) {
                    result.add(-1);
                } else {
                    result.add(stack.peek());
                }
            }else if(arr[i]==stack.peek()){
                result.add(-1);
            }
            stack.push(arr[i]);
        }

        return result;

    }

    public static void main(String[] args) {

        List<Integer> r = leftSmaller(7, new int[] { 19, 19, 19, 19, 19, 19, 19 });
        System.out.println(r.toString());
    }
}
