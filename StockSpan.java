
import java.util.*;

public class StockSpan {
    static class PaiR {
        int value;
        int index;

        PaiR(int value, int index) {
            this.value = value;
            this.index = index;
        }

        // public int compareTo(pair o) {
        // if (this.d == o.d)
        // return this.hn - o.hn;
        // else
        // return this.d - o.d;
        // }

    }

    public static List<Integer> stockSpan(int n, int arr[]) {
        List<Integer> result = new ArrayList<>();
        Stack<PaiR> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (stack.size() == 0) {
                result.add(-1);
            } else if (stack.size() > 0 && stack.peek().value > arr[i]) {
                result.add(stack.peek().index);
            } else if (stack.size() > 0 && stack.peek().value <= arr[i]) {
                while (stack.size() > 0 && stack.peek().value <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    result.add(-1);
                } else {
                    result.add(stack.peek().index);
                }
            }
            stack.push(new PaiR(arr[i], i));
        }

        for (int i = 0; i < n; i++) {
            int element = result.get(i);
            result.set(i, i - element);
        }
        return result;

    }

    public static void main(String[] args) {

        List<Integer> r = stockSpan(7, new int[] { 100, 80, 60, 70, 60, 75, 85 });
        System.out.println(r.toString());
    }
}
