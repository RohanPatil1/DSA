public class IsPalindromeLL {


    public static boolean isPalindrome(Node head) {

        Node mid = LinkedList.midNode(head);
        Node nHead = mid.next;
        mid.next = null;

        nHead = ReverseLL.reverseLL(nHead);

        Node c1 = head;
        Node c2 = nHead;
        boolean ans = true;
        while (c1 != null && c2 != null) {
            if (c1.data != c2.data) {
                ans = false;
                break;
            }
            c1 = c1.next;
            c2 = c2.next;
        }

        //Revert the original LL
        nHead = ReverseLL.reverseLL(nHead);
        mid.next = nHead;
        return ans;
    }


    public static void main(String[] args) {

    }
}
