public class IsSubTree {

    public static boolean isSubtree(BNode root, BNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;


        if(root.data == subRoot.data){

            if(isIdentical(root,subRoot)){
                return true;
            }

        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right,subRoot);
    }

    public static boolean isIdentical(BNode root,BNode subRoot){

        if(root == null && subRoot==null) return true;
        if(root == null || subRoot==null) return false;


        if(root.data==subRoot.data){
            return isIdentical(root.left,subRoot.left) && isIdentical(root.right,subRoot.right);
        }else{
            return false;
        }

    }

    public static void main(String[] args) {

    }
}
