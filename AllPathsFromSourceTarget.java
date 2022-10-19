import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {



        List<List<Integer>> resultList = new ArrayList<>();

        List<Integer> currList = new ArrayList<>();
        currList.add(0);
        dfs(0, graph, currList, resultList);

        return resultList;
    }


    public void dfs(int src, int[][] graph, List<Integer> currList, List<List<Integer>> resultList){

        if(src == graph.length - 1){
            resultList.add(new ArrayList<>(currList));
            return;
        }

        for(int k : graph[src]){

            currList.add(k);

            dfs(k, graph, currList, resultList);

            currList.remove(currList.size() - 1);
        }




    }
}
