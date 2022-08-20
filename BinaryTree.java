import java.util.LinkedList;
import java.util.Queue;

class BNode {
    int data;
    BNode left;
    BNode right;

    public BNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BinaryTree {

    static int index = -1;

    //--------------TRAVERSALS--------------------------------
    public static void preOrder(BNode root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(BNode root) {
        if (root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }


    public static void postOrder(BNode root) {
        if (root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrderTraversal(BNode root) {
        BFS(root);
    }

    //BFS - Queue
    public static void BFS(BNode root) {
        Queue<BNode> queue = new LinkedList<>();

        queue.add(root);
        while (!queue.isEmpty()) {
            BNode node = queue.poll();
            System.out.print(node.data + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    //DFS
    public static void DFS(BNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            DFS(root.left);
            DFS(root.right);
        }
    }

    //--------------BUILD TREE--------------------------------
    public static BNode buildTree(int[] nodes) {
        index++; //root
        if (nodes[index] == -1) return null;

        BNode newNode = new BNode(nodes[index]);
        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);
        return newNode;
    }

    public static void main(String[] args) {
        int[] nodes = new int[]{1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BNode root = buildTree(nodes);
        System.out.print("Preorder :");
        preOrder(root);

        System.out.println();

        System.out.print("Inorder :");
        inOrder(root);
        System.out.println();

        System.out.print("Postorder :");
        postOrder(root);
        System.out.println();

        System.out.print("BFS :");
        BFS(root);

        System.out.println();

        System.out.print("DFS :");
        DFS(root);
    }

}
