import java.util.*;

public class FirstNegNumberInWindow {

    public static void firstNegArraySlidingW(int[] arr, int k) {

        int i = 0, j = 0;
        int size = arr.length;

        // List of neg numbers
        List<Integer> list = new ArrayList<Integer>(size);

        while (j < size) {
            if (arr[j] < 0) {
                list.add(arr[j]);
            }

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (list.size() == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print(list.get(0) + " ");
                    // Remove the i elements and move the window
                    if (arr[i] == list.get(0)) {
                        list.remove(0);
                    }
                }
                j++;
                i++;
            }

        }

    }

    public static long[] printFirstNegativeInteger(long arr[], int n, int k) {

        List<Long> result = new ArrayList<Long>(n);
        List<Long> list = new ArrayList<Long>(n);
        int i = 0, j = 0;
        while (j < n) {

            if (arr[j] < 0) {
                list.add(arr[j]);
            }

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (list.size() == 0) {
                    result.add(0L);
                    //System.out.print("0 ");
                } else {
                  //  System.out.print(list.get(0)+" ");
                    result.add(list.get(0));
                    if (arr[i] == list.get(0)) {
                        list.remove(0);
                    }
                }

                i++;
                j++;
            }

        }

        long[] res = new long[result.size()];
        for (i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
             System.out.print(res[i] + " ");

        }

        return res;
    }

    public static void main(String[] args) {

        long[] arr = {-8, 2 ,3 ,-6 ,10 };
     //   firstNegArraySlidingW(arr, 3);
        printFirstNegativeInteger(arr,5,2);
    }

}
