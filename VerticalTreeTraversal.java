import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class VPair{
    BNode node;
    int vl;
    public VPair(BNode node, int vl){
        this.node = node;
        this.vl = vl;
    }
}
public class VerticalTreeTraversal {

    static ArrayList<Integer> verticalOrder(BNode root)
    {
        // add your code here
        LinkedList<VPair> que = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int minVl = 0,maxVl = 0;
        // -2 -> 4  -1->2 0->1,5
        List<List<Integer>> ans = new ArrayList<>();



        que.addLast(new VPair(root,0));
        while(!que.isEmpty()){

            int size = que.size();
            while(size-- > 0){
                VPair pair = que.removeFirst();

                maxVl = Math.max(maxVl,pair.vl);
                minVl = Math.max(minVl,pair.vl);


                map.putIfAbsent(pair.vl,new ArrayList<>());

                map.get(pair.vl).add(pair.node.data);

                if(pair.node.left != null)
                    que.addLast(new VPair(pair.node.left,pair.vl-1));

                if(pair.node.right != null)
                    que.addLast(new VPair(pair.node.right,pair.vl+1));

            }

        }

        for(int i=minVl; i<=maxVl;i++){
            ans.add(map.get(i));
        }

        //-----------Prepare output
        ArrayList<Integer> finalAns = new ArrayList<>();

        for(List<Integer> list : ans){
            finalAns.addAll(list);
        }


        return finalAns;
    }
}
