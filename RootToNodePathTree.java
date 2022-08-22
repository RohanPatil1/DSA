import java.util.ArrayList;

public class RootToNodePathTree {


    static ArrayList<Integer> arrayList = new ArrayList<>();

    public static boolean rootToNodePath(BNode root, int target) {
        if (root == null) return false;

        arrayList.add(root.data);
        if (root.data == target) {
            return true;
        }
        if (rootToNodePath(root.left, target) || rootToNodePath(root.right, target)) {
            return true;
        }
        arrayList.remove(arrayList.size() - 1);
        return false;
    }

}
