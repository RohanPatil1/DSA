public class SortedArrToBST {

    public static BNode sortedArrToBst(int[] arr) {


        return buildBST(arr, 0, arr.length - 1);
    }

    private static BNode buildBST(int[] arr, int left, int right) {

        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        BNode root = new BNode(arr[mid]);
        root.left = buildBST(arr, left, mid - 1);
        root.right = buildBST(arr, mid + 1, right);
        return root;
    }

}
