public class FlattenBTtoLL {


    static BNode prev = null;

    public static BNode flatten(BNode root) {
        solveA1(root);
        return root;
    }

    //Time & Space => O(N)
    private static void solveA1(BNode root) {
        if (root == null) return;


        flatten(root.left);
        flatten(root.right);

        root.right = prev;
        root.left = null;
        prev = root;
    }

    //Time = O(N) & Space => O(1)
    private static void solveA2(BNode root) {
        if (root == null) return;

        BNode curr = root, prev = null;

        while (curr != null) {

            if (curr.left != null) {
                prev = prev.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;
                curr.right = curr.left;

            }
            curr = curr.right;
        }

    }


}
