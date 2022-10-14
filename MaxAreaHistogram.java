
import java.util.*;

public class MaxAreaHistogram {
    //https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/1727776/JavaC%2B%2B-Explanation-going-from-Brute-to-Optimal-Approach
    static class Pair {
        int value;
        int index;

        Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

    }


    public static int maxHistogramA1(int[] heights) {
        int n = heights.length;
        int[] leftMin = new int[n];
        Stack<Integer> left = new Stack<>();
        Arrays.fill(leftMin, -1);
        for (int i = heights.length - 1; i >= 0; i--) {
            if (left.isEmpty() || heights[i] >= heights[left.peek()]) {
                left.add(i);
            } else {
                while (!left.isEmpty() && heights[left.peek()] > heights[i]) {
                    leftMin[left.peek()] = i;
                    left.pop();
                }
                left.add(i);
            }
        }
        int[] rightMin = new int[n];
        Stack<Integer> right = new Stack<>();
        Arrays.fill(rightMin, heights.length);
        for (int i = 0; i < heights.length; i++) {
            if (right.isEmpty() || heights[i] >= heights[right.peek()]) {
                right.add(i);
            } else {
                while (!right.isEmpty() && heights[right.peek()] > heights[i]) {
                    rightMin[right.peek()] = i;
                    right.pop();
                }
                right.add(i);
            }
        }
        int area = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            area = Math.max(area, heights[i] * (rightMin[i] - leftMin[i] - 1));
        }
        System.out.println(area);
        return area;
    }

    public static int maxHistogramA2(int[] heights) {
        int n = heights.length;
        int maxArea = 0;

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];
            //we add if currHeight is part of the increasing sequence else we calculate area and pop() it;
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) { /// 3 1 so pop(3) after getArea from 3
                int top = stack.pop();

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(maxArea, area);

            }

            stack.push(i);
        }

        System.out.println(maxArea);
        return maxArea;
    }


    public static void main(String[] args) {

        // List<Integer> r = leftSmaller(7, new int[] { 19, 19, 19, 19, 19, 19, 19 });
        // System.out.println(r.toString());
        maxHistogramA1(new int[]{2, 4});
        maxHistogramA2(new int[]{2, 4});

    }
}
