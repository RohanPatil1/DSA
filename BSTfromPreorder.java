public class BSTfromPreorder {

    int i = 0;

    public BNode buildBST(int[] arr, int bound) {
        if (i == arr.length || arr[i] > bound) {
            return null;
        }

        BNode node = new BNode(arr[i++]);
        node.left = buildBST(arr, node.data);
        node.right = buildBST(arr, bound);
        return node;
    }

    public BNode bstFromPreorder(int[] arr) {
        return buildBST(arr, Integer.MAX_VALUE);
    }
}
