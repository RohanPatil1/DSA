public class PairwiseSwapNodeLL {


    public static Node pairSwap(Node head) {
        Node dummy = new Node(-1);
        Node prev = dummy, curr = head;

        while (curr != null && curr.next != null) {

            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = curr;
            curr = curr.next;
            prev = prev.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

    }

}
