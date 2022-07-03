import java.util.Arrays;
import java.util.Comparator;

class Stock {
    int price;
    int quantity;

    public Stock(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }
}

class StockComparator implements Comparator<Stock> {
    @Override
    public int compare(Stock o1, Stock o2) {
        return o1.price - o2.price;
    }
}


public class MaximumStockithDay {


    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        int stockCount = 0;
        Stock[] stocks = new Stock[n];
        stocks[0] = new Stock(price[0], 1);
        for (int i = 1; i < n; i++) {
            stocks[i] = new Stock(price[i], i + 1);
        }

        Arrays.sort(stocks, new StockComparator());

        for (int i = 0; i < n; i++) {

            int tPrice = stocks[i].price * stocks[i].quantity;

            if (k >= tPrice) {
                stockCount += stocks[i].quantity;
                k -= tPrice;
            } else {
                stockCount += k / stocks[i].price;
                break;
            }

        }


        return stockCount;
    }

    public static void main(String[] args) {

    }
}
