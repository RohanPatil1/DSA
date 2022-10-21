//public class DivideChocolates {
//
//    public static boolean isValid(int[] arr, int k, int limit){
////         int sum =0;
////         int splits = 0;
////         for(int curr : arr){
////             sum += curr;
////             if(sum >= limit){
////                 splits++;
////                 sum = 0;
////             }
////         }
//
////         return splits >= (k+1);
//        int sum =0;
//        int splits=0;
//        for(int curr : arr){
//            sum += curr;
//            if(sum >= limit){
//                sum =curr;
//                splits++;
//                if(splits > k) return false;
//            }
//        }
//
//        return true;
//    }
//
//    public static int getMaximumSweetness(int[] arr, int k) {
//
//        int  sum = 0;
//        for(int curr: arr){
//            sum += curr;
//        }
//
//        int left = 0;
//        int right = sum;
//        int mid = 0;
//        while(left < right){
//            mid = left + (right - left)/2;
//            if( isValid(arr, k, mid) ) right = mid;
//            else left = mid +1;
//        }
//        return left;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(getMaximumSweetness(new int[]{1,2,3,4,5,6,7,8,9},5));
//    }
//}
