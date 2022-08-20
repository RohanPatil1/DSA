public class DiameterOfTree {

    static int res = 0;

    public static int diameter(BNode root) {
        if (root == null) return 0;


        int left = diameter(root.left);
        int right = diameter(root.right);

        int temp = Math.max(left, right) + 1;
        res = Math.max(res, 1 + left + right);
        return temp;
    }

    public static void main(String[] args) {

    }
}
