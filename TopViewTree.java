import java.util.*;
import java.util.LinkedList;


public class TopViewTree {
    class TopViewPair {
        BNode node;
        int position;

        public TopViewPair(BNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    public List<Integer> topView(BNode root) {

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<TopViewPair> q = new LinkedList<>();

        q.add(new TopViewPair(root, 0));

        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TopViewPair p = q.poll();
                int x = p.position;
                if (!map.containsKey(x)) {
                    map.put(x, p.node.data);
                }

                minX = Math.min(minX, p.position);
                maxX = Math.max(maxX, p.position);
                if (p.node.left != null) {
                    q.add(new TopViewPair(p.node.left, p.position - 1));
                }
                if (p.node.right != null) {
                    q.add(new TopViewPair(p.node.right, p.position + 1));
                }

            }
        }

        List<Integer> ansList = new ArrayList<>();
        for (int i = minX; i <= maxX; i++) {
            ansList.add(map.get(i));
        }

        return ansList;
    }

}
