public class FloorBST {


    public static int floorInBST(BNode root, int X) {

        BNode floorNode = null;
        while (root != null) {
            if (root.data == X) {
                return root.data;
            } else if (root.data > X) {
                root = root.left;
            } else {
                floorNode = root;
                root = root.right;
            }
        }
        return (int) floorNode.data;
    }
}
