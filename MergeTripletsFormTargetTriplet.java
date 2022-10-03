import java.util.Arrays;

public class MergeTripletsFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        int n = triplets.length;

        int[] res = new int[]{0,0,0};

        for(int[] triplet : triplets){

            if(triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<=target[2]){

                res[0] = Math.max(res[0], triplet[0]);
                res[1] = Math.max(res[1], triplet[1]);
                res[2] = Math.max(res[2], triplet[2]);

            }

        }


        return Arrays.equals(res, target);
    }
}
