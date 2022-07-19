import java.util.HashMap;
import java.util.Map;

class NodeR {
    int data;
    NodeR next;
    NodeR random;

    public NodeR(int data) {
        this.data = data;
    }

    public NodeR(int data, NodeR next, NodeR random) {
        this.data = data;
        this.next = next;
        this.random = random;
    }
}

public class CopyLLWithRandomPtr {


    public static NodeR copyLLUsingMap(NodeR head) {
        if (head == null || head.next == null) return head;
        Map<NodeR, NodeR> map = new HashMap<>();

        NodeR newHead = new NodeR(-1);
        NodeR curr = head, prev = newHead;


        while (curr != null) {
            NodeR newNode = new NodeR(curr.data);
            prev.next = newNode;

            prev = prev.next;
            curr = curr.next;
        }
        newHead = newHead.next;

        NodeR c1 = head;
        NodeR c2 = newHead;
        while (c2 != null) {

            c2.random = (c1.random != null) ? map.get(c1.random) : null;
            c1 = c1.next;
            c2 = c2.next;
        }
        return newHead;
        // O(N) O(N)
    }


    static void copyRandom(NodeR head) {
        NodeR curr = head;
        while (curr != null) {
            NodeR myRandom = curr.random;
            if (myRandom != null) curr.next.random = myRandom.next;

            curr = curr.next.next;
        }

    }

    static NodeR extractCopy(NodeR head) {
        NodeR dummy = new NodeR(-1);
        NodeR prev = dummy, curr = head;

        while (curr != null) {
            prev.next = curr.next;
            curr.next = curr.next.next;

            prev = prev.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static NodeR copyLL2(NodeR head) {
        if (head == null || head.next == null) return head;

        NodeR curr = head;
        while (curr != null) {
            NodeR forw = curr.next;
            NodeR newNode = new NodeR(curr.data);
            curr.next = newNode;
            newNode.next = forw;

            curr = forw;
        }
        copyRandom(head);
        return extractCopy(head);
    }

    public static void main(String[] args) {

    }
}
