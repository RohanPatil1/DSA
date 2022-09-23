public class ValidateBTasBST {


    public static boolean  isBST(BNode root) {
        return checkBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private static boolean checkBST(BNode root, long minValue, long maxValue) {
        if(root == null){
            return true;
        }

        //if out of bounds
        if(root.data < minValue || root.data>maxValue) return false;



        return checkBST(root.left,minValue, root.data) && checkBST(root.right, root.data, maxValue);
    }
}
