import java.util.HashMap;
import java.util.Map;

public class LRUcache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, Node> searchMap = new HashMap<>();
    private Node head;
    private Node last;
    private int capacity;

    public LRUcache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        last = new Node(0, 0);

        head.next = last;
        last.prev = head;
    }

    public int get(int key) {

        Node node = searchMap.get(key);
        if (node == null) {
            return -1;
        }

        removeNode(node);
        insertNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (searchMap.containsKey(key)) {
            removeNode(searchMap.get(key));
        }

        if (searchMap.size() == capacity) {
            removeNode(last.prev);
        }

        insertNode(new Node(key, value));
    }


    private void removeNode(Node node) {
        searchMap.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertNode(Node node) {
        searchMap.put(node.key, node);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;

    }


}//LRU cache end




