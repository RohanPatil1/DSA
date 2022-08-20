public class LowestCommonAncestorTree {
    BNode lca(BNode root, int p, int q) {
        if (root == null || p == root.data || q == root.data) {
            return root;
        }


        BNode leftT = lca(root.left, p, q);
        BNode rightT = lca(root.right, p, q);

        if (leftT == null) {
            return rightT;
        } else if (rightT == null) {
            return leftT;
        } else {
            return root;
        }

    }
}
