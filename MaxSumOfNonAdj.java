public class MaxSumOfNonAdj {
    static class Sum{
        int include;
        int notInclude;

        public Sum(){

        }

        public Sum(int include, int notInclude){
            this.include = include;
            this.notInclude = notInclude;
        }

    }

    //Function to return the maximum sum of non-adjacent nodes.
    static int getMaxSum(BNode root)
    {
        // add your code here
        Sum s = solve(root);
        return Math.max(s.include, s.notInclude);
    }

    static Sum solve(BNode root){
        if(root == null){
            return new Sum(0,0);
        }

        Sum left = solve(root.left);
        Sum right = solve(root.right);

        Sum resultSum = new  Sum();

        resultSum.include = root.data + left.notInclude + right.notInclude;

        //Choose to include left or not & right...
        resultSum.notInclude = Math.max(left.include, left.notInclude) + Math.max(right.include, right.notInclude);
        return resultSum;
    }
}
