public class PizzaWith3nSlices {


    //--------A1------
    public int maxSizeSlices(int[] slices) {

        int n = slices.length;
        int poss1 = solve(0, n - 2, slices, n / 3);
        int poss2 = solve(1, n - 1, slices, n / 3);


        return Math.max(poss1, poss2);
    }


    public int solve(int start, int end, int[] slices, int quantity) {

        if (quantity == 0) return 0;

        if (start > end) return 0;

        int include = slices[start] + solve(start + 2, end, slices, quantity - 1);
        int notInclude = solve(start + 1, end, slices, quantity);


        return Math.max(include, notInclude);
    }


    //------------A2-------------

    public int maxSizeSlicesTAB(int[] slices) {

        int n = slices.length;
//        int poss1 = solve(0, n-2, slices, n/3);
//        int poss2 = solve(1, n-1, slices, n/3);

        int[][] dp1 = new int[n+2][n];
        int[][] dp2 = new int[n+2][n];
        int poss1 = 0, poss2 = 0;
        for (int start = n - 2; start >= 0; start--) {
            for (int quantity = 1; quantity <= n / 3; quantity++) {
                int include = slices[start] + dp1[start + 2][quantity - 1];
                int notInclude = dp1[start + 1][quantity];

                dp1[start][quantity] = Math.max(include, notInclude);
            }
        }
        poss1 = Math.max(poss1, dp1[0][n / 3]);

        for (int start = n - 1; start >= 1; start--) {
            for (int quantity = 1; quantity <= n / 3; quantity++) {
                int include = slices[start] + dp2[start + 2][quantity - 1];
                int notInclude = dp2[start + 1][quantity];

                dp2[start][quantity] = Math.max(include, notInclude);
            }
        }
        poss2 = Math.max(poss2, dp2[1][n / 3]);

        return Math.max(poss1, poss2);
    }

}
