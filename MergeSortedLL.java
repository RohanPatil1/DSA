public class MergeSortedLL {


    public static Node merge2SortLL(Node headA, Node headB) {

        Node currA = headA;
        Node currB = headB;
        Node dummy = new Node(-1);
        Node prev = dummy;
        while (currA != null && currB != null) {
            if (currA.data > currB.data) {
                prev.next = currB;
                currB = currB.next;
            } else {
                prev.next = currA;
                currA = currA.next;
            }
            prev = prev.next;
        }

        prev.next = (currA!=null)?currA:currB;

        return dummy.next;
    }

}
