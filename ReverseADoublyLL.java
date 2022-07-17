


public class ReverseADoublyLL {
    class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }


    public static Node reverseADoublyLL(Node head) {
        if (head == null || head.next == null) return head;

        Node last = head;
        Node curr = head;
        while (curr != null) {
            last = curr;
            curr = curr.next;
        }

        //Last Element
        head = last;
        last.next = last.prev;
        last.prev = null;

        curr = last;
        curr = curr.next; // this last's prev element

        //Rest Elements
        while (curr != null) {
            Node forw = curr.next;

            curr.next = curr.prev;
            curr.prev = forw;

            curr = curr.next;
        }

        return last;
    }

    public static void main(String[] args) {

    }

}
