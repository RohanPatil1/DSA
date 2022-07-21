public class MaxSumProblemDP {


    public static int maxSumProblem(int n) {
        if (n <= 1) return n;


        int a = maxSumProblem(n / 2);
        int b = maxSumProblem(n / 3);
        int c = maxSumProblem(n / 4);

        if (a + b + c > n) return a + b + c;
        else return n;

    }

    public static void main(String[] args) {

    }
}
