public class PartitionList {

    public static Node partitionList(Node head, int k) {
        Node smaller = new Node(0), bSmaller = smaller;
        Node greater = new Node(0), bGreater = greater;

        Node curr = head;
        while (curr != null) {
            if (curr.data < k) {
                smaller.next = curr;
                smaller = smaller.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }

        //Now Join
        smaller.next = bGreater;
        greater.next = null;
        return bSmaller.next;
    }


    public static void main(String[] args) {

    }
}
