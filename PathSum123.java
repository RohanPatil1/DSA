import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PathSum123 {

    ///-----------------PATH SUM 1
    //Find if the there is path from root to leaf which matches the sum as targetSum
    public static boolean pathSum1(BNode root, int targetSum) {
        return dfsPATH_SUM1(root, targetSum);
    }

    private static boolean dfsPATH_SUM1(BNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            //Lastly Subtract the leaf node
            return (targetSum - root.data) == 0;
        }
        return dfsPATH_SUM1(root.left, targetSum - root.data) || dfsPATH_SUM1(root.right, targetSum - root.data);
    }


    ///-----------------PATH SUM 2
    //Find all the paths from root to leaf which matches the sum as targetSum
    public static List<List<Integer>> pathSum2(BNode root, int targetSum) {

        List<List<Integer>> pathList = new ArrayList<>();
        dfsPATH_SUM2(root, targetSum, new ArrayList<>(), pathList);
        return pathList;
    }

    /*
    Java has shallow copying, if added currPathList to res & then made some changes to the currPathList
    that will reflect in currPathList stored in pathList. This is called Shallow Copy.
     */
    private static void dfsPATH_SUM2(BNode root, int targetSum, ArrayList<Object> currPathList, List<List<Integer>> pathList) {
        if (root == null) return;

        currPathList.add(root.data);
        if (root.left == null && root.right == null) {
            if ((targetSum - root.data) == 0) {
                //Deep copying
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.data);
                pathList.add(list);
            }
        }

        dfsPATH_SUM2(root.left, targetSum - root.data, currPathList, pathList);
        dfsPATH_SUM2(root.right, targetSum - root.data, currPathList, pathList);

        //Going up remove previous i.e last element
        currPathList.remove(currPathList.size() - 1);
    }

    ///-----------------PATH SUM 3
    //Find all the path count which has sum as target sum. Not necessary to end with leaf.

    static int total = 0;

    //This function takes a node and tells how many paths have sum as targetSum from that node
    public static void findPathSum(BNode root, int sum, int targetSum) {
        if (root == null) return;

        sum += root.data;

        if (sum == targetSum) {
            total++;
        }

        findPathSum(root.left, sum, targetSum);
        findPathSum(root.right, sum, targetSum);
    }

    //This uses findPathSum for every node and gets the total count of paths with targetSum
    //O(N^2)
    public static int pathSum3(BNode root, int targetSum) {

        if (root == null) return 0;

        findPathSum(root, 0, targetSum);
        pathSum3(root.left, targetSum);
        pathSum3(root.right, targetSum);
        return total;
    }


    //PathSum3 using HashMap Time= O(N) Space = O(N)
    public int pathSum3HM(BNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return findPathSumHM(root, 0, sum, preSum);
    }

    public int findPathSumHM(BNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }

        currSum += root.data;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        res += findPathSumHM(root.left, currSum, target, preSum) + findPathSumHM(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }

}
