import java.util.Arrays;
import java.util.Comparator;

class MyItem {
    int value;
    int weight;

    public MyItem(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }


}

class ItemComparator implements Comparator<MyItem> {

    @Override
    public int compare(MyItem o1, MyItem o2) {
        return (o2.value / o2.weight) - (o1.value / o1.weight);
    }
}
public class FractionalKnapsack {

    public static double fractionalKnapsack(int W, MyItem arr[], int n) {
        // Your code here
        double result = 0;

        Arrays.sort(arr, new ItemComparator());


        for (int i = 0; i < n; i++) {
            MyItem curr = arr[i];
//            System.out.println(curr.value);
            double ratio = (curr.value * 1.0) / (curr.weight * 1.0);
            int currItemCap = curr.weight;
            //6  //50  //10
            while (currItemCap != 0 && W != 0) {
                if (W > 0) {
                    result += ratio;
                    currItemCap--;
                    W--;
                    System.out.println(result + " " + currItemCap + " " + W);
                } else if (W == 0) {
                    return result;
                } else {
                    System.out.println("BREAK : currItemCap" + currItemCap + " W: " + W + " RESULT:" + result);
                    break;
                }

            }


        }


        return result;
    }

    public static double fractionalKnapsack2(int W, MyItem arr[], int n) {
        // Your code here
        double result = 0;

        Arrays.sort(arr, new ItemComparator());


        double valueInBag = 0;
        int remainingCap = W;
        for (int i = 0; i < n; i++) {
            MyItem curr = arr[i];
            if(remainingCap==0){
                break;
            }

            if (remainingCap >= curr.weight) {
                valueInBag += curr.value;
                remainingCap -= curr.weight;
            } else {
                valueInBag += curr.value * ((double) remainingCap / curr.weight);
                remainingCap = 0;
                break;
            }


        }

        result=valueInBag;
        return result;
    }

    public static void main(String[] args) {

        MyItem[] arr = new MyItem[]{new MyItem(100, 20), new MyItem(60, 10), new MyItem(120, 30)};

        System.out.println(fractionalKnapsack2(50, arr, arr.length));
    }

}
