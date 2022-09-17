public class CheckSurviveOnIsland {

    /*
         N – The maximum unit of food you can buy each day.
         S – Number of days you are required to survive.
         M – Unit of food required each day to survive.
     */
    public static int canSurvive(int S, int N, int M) {
        int noOfSundays = S / 7;
        int daysCanBuy = S - noOfSundays; //9

        int foodReqToSurvive = S * M; //20
        int daysToBuyReqFood = foodReqToSurvive / N; //20/16 = 1  +1
        if (foodReqToSurvive % N != 0) {
            daysToBuyReqFood += 1;
        }

        if(daysToBuyReqFood<=daysCanBuy){
            return daysToBuyReqFood;
        }
        return -1;
    }
}
