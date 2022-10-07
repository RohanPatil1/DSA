import java.util.HashMap;
import java.util.Map;

public class BtreeFromPreorderInorder {
//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/Figures/105/105-Page-2.png

    Map<Integer, Integer> map = new HashMap<>();
    int preOrderIndex = 0;

    public BNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }


        return solve(preorder, 0, preorder.length - 1);
    }

    BNode solve(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }

        int currRootVal = preorder[preOrderIndex];
        BNode root = new BNode(currRootVal);
        preOrderIndex++; //For next root

        //Build Left & Right subTree
        root.left = solve(preorder, left, map.get(currRootVal) - 1);
        root.right = solve(preorder, map.get(currRootVal) + 1, right);
        return root;
    }


}
