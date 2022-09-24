public class LargestBST {

    class LBST {
        boolean isBST;
        int size;
        int min;
        int max;

        public LBST(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }


    public int largestBST(BNode root) {
        LBST res = solve(root);
        return res.size;
    }

    private LBST solve(BNode root) {
        //If left exit not right or vice versa
        if (root == null) {
            return new LBST(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        //Leaf Node
        if (root.left == null && root.right == null) {
            return new LBST(true, 1, root.data, root.data);
        }

        //Recursive call
        LBST left = solve(root.left);
        LBST right = solve(root.right);


        //Going Up, computing result
        if (left.isBST && right.isBST) {
            if (root.data > left.max && root.data < right.min) {
                int minLeft = left.min;
                int maxRight = right.max;
                if (minLeft == Integer.MAX_VALUE) minLeft = root.data;
                if (maxRight == Integer.MIN_VALUE) maxRight = root.data;

                return new LBST(true, 1 + left.size + right.size, minLeft, maxRight);
            }
        }

        //if not bst
        return new LBST(false, Math.max(left.size, right.size), 0, 0);
    }


}
