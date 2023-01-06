import java.util.Arrays;

public class MaximumIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);
        int bought = 0;

        for(int cost : costs){
            if(coins >= cost){
                bought++;
                coins -= cost;
            }
        }

        return bought;
    }
}
