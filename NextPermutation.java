import java.util.*;

public class NextPermutation {

    static List<Integer> nextPermutation(int n, int arr[]) {
        // code here
        List<Integer> list = new ArrayList<>();
        for (int x : arr) {
            list.add(x);
        }

        // Check where the increasing pattern break
        int k;
        for (k = n - 2; k >= 0; k--) {
            if (list.get(k) < list.get(k + 1)) {
                break;
            }
        }
        System.out.println("K:" + k);
        if (k == -1) {
            Collections.sort(list);
            return list;    
        }

        // Find the nearest greater element
        int g;
        for (g = n - 1; g > k; g--) {
            if (list.get(g) > list.get(k)) {
                break;
            }

        }
        // while (g>k) {
        // System.out.println(g);
        // if (list.get(g) > list.get(k)) {
        // break;
        // }
        // g--;
        // }

        // Swap
        Collections.swap(list, k, g);

        // Sort the rest in descending order
        Collections.sort(list.subList(k + 1, n), Collections.reverseOrder());

        return list;

    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 2, 1 };
        System.out.println(nextPermutation(3, arr).toString());
    }

}
