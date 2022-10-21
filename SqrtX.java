public class SqrtX {

    public static int sqrt(int x) {

        if (x <= 1) return x;

        int left = 1;
        int right = x / 2;

        int mid = 0;
        int ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;

            if (mid == x / mid) return mid;
            else if (mid > x / mid) right = mid - 1;
            else {
                ans = mid;
                left = mid + 1;
            }

        }
        return ans;
    }

    //maximal(k) for condition(k)=false is same as minimal(k) for condition(k) = true - 1
    public static int sqrt2(int x) {

        if (x <= 1) return x;

        int left = 0, right = x;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (mid * mid > x) right = mid;
            else left = mid + 1;

        }

        return left - 1;
    }

}
