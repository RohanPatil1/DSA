import java.util.*;
import java.util.LinkedList;

class VPair {
    BNode node;
    int x;
    int y;

    public VPair(BNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

class VPairComparator implements Comparator<VPair> {
    @Override
    public int compare(VPair o1, VPair o2) {
        if (o1.y == o2.y) {
            return o1.node.data - o2.node.data;
        }

        return o1.y - o2.y;
    }
}

public class VerticalTreeTraversal {

    static List<List<Integer>> verticalOrder(BNode root) {
        List<List<Integer>> res = new ArrayList<>();


        Map<Integer, PriorityQueue<VPair>> map = new HashMap<>();
        Queue<VPair> q = new LinkedList<>();
        q.add(new VPair(root, 0, 0));
        int leftMin = 0, rightMax = 0;
        while (!q.isEmpty()) {
            VPair point = q.poll();

            root = point.node; // NOT RECOMMENDED - USE VISITED MAP/ARR
            map.putIfAbsent(point.x, new PriorityQueue<>(new VPairComparator()));
            map.get(point.x).add(point);
            leftMin = Math.min(leftMin, point.x);
            rightMax = Math.max(rightMax, point.y);

            if (root.left != null) {
                q.add(new VPair(root.left, point.x - 1, point.y + 1));
            }
            if (root.right != null) {
                q.add(new VPair(root.right, point.x + 1, point.y + 1));
            }
        }

        //Prepare ans
        for (int i = leftMin; i <= rightMax; i++) {
            PriorityQueue<VPair> pq = map.get(i);
            List<Integer> list = new ArrayList<>();
            while (!pq.isEmpty()) {
                list.add(pq.poll().node.data);
            }
            res.add(list);
        }

        return res;
    }
}
