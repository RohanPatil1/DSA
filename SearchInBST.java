public class SearchInBST {


    public static BNode searchBST(BNode root, int target) {

        while (root != null && root.data != target) {
            if (root.data > target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return root;

    }
}
