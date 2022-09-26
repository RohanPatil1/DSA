public class UniqueBSTs {


    /*

Let numTrees( i ) denote the number of nodes on the left side of the root.
That implies numTrees(n - i - 1) denotes the number of nodes on the right side of the root.
Hence the total number of BSTs possible will be : numTrees(i) * numTrees(n -  i - 1) for a given root.
Total number of BSTs possible will be : n * numTrees(i) * numTrees(n-i-1) , where n is number of different root configurations.
Therefore loop from 1 to n and for every ‘i’ add numTrees(i) * numTrees(n-i-1) to the answer.
Return the final answer.
     */

    //Just Calculate Catalan Number
    public static long numTrees(int n) {
        // Base case.
        if (n == 0 || n == 1) {
            return 1;
        }

        long answer = 0;

        for (int i = 1; i <= n; i++) {
            answer += (numTrees(n - i) * numTrees(i - 1));
        }

        return answer;
    }
}
