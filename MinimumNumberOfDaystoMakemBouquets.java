public class MinimumNumberOfDaystoMakemBouquets {

    public int minDays(int[] bloomDay, int m, int k) {

//        if (bloomDay.length < m * k  || m*k < 0) return -1;
        if (bloomDay.length < m * k) return -1; //don't have enough flowers


        int left = 1, right = 0, mid;
        for (int curr : bloomDay) {
            left = Math.min(left, curr);
            right = Math.max(right, curr);

        }

        while (left < right) {

            mid = left + (right - left) / 2;

            if (isValid(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }
        //left will have the minimal solution for isValid()
        return left;
    }


    public boolean isValid(int[] bloomDays, int bqNeeded, int flowersNeededForBq, int days) {

        // [7,7,7,7,12,7,7], m = 2, k = 3  days = 7

        int currBqCount = 0, currFlowers = 0;


        for (int bloomDay : bloomDays) {
            if (bloomDay <= days) {
                currFlowers++;
            } else {
                currFlowers = 0;
            }

            if (currFlowers == flowersNeededForBq) {
                currBqCount++;
                currFlowers = 0;
            }

        }


        return currBqCount >= bqNeeded;
    }


}
