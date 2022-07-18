

public class IsCycleInLL {


    public static boolean isCycle( Node head) {

        if (head == null || head.next == null) return false;

         Node slow = head;
         Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    public static  Node cycleStartingPoint( Node head) {

        if (head == null || head.next == null) return null;

         Node slow = head;
         Node fast = head;
         Node entry = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (slow != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }
        return null;
    }


    public static void main(String[] args) {

    }
}
