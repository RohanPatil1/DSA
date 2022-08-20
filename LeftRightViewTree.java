import java.util.ArrayList;

public class LeftRightViewTree {

    void rightViewHelper(BNode root,ArrayList<Integer> list,int level){

        if(root == null) return;


        if(level == list.size()) list.add(root.data);


        rightViewHelper(root.right,list,level+1);
        rightViewHelper(root.left,list,level+1);


    }

    ArrayList<Integer> rightView(BNode node) {

        ArrayList<Integer> ans= new ArrayList<>();

        rightViewHelper(node,ans, 0);

        return ans;
    }

    void leftViewHelper(BNode root, ArrayList<Integer> list, int level) {

        if (root == null) return;

        if (level == list.size()) {
            list.add(root.data);
        }


        leftViewHelper(root.left, list, level + 1);

        leftViewHelper(root.right, list, level + 1);

    }


    ArrayList<Integer> leftView(BNode root) {
        ArrayList<Integer> ansList = new ArrayList<>();
        leftViewHelper(root, ansList, 0);

        return ansList;

    }

    public static void main(String[] args) {

    }
}
