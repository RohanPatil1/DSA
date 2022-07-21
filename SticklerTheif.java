public class SticklerTheif {

    static int[] t = new int[1001];

    public static int getMaxProfit(int[] arr, int i, int n) {
        if (i >= n) return 0;
        if (t[i] != -1) return t[i];

        int choice1 = arr[i] + getMaxProfit(arr, i + 2, n);
        int choice2 = getMaxProfit(arr, i + 1, n);

        return t[i] = Math.max(choice1, choice2);
    }

    public static void main(String[] args) {

    }
}
