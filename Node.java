public class Node {
    int data;
    Node next;

    public Node() {
        this.next = null;
        this.data = -1;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}