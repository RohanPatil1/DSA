import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CourseSchedule {

    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> arr : prerequisites) {
            adj.get(arr.get(1)).add(arr.get(0));
        }

        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        int[] topo = new int[n];
        int index = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            topo[index++] = curr;

            for (int it : adj.get(curr)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.offer(it);
                }
            }
        }
        if (index == n) return topo;

        return new int[]{};
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean canFinish = true;
        int n = prerequisites.length;

        //Prepare adj list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); //pair if we have weight
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }


        return canFinish;
    }

}
