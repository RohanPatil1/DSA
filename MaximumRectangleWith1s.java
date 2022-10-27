import java.util.Stack;

public class MaximumRectangleWith1s {

//https://leetcode.com/problems/maximal-rectangle/discuss/1604254/C%2B%2B-Simple-Solution-w-Explanation-or-Optimizations-from-Brute-Force-to-DP

    public int maxAreaHistogram(int[] heights){

        int n = heights.length;

        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;

        for(int i=0; i<=n; i++){


            int currHeight = (i==n) ? 0 : heights[i];

            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){

                int top = stack.pop();

                int width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, width*heights[top]);
            }


            stack.push(i);

        }


        return maxArea;
    }


    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        int[] histogram = new int[m];

        int maxArea = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){

                if(matrix[i][j] == '1') histogram[j]++;
                else histogram[j] = 0;

            }

            maxArea = Math.max(maxArea, maxAreaHistogram(histogram));

        }


        return maxArea;
    }

}

