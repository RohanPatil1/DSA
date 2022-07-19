public class RotateLL {


    public static Node rightRotate(Node head, int k) {
        if (head == null || head.next == null) return head;


        int n = 0;
        Node tail = head;
        while (tail != null) {
            tail = tail.next;
            n++;
        }
        if (k % n == 0) return head;
        tail.next = head;
        k = k % n;


        Node temp = head;
        while (k != 0) {
            tail = temp;
            temp = temp.next;
            k--;
        }
        tail.next = null;
        head= temp;
        return head;
    }


    public static void main(String[] args) {

    }
}
