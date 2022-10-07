import java.util.Queue;
import java.util.LinkedList;

public class SerializeDeserializeTree {

    // Encodes a tree to a single string.
    public String serialize(BNode root) {

        Queue<BNode> q = new LinkedList<>();

        q.add(root);
        StringBuilder res = new StringBuilder();


        while(!q.isEmpty()){
            BNode node = q.poll();
            if(node == null){
                res.append("null ");
                continue;
            }
            res.append(node.data + " ");

            q.add(node.left);
            q.add(node.right);
        }


        return res.toString();
    }




    // Decodes your encoded data to tree.
    public BNode deserialize(String data) {
        if(data.isEmpty() || data.equals("null ")) return null;

        Queue<BNode> q = new LinkedList<>();

        String[] values = data.split(" ");

        BNode root = new BNode(Integer.parseInt(values[0]));
        q.add(root);

        for(int i=1;i<values.length; i++){

            //Left
            BNode parent  = q.poll();

            if(!values[i].equals("null")){

                BNode currNode = new BNode(Integer.parseInt(values[i]));
                parent.left = currNode;
                q.add(currNode);
            }

            i++;

            //Right
            if(!values[i].equals("null")){

                BNode currNode = new BNode(Integer.parseInt(values[i]));
                parent.right = currNode;
                q.add(currNode);
            }


        }





        return root;
    }
}
