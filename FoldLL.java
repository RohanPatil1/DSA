public class FoldLL {

    public Node foldLL(Node head) {
        Node mid = LinkedList.midNode(head);
        Node nHead = mid.next;
        mid.next = null;

        nHead = ReverseLL.reverseLL(head);

        Node c1 = head;
        Node c2 = nHead;

        Node f1 = null, f2 = null;

        while (c2 != null) {
            f1 = c1.next;
            f2 = c2.next;

            //Move links
            c1.next = c2;
            c2.next = f1;

            c1 = f1;
            c2 = f2;
        }
        return head;
    }


    public static void main(String[] args) {

    }

}
