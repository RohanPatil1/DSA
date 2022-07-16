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
            if (list.get(k) < list.get(k + 1))
                break;
        }

        if (k == -1) {
            Collections.sort(list);
            return list;
        }

        // Find the nearest greater element
        int g = n - 1;
        while (k < g) {
            if (list.get(g) > list.get(k)) {
                break;
            }
            g--;
        }

        // Swap
        Collections.swap(list, k, g);

        // Sort the rest in descending order
        Collections.sort(list.subList(k + 1, n));

        return list;

    }


    static List<Integer> nextPerm(int[] arr, int n) {
        ArrayList<Integer> arrList = new ArrayList<>();

        for (int num : arr) {
            arrList.add(num);
        }

        //Check where increasing pattern break
        int k = 0; //index
        for (k = n - 2; k >= 0; k--) {
            if (arrList.get(k) < arrList.get(k + 1)) {
                break;
            }
        }

        //Nearest greatest
        int g = n - 1; //index
        while (k < g) {
            if (arrList.get(g) > arrList.get(k)) {
                break;
            }
            g--;
        }

        //Swap
        Collections.swap(arrList, k, g);

        //Sort from k+1 to n-1
        Collections.sort(arrList.subList(k + 1, n));

        return arrList;
    }




    /*

    1 2 3 5 4 2

    1 2 3 4 5 2

   for-> k= 2 (increasing pattern break)
   for-> arr[g]> arr[k]
        1) 2 > 3
        2) 5 > 3
        g = 3
        arr[k] arr[g]
        3      5

    1 2 5 4 3 2
    1 2 5 2 3 4

     */


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 5, 4, 2};
        System.out.println(nextPermutation(arr.length, arr).toString());
    }

}
