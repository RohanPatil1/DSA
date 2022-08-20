public class CheckBalancedTree {

    boolean ans = true;


    int solve(BNode root) {

        if (root == null) return 0;


        int left = solve(root.left);
        int right = solve(root.right);


        if (Math.abs(left - right) > 1) {
            ans = false;
        }

        return 1 + Math.max(left, right);

    }


    //Function to check whether a binary tree is balanced or not.
    boolean isBalanced(BNode root) {
        // Your code here
        solve(root);
        return ans;
    }

}
