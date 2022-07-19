public class FlatteningLL {
    class NodeF {
        int data;
        NodeF next;
        NodeF bottom;

        public NodeF(int data) {
            this.data = data;
        }

        public NodeF(int data, NodeF next, NodeF bottom) {
            this.data = data;
            this.next = next;
            this.bottom = bottom;
        }
    }

    public NodeF merge2FlattenList(NodeF headA, NodeF headB) {

        NodeF dummy = new NodeF(-1);
        NodeF prev = dummy;
        NodeF c1 = headA, c2 = headB;

        while (c1 != null && c2 != null) {
            if (c1.data < c2.data) {
                prev.bottom = c1;
                c1 = c1.bottom;
            } else {
                prev.bottom = c2;
                c2 = c2.bottom;
            }
            prev = prev.bottom;
        }
        prev.bottom = (c1 != null) ? c1 : c2;
        return dummy.bottom;
    }

    public NodeF flattenLL(NodeF head) {
        if (head == null || head.next == null) return head;

        return merge2FlattenList(head, flattenLL(head.next));
    }

    public static void main(String[] args) {

    }
}
