public class KokoEatingBananas {
    public int calculateTime(int mid, int[] piles){

        int time = 0;

        for(int i=0;i<piles.length;i++){

            time += (piles[i]/mid);
            if((piles[i]%mid)!=0){
                time +=1;
            }

            //time += Math.ceil(piles[i]/mid); //if not divisible then additional +1  3/5 = 0 + 1 = 1

        }

        return time;
    }
    public int minEatingSpeed1(int[] piles, int h) {
         int low=0;
         int high =0;
         for(int curr : piles) high = Math.max(high, curr);

         int ans = 0;
         while(low<=high){

             int mid = low + (high - low)/2;
             if(mid==0) break;
             int time = calculateTime(mid, piles);
             if(time <= h){
                 ans = mid;
                 high = mid - 1;
             }else{
                 low = mid + 1;
             }

         }

         return ans;
    }


    ///A2----------------------
    public int minEatingSpeed2(int[] piles, int h) {
        int left =1, right=0, mid=0;

        for(int curr : piles) right = Math.max(right, curr);


        while(left < right){

            mid = left + (right - left)/2;

            if(isValid(piles, mid, h)){
                right = mid;
            }else{
                left = mid + 1;
            }


        }

        return left;
    }

    public boolean isValid(int[] arr, int speed, int hourLimit){

        int time = 0;

        for(int pile : arr){
            time += pile/speed;
            if(pile % speed != 0){
                time += 1;
            }

            if(time > hourLimit) return false;

        }


        return true;
    }


}
