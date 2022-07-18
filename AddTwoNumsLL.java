public class AddTwoNumsLL {


    public static Node addTwoLL(Node l1, Node l2) {
        Node temp = null, res = null, curr = null;

        l1 = ReverseLL.reverseLL(l1);
        l2 = ReverseLL.reverseLL(l2);

        Node first = l1;
        Node second = l2;
        int sum = 0, carry = 0;
        while (first != null || second != null) {

            //Add digits
            sum = carry + ((first != null) ? first.data : 0) + ((second != null) ? second.data : 0);
            carry = sum / 10;
            sum = sum % 10;

            //Store the digit sum in the new LL
            temp = new Node(sum);
            if (res == null) res = temp;
            else curr.next = temp;

            curr = temp;
            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }

        if (carry > 0) {
            temp = new Node(carry);
            curr.next = temp;
            curr = temp;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
