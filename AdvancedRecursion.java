import java.util.*;

public class AdvancedRecursion {

    public static void getAllPermutation(String s, String permutation) {
        if (s.length() == 0) {
            System.out.println(permutation);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            // "abc" => "bc" b c
            String remainingStr = s.substring(0, i) + s.substring(i + 1);
            getAllPermutation(remainingStr, permutation + currChar);

        }

    }

    // Total Paths in Maze from (0,0) to (n,m)
    public static int getAllPaths(int i, int j, int n, int m) {

        // We are at boundary
        if (i == n || j == m) {
            return 0;
        }

        // Reached (n,m)
        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        // Move Down (i+1.j)
        int downPaths = getAllPaths(i + 1, j, n, m);

        // Move Right (i,j+1)
        int rightPaths = getAllPaths(i, j + 1, n, m);

        return downPaths + rightPaths;
    }

    // Place Tile of Size 1xm with floor size of nxm
    public static int placeTiles(int n, int m) {

        // BaseCases

        // We will get 2 ways (For eg, 2x2 with tile 1x2, we can place 2 horizontally or
        // 2 vertically)
        if (n == m) {
            return 2;
        }

        // Only horizontally since it wont fit vertically 3x4 with 1x4 so we cannot
        // place vertically since its 4
        if (n < m) {
            return 1;
        }

        // Placing it vertically n-m
        int verticalPlacements = placeTiles(n - m, m);

        // Placing it horizontally n-1
        int horizontalPlacements = placeTiles(n - 1, m);

        return verticalPlacements + horizontalPlacements;
    }


    ///Find number of ways in which you can invite n people to your party,single or pairs

    public static int getWaysToInvite(int n){
        
        if(n<=1){
            return 1;
        }

        //Single
        int smallOutput1 = getWaysToInvite(n-1);

        //Pairs select 1 so (n-1) and to pair we will have (n-2) options
        int smallOutput2 = (n-1)*getWaysToInvite(n-2);

        return smallOutput1+smallOutput2;


    }





    public static void generateSubset(int n,ArrayList<Integer> subset){
        if(n==0){

            //Print subset
            for(int i=0;i<subset.size();i++){
                System.out.print(subset.get(i));
            }
            System.out.println();
            return;
        }



        //Add to subset
        subset.add(n);
        generateSubset(n-1, subset);

        //Does not add
       subset.remove(subset.size()-1);
        generateSubset(n-1, subset);


        

    }


    public static void main(String[] args) {

        String s = "abc";
        getAllPermutation(s, "");
        System.out.println("---------------------------------");
        int n = 3, m = 3;
        int result = getAllPaths(0, 0, n, m);

        System.out.println(result);

        System.out.println("---------------------------------");
        int x = 4, y = 2;
        System.out.println(placeTiles(x, y));
        System.out.println("---------------------------------");
        
        System.out.println(getWaysToInvite(4));
        System.out.println("---------------------------------");
        ArrayList<Integer> arr  = new ArrayList<Integer>();
        generateSubset(3, arr);
    }

}
