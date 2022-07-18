import java.util.*;
import java.util.LinkedList;

public class MaxInSlidingWindow {
    // https://www.geeksforgeeks.org/deque-interface-java-example/

    public static ArrayList<Integer> getMaxs(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        // Store the currMax of the currWindow and pop all the previous elements smaller
        // than arr[k]
        Deque<Integer> list = new LinkedList<>();

        int i = 0, j = 0;
        int size = arr.length;
        while (j < size) {

            // If list is empty, add first
            if (list.size() == 0) {
                list.add(arr[j]);
            } else {
                // if arr[j]>3 then arr[j]>2 ...[ 1,2,3] , remove all smaller than arr[j] and
                // the push arr[j]
                while (list.size() > 0 && list.peekLast() < arr[j]) {
                    list.removeLast();
                }
                list.add(arr[j]);
            }

            // Windown size is less than required k
            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                // Window Size matches

                // Get Ans add front i.e the max in result array
                result.add(list.peek());

                // Remove calc for i
                /*
                 * if arr[i] was the max and so was pushed to the list, we remove it, else it
                 * was never used
                 * so no need for calc for arr[i]
                 */
                if (arr[i] == list.peek()) {
                    list.removeFirst();
                }

                i++;
                j++;
            }
        }

        return result;
    }

  
    public static void main(String[] args) {

        int[] arr = { 7,2,4 };
        ArrayList<Integer> res = getMaxs(arr, 2);
        System.out.println(res.toString());


    }
}
