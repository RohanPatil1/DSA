public class CountGoodNodes {


    static int count = 0;

    public static int countGoodNodes(BNode root) {

        solve(root, Integer.MIN_VALUE);
        return count;
    }

    private static void solve(BNode root, int prevMax) {
        if (root == null) return;

        if (root.data >= prevMax) {
            count++;
            prevMax = root.data;
        }

        solve(root.left, prevMax);
        solve(root.right, prevMax);

    }


}
