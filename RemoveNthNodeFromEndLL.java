public class RemoveNthNodeFromEndLL {


    public static Node removeNthNode(Node head, int n) {
        Node start = new Node();
        start.next = head;
        Node fast = start, slow = head;

        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return start.next;
    }


    public static void main(String[] args) {

    }

}
