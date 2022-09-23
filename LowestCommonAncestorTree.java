import java.util.ArrayList;
import java.util.List;

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


    ///---------Approach 1 - get path for both and check from last for common node
    boolean getPath(BNode root, List<BNode> pathList, BNode target) {
        if (root == null) {
            return false;
        }

        pathList.add(root);

        //Found
        if (root.data == target.data) {
            return true;
        }

        //Check left subTree or Right SubTree
        if (getPath(root.left, pathList, target) || getPath(root.right, pathList, target)) {
            return true;
        }

        // required node does not lie either in the
        // left or right subtree of the current node
        // Thus, remove current node's value & return false
        pathList.remove(pathList.size() - 1);
        return false;
    }

    BNode lcaA1(BNode root, BNode p, BNode q) {
        List<BNode> pathP = new ArrayList<>();
        List<BNode> pathQ = new ArrayList<>();
        getPath(root, pathP, p);

        System.out.println(pathP);
        getPath(root, pathQ, q);

        System.out.println(pathQ);


        int limit = Math.min(pathQ.size() - 1, pathP.size() - 1);

        for (int i = limit; i >= 0; i--) {
            if (pathQ.get(i).data == pathP.get(i).data) {
                return pathQ.get(i);
            }
        }

        return root;

    }


    ///----------LCA in BINARY SEARCH TREE TimeComplexity-> O(H)

    public static BNode lcaInBST(BNode root, BNode p, BNode q) {
        if (root == null) {
            return null;
        }

        int currVal = root.data;

        //Does both p & q lie in the right
        if (currVal < p.data && currVal < q.data) {
            //Go Right
            return lcaInBST(root.right, p, q);
        } else if (currVal > p.data && currVal > q.data) {
            //Go left
            return lcaInBST(root.left, p, q);
        }
        return root;
    }

}
