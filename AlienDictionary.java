import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

public class AlienDictionary {

    public static String findOrder(String[] dict, int N, int K) {

        List<List<Integer>> adj = new ArrayList<>();

        //Construct Adj List
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                char s1Char = s1.charAt(ptr);
                char s2Char = s2.charAt(ptr);

                if (s1Char != s2Char) {
                    adj.get(s1Char - 'a').add(s2Char - 'a');
                    break;
                }
            }

        }

        //TopoSort

        int[] indegree = new int[K];
        //Get Indegrees
        for (int i = 0; i < K; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // //Add Indegrees 0 to queue
        Queue<Integer> q = new LinkedList<>();


        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Get TopoList
        List<Integer> topoList = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topoList.add(node);

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }

        }

        String ans = "";
        // Get Char from TopoList
        for (int it : topoList) {
            ans += (char) (it + (int) 'a');
        }

        return ans;


    }

    public static void main(String[] args) {
        String[] arr = new String[]{"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrder(arr, 5, 4));
    }
}
