
import java.util.*;

public class SortStackRecursion {

    public static void sortStack(Stack<Integer> s) {

        if (s.size() == 1) {
            return;
        }
        int temp = s.peek();
        s.pop();
        sortStack(s);
        insert(s, temp);
    }

    public static void insert(Stack<Integer> s, int temp) {
        if (s.size() == 0 || s.peek() <= temp) {
            // If temp is largest then insert on top
            s.push(temp);
            return;
        }

        int val = s.peek();
        s.pop();
        insert(s, temp);
        s.push(val);
    }

    public static void deleteMidFromStack(Stack<Integer> s, int k) {
        if (k == 1) {
            s.pop();
            return;
        }

        int temp = s.pop();
        deleteMidFromStack(s, k - 1);
        s.push(temp);
        return;
    }

    public static void reverseStack(Stack<Integer> s) {
        if (s.size() == 1) {
            return;
        }
        int temp = s.pop();
        reverseStack(s);
        insertBottom(s, temp);
        return;

    }

    public static void insertBottom(Stack<Integer> s, int ele) {
        if (s.size() == 0) {
            s.push(ele);
            return;
        }
        int temp = s.pop();
        insertBottom(s, ele);
        s.push(temp);
        return;
    }


    public static void main(String[] args) {
        Stack<Integer> data = new Stack<>();
        data.push(0);
        data.push(1);
        data.push(5);
        data.push(2);
        data.push(7);

        sortStack(data);
        System.out.println(data.toString());

        deleteMidFromStack(data, 3);
        System.out.println(data.toString());

        reverseStack(data);
        System.out.println(data.toString());

    }
}
