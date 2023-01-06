import java.util.Arrays;

public class MinArrowToBurstBallon {
    public int findMinArrowShots(int[][] points) {

        ///Sort by end time
        Arrays.sort(points, (a, b)-> Integer.compare(a[1], b[1]));

        int n = points.length;
        int currStretch = points[0][1];
        int arrows = 1;
        for(int i=1; i<n; i++){

            if(points[i][0] > currStretch){
                arrows++;
                currStretch = points[i][1];
            }

        }

        return arrows;
    }
}