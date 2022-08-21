public class MaxSumPathTree {

    int maxAns = Integer.MIN_VALUE;

    int solve(BNode root) {

        if (root == null) return 0;

        int leftSum = Math.max(0, solve(root.left));
        int rightSum = Math.max(0, solve(root.right));
        maxAns = Math.max(maxAns, root.data + leftSum + rightSum);
        return root.data + Math.max(leftSum, rightSum);
    }

    int findMaxSum(BNode node) {
        solve(node);
        return maxAns;
    }

    //------------MAX SUM with Start & End at leaf node
//    int maxAns = Integer.MIN_VALUE;
    int solve2(BNode root) {

        if (root == null) return 0;

        int leftSum = solve2(root.left);
        int rightSum = solve2(root.right);


        if(root.left==null) return root.data + rightSum;
        if(root.right==null) return root.data + leftSum;


        maxAns = Math.max(maxAns, root.data + leftSum + rightSum);
        return root.data + Math.max(leftSum, rightSum);
    }

    int maxPathSum(BNode root)
    {
        if(root==null)
            return 0;
        if(root.left==null && root.right==null)
            return root.data;

        int x = solve(root);
        if(root.left==null || root.right==null)
            return Math.max(maxAns,x);


        return maxAns;

    }


}
