public class IntersectionTwoLL {


    public static Node getIntersection(Node headA, Node headB) {
        int lenA=1,lenB=1;

        Node currA = headA;
        Node currB = headB;

        while(currA.next!=null){
            currA = currA.next;
            lenA++;
        }
        while(currB.next!=null){
            currB = currB.next;
            lenB++;
        }

        if(headA.next==null && headB.next==null){
            if(headA==headB){return headA;}
        }


        Node fast,slow;
        if(lenA>=lenB){
            fast = headA;
            slow = headB;
        }else{
            fast = headB;
            slow = headA;
        }

        int dist = Math.abs(lenA-lenB);

        for(int i=1;i<=dist;i++){
            fast = fast.next;
        }

        if(fast==slow){
            return fast;
        }

        while(fast!=slow){

            fast = fast.next;
            slow = slow.next;
            if(fast==slow){
                return fast;
            }
        }

        return null;
    }

    public static void main(String[] args) {

    }

}
