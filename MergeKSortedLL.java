public class MergeKSortedLL {


    public Node mergeTwoLL(Node l1, Node l2) {
        if (l1 == null || l2 == null) return l1 != null ? l1 : l2;

        Node dummyNode = new Node(-1);
        Node prev = dummyNode;

        Node c1 = l1;
        Node c2 = l2;

        while (c1 != null && c2 != null) {
            if (c1.data < c2.data) {
                prev.next = c1;
                c1 = c1.next;
            } else {
                prev.next = c2;
                c2 = c2.next;
            }
            prev = prev.next;
        }

        prev.next = c1 != null ? c1 : c2;
        return dummyNode.next;


    }

    public Node mergeKList(Node[] nodeList, int si, int ei) {
        if (si > ei) return null;
        if (si == ei) return nodeList[si];

        int mid = si + (ei - si) / 2;
        Node l1 = mergeKList(nodeList, si, mid);
        Node l2 = mergeKList(nodeList, mid + 1, ei);

        return mergeTwoLL(l1, l2);
    }

    public Node mergeKList(Node[] nodeList) {
        if (nodeList.length == 0) return null;
        return mergeKList(nodeList, 0, nodeList.length - 1);
    }


}
