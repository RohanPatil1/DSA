public class CatalanNumber {


    public static int catalanNumber(int n) {

        int res = 0;
        if (n <= 1) return 1;


        for (int i = 0; i < n; i++) {
            res += catalanNumber(i) * catalanNumber(n - i - 1);
        }

        return res;
    }

    static int catalanDP(int n)
    {
        // Table to store results of subproblems
        int catalan[] = new int[n + 2];

        // Initialize first two values in table
        catalan[0] = 1;
        catalan[1] = 1;

        // Fill entries in catalan[]
        // using recursive formula
        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i]
                        += catalan[j] * catalan[i - j - 1];
            }
        }

        // Return last entry
        return catalan[n];
    }


}
