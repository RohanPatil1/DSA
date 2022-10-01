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


    //-----------Simplified
    public static Node addTwoLLs(Node l1, Node l2) {
        Node dummy = new Node(); //head of resultant linked list
        Node temp = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry > 0) {

            int sum = 0;
            if (l1 != null) {
                sum += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.data;
                l2 = l2.next;
            }

            sum += carry;

            //sum = 13   carry =13/10=1 sum = 13%10 =3
            carry = sum / 10;

            //Create a new node for res
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next;
        }


        return dummy.next;
    }

    public static void main(String[] args) {

    }
}
