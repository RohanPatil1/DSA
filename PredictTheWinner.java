public class PredictTheWinner {

    static int[][] t = new int[1001][1001];

    public static int getPlayer1Score(int[] arr, int i, int j) {
        if (i > j) return 0;
        if (t[i][j] != -1) return t[i][j];

        int choice1 = arr[i] + Math.min(getPlayer1Score(arr, i + 2, j), getPlayer1Score(arr, i + 1, j - 1));
        int choice2 = arr[j] + Math.min(getPlayer1Score(arr, i + 1, j - 1), getPlayer1Score(arr, i, j - 2));

        return t[i][j]=Math.max(choice1, choice2);
    }

    public static boolean predictTheWinner(int[] nums) {
        int totalPoints = 0;
        for (int a : nums) totalPoints += a;

        int player1 = getPlayer1Score(nums, 0, nums.length - 1);
        int player2 = totalPoints - player1;

        return player1 >= player2;
    }

    public static void main(String[] args) {
        System.out.println(predictTheWinner(new int[]{1, 5, 233, 7}));
    }
}
