import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {


    public static BNode invertBinaryTree(BNode root) {
        if (root == null) return root;


        BNode left = root.left, right = root.right;

        root.left = invertBinaryTree(right);
        root.right = invertBinaryTree(left);
        return root;
    }


    public static BNode invertBTUsingBFS(BNode root) {

        if (root == null) return root;

        Queue<BNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            BNode node = q.poll();

            BNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null) {
                q.add(node.left);
            }

            if (node.right != null) {
                q.add(node.right);
            }

        }


        return root;
    }




}
