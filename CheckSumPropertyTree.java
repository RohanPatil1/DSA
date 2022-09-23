public class CheckSumPropertyTree {

    public static boolean checkSumTree(BNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }


        int leftValue = 0, rightValue = 0;
        if (root.right != null) {
            rightValue = root.right.data;
        }
        if (root.left != null) {
            leftValue = root.left.data;
        }

        return root.data == (leftValue + rightValue) && checkSumTree(root.left) && checkSumTree(root.right);

    }

    public static void convertToSumTree(BNode root) {
        if (root == null) return;

        ///MOVE DOWN

        //Get child sum
        int childrenSum = 0;
        if (root.left != null) {
            childrenSum += root.left.data;
        }
        if (root.right != null) {
            childrenSum += root.right.data;
        }


        //If sum greater change root else change children to root
        if (childrenSum >= root.data) {
            root.data = childrenSum;
        } else {
            if (root.left != null) {
                root.left.data = root.data;
            }
            if (root.right != null) {
                root.right.data = root.data;
            }
        }

        convertToSumTree(root.left);
        convertToSumTree(root.right);


        ///MOVE BACK UP

        int totalSum = 0;
        if (root.left != null) {
            totalSum += root.left.data;
        }
        if (root.right != null) {
            totalSum += root.right.data;
        }
        //if not leaf node than update the root to new child sum
        if (root.left != null || root.right != null) {
            root.data = totalSum;
        }

    }


}
