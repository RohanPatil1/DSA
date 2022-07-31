public class MaxSumProblemDP {


    public static int maxSumProblem(int n) {
        if (n <= 1) return n;

        System.out.println("N: "+n);
        int a = maxSumProblem(n / 2);
        int b = maxSumProblem(n / 3);
        int c = maxSumProblem(n / 4);

        int total = a+b+c;
        System.out.println("Total : "+total);
        if (total > n) return total;
        else return n;

    }

    public static void main(String[] args) {
        System.out.println(maxSumProblem(12));
    }
}
