import java.util.ArrayList;

public class BoundaryTreeTraversal {


    ArrayList<Integer> ansList = new ArrayList<>();

    boolean isLeaf(BNode BNode) {

        if (BNode.left == null && BNode.right == null) {
            return true;
        }
        return false;
    }


    void addLeft(BNode root) {

        BNode curr = root.left;
        while (curr != null) {
            if (!isLeaf(curr)) ansList.add(curr.data);

            if (curr.left != null) curr = curr.left;
            else curr = curr.right;

        }

    }

    void addRight(BNode root) {

        ArrayList<Integer> tempList = new ArrayList<>();

        BNode curr = root.right;
        while (curr != null) {
            if (!isLeaf(curr)) tempList.add(curr.data);

            if (curr.right != null) curr = curr.right;
            else curr = curr.left;

        }

        //Add to main List
        for (int i = tempList.size() - 1; i >= 0; i--)
            ansList.add(tempList.get(i));

    }

    void addLeafBNodes(BNode root) {

        if (isLeaf(root)) {
            ansList.add(root.data);
            return;
        }

        if (root.left != null) addLeafBNodes(root.left);
        if (root.right != null) addLeafBNodes(root.right);

    }


    ArrayList<Integer> boundary(BNode BNode) {
        if (!isLeaf(BNode)) ansList.add(BNode.data);
        addLeft(BNode);
        addLeafBNodes(BNode);
        addRight(BNode);

        return ansList;
    }

    public static void main(String[] args) {

    }

}
