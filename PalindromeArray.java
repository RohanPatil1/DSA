public class PalindromeArray {


    public static boolean recursion(int[] arr, int k, int i, int j) {
        if (i > j) return true;

        if (arr[i] == arr[j]) {
            return recursion(arr, k, i + 1, j - 1);
        } else if (arr[i] == k) {
            return recursion(arr, k, i + 1, j);
        } else if (arr[j] == k) {
            return recursion(arr, k, i, j - 1);
        } else {
            return false;
        }
    }


    public static boolean palindromicArray(int n, int[] a, int k) {
        // code here

        return recursion(a, k, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 2, 3, 2, 1, 3};
        int[] arr2 = new int[]{1,2,3,3,4,2,1};
        System.out.println(palindromicArray(arr2.length, arr2, 1));
    }
}
