public class WordWrapDP {


    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static void printArr(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void wordWrap(int[] arr, int k) {

        int n = arr.length - 1;
        int inf = Integer.MAX_VALUE;
        int[][] space = new int[n + 1][n + 1];
        int[][] ls = new int[n + 1][n + 1];
        int[] p = new int[n + 1];
        int[] c = new int[n + 1];

        //Fill SpaceMatrix with extra spaces for each line & corresponding arr[i]
        for (int i = 1; i <= n; i++) {
            space[i][i] = k - arr[i];
            for (int j = i + 1; j <= n; j++) {
                space[i][j] = space[i][j - 1] - arr[j] - 1;
            }
        }
//        printMatrix(space);
//        System.out.println("-------------------------------------");


        //Fill the LsMatrix with the cost using the extraSpaces formula cost = es*es
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                if (space[i][j] < 0) ls[i][j] = inf;
                else if (j == n && space[i][j] >= 0) ls[i][j] = 0;
                else ls[i][j] = space[i][j] * space[i][j];
            }
        }
//        printMatrix(ls);

        c[0] = 0;
        for (int i = 1; i <= n; i++) {
            c[i] = inf;
            for (int j = 1; j <= i; j++) {
                if (c[j - 1] != inf && ls[j][i] != inf && c[j - 1] + ls[j][i] < c[i]) {
                    c[i] = c[j - 1] + ls[j][i];
                    p[i] = j;
                }
                printArr(c);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 3, 2, 2};
        wordWrap(arr, 4);
    }
}
