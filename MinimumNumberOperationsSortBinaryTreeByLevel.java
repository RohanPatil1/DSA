import java.util.*;
import java.util.LinkedList;

public class MinimumNumberOperationsSortBinaryTreeByLevel {

    static class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }

    public static int minSwaps(BNode root) {

        int totalSwaps = 0;

        //It will store elements for each level
        List<Integer> list = new ArrayList<>();

        //Level order traversal
        Queue<BNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                BNode node = q.poll();
                list.add(node.data);

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);

            }

            //List has all the element of the level. Calculate the swaps
            totalSwaps += getMinSwaps(list);
            list.clear();
        }


        return totalSwaps;
    }

    private static int getMinSwaps(List<Integer> list) {

        int n = list.size();
        int swaps = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) map.put(list.get(i), i);

        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        //Sorted to original arr
        for (int i = 0; i < n; i++) {
            if (!list.get(i).equals(sortedList.get(i))) {
                swaps++;
                map.put(list.get(i), map.get(sortedList.get(i)));
                list.set(map.get(sortedList.get(i)), list.get(i));
            }
        }

        return swaps;
    }

}
