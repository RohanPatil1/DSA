import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SortKSortedDLL {

    static class CompareNode implements Comparator<ReverseADoublyLL.Node>
    {
        public int compare(ReverseADoublyLL.Node n1, ReverseADoublyLL.Node n2){
            return n1.data-n2.data;
        }
    }
    public static void sortKSorted(ReverseADoublyLL.Node head, int k) {
        PriorityQueue<ReverseADoublyLL.Node> pq = new PriorityQueue<>(new CompareNode());


        ReverseADoublyLL.Node nHead = null, curr = head;
        ReverseADoublyLL.Node temp = null;
        for (int i = 0; curr != null; i++) {
            pq.offer(curr);
            if (!pq.isEmpty() && pq.size() > k) {
                if (nHead == null) {
                    nHead = pq.poll();
                    nHead.prev = null;
                    temp = nHead;
                } else {
                    temp.next = pq.peek();
                    pq.peek().prev = nHead;
                    temp = pq.poll();
                }
            }
            curr = curr.next;
        }

        while(!pq.isEmpty()){
            if(temp!=null){
                temp.next = pq.peek();
                pq.peek().prev = nHead;
                temp = pq.poll();
            }
        }

    }

    public static void main(String[] args) {

    }
}
