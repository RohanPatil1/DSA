import java.util.*;
import java.util.LinkedList;

public class NodesAtKDistanceTree {


    static BNode targetNode = null;

    public static boolean rootToNodePath(BNode root, int target) {
        if (root == null) return false;

        if (root.data == target) {
            targetNode = root;
            return true;

        }
        return rootToNodePath(root.left, target) || rootToNodePath(root.right, target);
    }


    public static void markParents(BNode root, Map<BNode, BNode> parentMap) {

        Queue<BNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BNode curr = queue.poll();
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }

    //Distance K Nodes
    public static ArrayList<Integer> distanceKNodes(BNode root, BNode target, int k) {

        Map<BNode, BNode> parentMap = new HashMap<>();
        markParents(root, parentMap);

        Map<BNode, Boolean> visitedMap = new HashMap<>();
        Queue<BNode> queue = new LinkedList<>();

        queue.offer(target);
        visitedMap.put(target, true);
        int currLevel = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (currLevel == k) break;
            currLevel++;

            for (int i = 0; i < size; i++) {
                BNode curr = queue.poll();
                if (curr.left != null && visitedMap.get(curr.left) == null) {
                    queue.offer(curr.left);
                    visitedMap.put(curr.left, true);
                }
                if (curr.right != null && visitedMap.get(curr.right) == null) {
                    queue.offer(curr.right);
                    visitedMap.put(curr.right, true);
                }

                BNode parentNode = parentMap.get(curr);
                if (parentNode != null && visitedMap.get(parentNode) == null) {
                    queue.offer(parentNode);
                    visitedMap.put(parentNode, true);
                }
            }
        }

        //Fill output array
        ArrayList<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().data);
        }

        return result;
    }

}
