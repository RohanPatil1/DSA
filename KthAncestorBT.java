import java.util.Stack;

public class KthAncestorBT {
//Approach 1 is make an array and get the kth
public boolean find(BNode root, int target, Stack<Integer>s){
    if(root == null)
        return false;

    if(root.data == target)
        return true;

    s.push(root.data) ;

    if(find(root.left, target, s))
        return true;

    if(find(root.right, target, s))
        return true;

    s.pop();

    return false;
}

    public int kthAncestor(BNode root, int k, int node){
        Stack<Integer> s = new Stack<>();
        find(root, node, s);

        int ans = -1;
        if(k > s.size())
            return ans;

        while(k-- > 0){
            ans = s.pop();
        }
        //System.out.println(s);
        //System.out.println(ans);
        return ans;
    }




    int kValue = 0;
    public int kthAncestor2(BNode root, int k, int BNode)
    {

        kValue = k;
        BNode ans = solve(root, BNode);
        if(ans == null || ans.data == BNode) return -1;


        return ans.data;
    }


    public BNode solve(BNode root, int BNode){
        if(root == null) return null;

        if(root.data == BNode) return root;


        BNode left = solve(root.left, BNode);
        BNode right = solve(root.right, BNode);

        if(left != null && right == null){
            kValue--;
            if(kValue<=0){
                kValue = Integer.MAX_VALUE;
                return root;
            }
            return left;

        }
        if(left == null && right != null){
            kValue--;
            if(kValue<=0){
                kValue = Integer.MAX_VALUE;
                return root;
            }
            return right;
        }

        //Did not found BNode
        return null;
    }

}
