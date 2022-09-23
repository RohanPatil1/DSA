import java.util.Stack;





public class BSTIterator {


    Stack<BNode> stack = new Stack<>();
    public BSTIterator(BNode root) {
        pushAll(root);
    }

    public int next() {
        BNode node = stack.pop();
        pushAll(node.right);

        return node.data;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(BNode node){

        while(node!=null){
            stack.push(node);
            node = node.left;
        }

    }
}

