public class SuccessorPredecessorInBST {


    public static BNode predecessor(BNode root, BNode x) {
        BNode predeccessor = null;
        while (root != null) {
            if (x.data < root.data) {
                predeccessor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return predeccessor;
    }


    public static BNode successor(BNode root, BNode x) {
        BNode successor = null;

        while (root != null) {

            if (x.data >= root.data) {
                root = root.right;
            } else {
                successor = root;
                //Search for a smaller value
                root = root.left;
            }
        }

        return null;
    }

}
