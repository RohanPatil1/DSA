class NumMatrix {

    int[][] prefix = new int[205][205];

    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = matrix[i - 1][j - 1] + (prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1]);
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
    }
}

//TODO https://leetcode.com/discuss/interview-question/850974/hackerrank-online-assessment-roblox-new-grad-how-to-solve-this