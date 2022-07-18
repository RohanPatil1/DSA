public class ReverseLL {


    public static Node reverseLL(Node head) {
        if(head==null || head.next == null)return head;

        Node curr =head,forw=null,prev=null;
        while(curr!=null){
            forw = curr.next;
            curr.next = prev;

            prev = curr;
            curr = forw;
        }
        return prev;
    }

    public static void main(String[] args) {

    }
}
