public class ReverseKGroups {


    static Node ot = null, oh = null, th = null, tt = null;

    public static int getLength(Node head) {
        int len = 0;
        Node curr = head;

        while (curr != null) {
            len++;
            curr = curr.next;
        }
        return len;
    }

    public static void addFirstNode(Node node) {
        if (th == null) {
            th = node;
            tt = node;
        } else {
            node.next = th;
            th = node;
        }
    }

    public static Node reverseKGroup(Node head, int k) {
        if (head == null || head.next == null) return head;
        Node curr = head, forw = null;

        int size = getLength(head);
        while (size >= k) {
            int tempK = k;
            while (tempK != 0) {
                forw = curr.next;
                curr.next = null;
                addFirstNode(curr);
                curr = forw;
                tempK--;
            }

            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }
            tt = null;
            th = null;
            size -= k;
        }

        //Handle left out residue
        ot.next = curr;
        return oh;
    }


    public static void main(String[] args) {

    }
}
