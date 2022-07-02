class Range {
    int start;
    int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

}


public class WaterThePlants {


    public static void waterThePlants(int[] arr) {

        int n = arr.length;
        Range[] ranges = new Range[n];
        for (int i = 0; i < n; i++) {

            int start = i - arr[i];
            if (start < 0) {
                start = 0;
            }
            int end = i + arr[i];
            if (end > n) {
                end = n - 1;
            }
            ranges[i] = new Range(start, end);


        }


    }


    public static void main(String[] args) {

    }
}
