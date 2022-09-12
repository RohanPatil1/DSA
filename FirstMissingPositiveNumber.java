public class FirstMissingPositiveNumber {

    public int firstMissingPositive1(int[] nums) {

        int n = nums.length;

        int min = 0, max = 0;

        //Put all negatives to 0
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                nums[i] = 0;
            }
        }

        //Get min max
        for (int x : nums) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }


        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (nums[i] > n) continue;
            freq[nums[i]]++;
        }

        //Get the first element with 0 frequency
        for (int i = 1; i < n + 1; i++) {
            if (freq[i] == 0) {
                return i;
            }
        }


        return max + 1;
    }

    //-----------M2
//    public int firstMissingPositive(int[] arr) {
//        cycleSort(arr);
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != i + 1) {
//                return i + 1;
//            }
//
//        }
//        return arr.length + 1;
//    }
//
//    void cycleSort(int[] arr) {
//        int index, i = 0;
//        while (i < arr.length) {
//            index = arr[i] - 1;
//            if (arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[index]) {
//                swap(arr, i, index);
//            } else i++;
//        }
//    }
//
//    void swap(int[] arr, int s, int e) {
//        int temp = arr[s];
//        arr[s] = arr[e];
//        arr[e] = temp;
//    }
}
