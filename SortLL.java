public class SortLL {


    public static Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = LinkedList.midNode(head);
        Node nHead = mid.next;
        mid.next = null;

        Node l1 = mergeSort(head);
        Node l2 = mergeSort(nHead);

        return MergeSortedLL.merge2SortLL(l1, l2);
    }

    public static void main(String[] args) {

    }
}
