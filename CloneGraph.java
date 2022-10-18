import java.util.LinkedList;
import java.util.*;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {

        if(node == null) return null;

        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        //Add first node
        q.add(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while(!q.isEmpty()){
            Node currNode = q.poll();

            for(Node adjNode : currNode.neighbors){

                if(!map.containsKey(adjNode)){
                    map.put(adjNode, new Node(adjNode.val, new ArrayList<>()));
                    q.add(adjNode);
                }

                map.get(currNode).neighbors.add(map.get(adjNode));

            }

        }

        return map.get(node);
    }
}
