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

    //Using BFS
    public static void markParents(BNode root, Map<BNode, BNode> parentMap) {

        Queue<BNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BNode curr = queue.poll();

            //We can go left, so store its parent in map
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.offer(curr.left);
            }

            //We can go right, so store its parent in map
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }


    public static void markParentsDFS(BNode root, Map<BNode, BNode> parentMap) {

        if (root == null) return;
        if (root.left != null) {
            parentMap.put(root.left, root);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
        }

        markParentsDFS(root.left, parentMap);
        markParentsDFS(root.right, parentMap);
        return;
    }


    //Distance K Nodes
    public static ArrayList<Integer> distanceKNodes(BNode root, BNode target, int k) {

        //Get Parents map so that we can travel up as well with BFS
        Map<BNode, BNode> parentMap = new HashMap<>();
        markParents(root, parentMap);

        //BFS in UP, DOWN directions
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

                //DOWN
                if (curr.left != null && visitedMap.get(curr.left) == null) {
                    queue.offer(curr.left);
                    visitedMap.put(curr.left, true);
                }
                if (curr.right != null && visitedMap.get(curr.right) == null) {
                    queue.offer(curr.right);
                    visitedMap.put(curr.right, true);
                }

                //UP
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
