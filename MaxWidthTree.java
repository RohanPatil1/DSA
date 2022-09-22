import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthTree {


    class PointP {
        BNode node;
        int index;


        public PointP(BNode node, int index) {
            this.node = node;
            this.index = index;
        }

    }


    public int widthOfBinaryTree(BNode root) {
        int maxWidth = 0;
        Queue<PointP> q = new LinkedList<>();
        q.add(new PointP(root,0));

        while(!q.isEmpty()){
            int size = q.size();
            System.out.println(size);
            int leftMostIndex = q.peek().index;
            int rightMostIndex = q.peek().index; //will be updated
            for(int i=0;i<size;i++){

                PointP p = q.poll();

                rightMostIndex = p.index;

                if(p.node.left != null){
                    q.add(new PointP(p.node.left, 2*p.index +1 ));
                }
                if(p.node.right != null){
                    q.add(new PointP(p.node.right, 2*p.index +2));
                }

            }
            maxWidth = Math.max(maxWidth,rightMostIndex - leftMostIndex + 1 );

        }

        return maxWidth;

    }

}
