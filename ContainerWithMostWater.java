public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int n = height.length;
        int i=0,j=n-1;
        int maxArea = 0;

        while(i<j){

            int pillarOne = height[i];
            int pillarTwo = height[j];

            int width = j - i ;
            int minHeight = Math.min(pillarOne, pillarTwo);
            maxArea = Math.max(maxArea, minHeight*width);

            if(pillarOne > pillarTwo){
                j--;
            }else{
                i++;
            }

        }

        return maxArea;
    }

}
