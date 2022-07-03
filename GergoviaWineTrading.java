import java.util.Comparator;

class Pair {
    int value;
    int index;

    public Pair(int value, int index) {
        this.value = value;
        this.index = index;
    }
}

public class GergoviaWineTrading {


    public static int getMinSteps(int[] arr, int n) {
        int steps = 0;

        Pair[] buy = new Pair[n];
        Pair[] sell = new Pair[n];
        int i = 0, j = 0;

        for (int k = 0; k < n; k++) {
            if (arr[i] > 0) {
                buy[i] = new Pair(arr[i], i);
            } else if (arr[i] < 0) {
                sell[i] = new Pair(arr[i], i);
            }
        }


        while (i < buy.length && j < sell.length) {
            int min = Math.min(buy[i].value, -sell[i].value);
            buy[i].value -= min;
            sell[i].value += min;

            int diff = Math.abs(buy[i].index - sell[i].index);
            steps = diff * min;

            if (buy[i].value == 0) i++;
            if (sell[i].value == 0) j++;
        }


        return steps;
    }


    public static void main(String[] args) {

    }
}
