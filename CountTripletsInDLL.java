public class CountTripletsInDLL {




    public static int countTriplets(ReverseADoublyLL.Node head, int X) {
        int count = 0;
        if (head == null || head.next == null) return count;

        ReverseADoublyLL.Node curr = head;
        ReverseADoublyLL.Node last = head;

        while (last.next != null) {
            last = last.next;
        }


        while (curr.next != null) {
            int firstVal = curr.data;
            ReverseADoublyLL.Node start = curr.next;
            int newTarget = X - firstVal;
            while (start != last && start.next != last) {
                int pairValue = start.data + last.data;
                if (pairValue == newTarget) {
                    count++;
                    start = start.next;
                    last = last.prev;
                } else if (pairValue > newTarget) {
                    last = last.prev;
                } else {
                    start = start.next;
                }
            }
            curr = curr.next;
        }

        return count;
    }
}
