import java.util.*;

public class SortArrRecursion {

    public static void sortArr(ArrayList<Integer> arr) {

        if (arr.size() == 1) {
            return;
        }

        int temp = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        sortArr(arr);
        insert(arr, temp);
    }

    public static void insert(ArrayList<Integer> arr, int temp) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) <= temp) {
            arr.add(temp);
            return;
        }
        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        insert(arr, temp);
        arr.add(val);
    }

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<>();
        data.add(0);
        data.add(1);
        data.add(5);
        data.add(2);
        sortArr(data);
        System.out.println(data.toString());
    }
}
