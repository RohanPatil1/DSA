import java.util.LinkedList;

public class AddOneRowToTree {

    public BNode addOneRow(BNode root, int v, int d) {
        if (d == 1) {
            BNode newroot = new BNode(v);
            newroot.left = root;
            return newroot;
        }
        LinkedList<BNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 0; i < d - 2; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                BNode t = queue.poll();
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
        }
        while (!queue.isEmpty()) {
            BNode t = queue.poll();
            BNode tmp = t.left;
            t.left = new BNode(v);
            t.left.left = tmp;
            tmp = t.right;
            t.right = new BNode(v);
            t.right.right = tmp;
        }
        return root;
    }
}
