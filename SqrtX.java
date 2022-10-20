public class SqrtX {

    public static int sqrt(int x) {

        if (x <= 1) return x;

        int left = 1;
        int right = x / 2;

        int mid = 0;
        int ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if(mid == x/mid) return mid;
            else if (mid > x / mid) right = mid - 1;
            else {
                ans = mid;
                left = mid + 1;
            }

        }
        return ans;
    }
}
