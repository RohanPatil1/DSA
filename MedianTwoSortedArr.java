public class MedianTwoSortedArr {

    public static double medianOf2SortedArr(int[] arr1, int[] arr2) {
        //We want to do bs on smaller length arr
        if (arr2.length < arr1.length) medianOf2SortedArr(arr2, arr1);

        int size1 = arr1.length;
        int size2 = arr2.length;

        int low = 0, high = size1;

        while (low <= high) {
            int partition1 = low + (high - low) / 2;
            int partition2 = (size1 + size2 + 1) / 2 - partition1;

            int left1 = partition1 == 0 ? Integer.MIN_VALUE : arr1[partition1 - 1];
            int left2 = partition2 == 0 ? Integer.MAX_VALUE : arr2[partition2 - 1];

            int right1 = partition1 == 0 ? Integer.MAX_VALUE : arr1[partition1];
            int right2 = partition2 == 0 ? Integer.MIN_VALUE : arr2[partition2];

            //[1,2,3]  [4,5,6]

            if (left1 <= right2 && left2 <= right1) {
                if ((size1 + size2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }

        return 0.0;
    }


}
