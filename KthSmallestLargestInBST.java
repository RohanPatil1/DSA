import java.util.ArrayList;
import java.util.List;

public class KthSmallestLargestInBST {


    /*
        -get the sorted list from inorder traversal on a BST
        -get the kth smallest index
        A1
     */
    public void inOrder(BNode root, List<Integer> list) {
        if (root == null) return;
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }

    public int kthSmallest(BNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(k - 1);
    }


    //USING COUNTER Space O(1)
    int count = 0;

    public int kthSmallest2(BNode root, int k) {
        if (root == null) {
            return -1;
        }

        int recValue = kthSmallest2(root.left, k);
        if (recValue != -1) {
            return recValue;
        }
        count++;
        if (count == k) return root.data;
        recValue = kthSmallest2(root.right, k);
        return recValue;
    }

}
