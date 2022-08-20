public class isSymmetricTree {

    public static boolean solve(BNode r1,BNode r2){
        if(r1==null && r2==null) return true;
        if(r1==null || r2==null) return false;


        if(r1.data != r2.data) return false;

        return solve(r1.left,r2.right) && solve(r1.right,r2.left);
    }


    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(BNode root)
    {
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        if(root.left==null || root.right==null) return false;

        return solve(root.left,root.right);

    }
}
