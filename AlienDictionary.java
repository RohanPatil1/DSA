import java.util.LinkedList;
import java.util.*;

public class AlienDictionary {


    public static String findOrderBFS(String[] dict, int N, int K) {

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

    public static String findOrderDFS (String[] words, int n, int k) {
        //Construct Adj ===
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<k; i++){
            adj.add(new ArrayList<>());
        }


        for(int d=0; d<words.length-1; d++){
            String str1 = words[d];
            String str2 = words[d+1];
            int minSize = Math.min(str1.length(), str2.length());

            for(int i=0; i< minSize; i++){

                if(str1.charAt(i) != str2.charAt(i)){

                    adj.get(str1.charAt(i) - 'a').add(str2.charAt(i) - 'a');
                    break;

                }

            }

        }

        //Get Topological Sorted List ===
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[k];
        for(int i=0; i<k; i++){
            if(visited[i]==0)
                dfs(i, adj, stack, visited);
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){

            result.append((char)  ('a' + stack.pop()) );

        }

        return result.toString();

    }

    public static void dfs(int src, List<List<Integer>> adj, Stack<Integer> stack, int[] visited ){
        visited[src] = 1;

        for(int k: adj.get(src)){

            if(visited[k] == 0){
                visited[k] = 1;
                dfs(k, adj, stack, visited);
            }

        }

        stack.add(src);

    }



    public static void main(String[] args) {
        String[] arr = new String[]{"baa", "abcd", "abca", "cab", "cad"};
        System.out.println(findOrderBFS(arr, 5, 4));
    }
}
