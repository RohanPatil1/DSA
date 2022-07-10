

public class IsCycleInLL {


    public static boolean isCycle(ReverseLL.Node head) {

        if (head == null || head.next == null) return false;

        ReverseLL.Node slow = head;
        ReverseLL.Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) return true;
        }
        return false;
    }

    public static ReverseLL.Node cycleStartingPoint(ReverseLL.Node head) {

        if (head == null || head.next == null) return null;

        ReverseLL.Node slow = head;
        ReverseLL.Node fast = head;
        ReverseLL.Node entry = head;
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
