import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        int minR = 0,minC =0;
        int maxR = n-1,maxC = m-1;

        int count=0,total = n*m;


        while(count<total){


            //left wall
            for(int i=minR,j=minC; j <= maxC && count<total;j++){
                ans.add(matrix[i][j]);
                count++;
            }
            minR++;


            //right wall
            for(int i=minR,j=maxC; i<=maxR && count<total;i++){
                ans.add(matrix[i][j]);
                count++;
            }
            maxC--;


            //bottom wall
            for(int i=maxR,j=maxC; j>=minC && count<total;j--){
                ans.add(matrix[i][j]);
                count++;
            }
            maxR--;


            //left wall
            for(int i=maxR,j=minC; i>=minR && count<total;i--){
                ans.add(matrix[i][j]);
                count++;
            }
            minC++;

        }

        return ans;

    }

}
