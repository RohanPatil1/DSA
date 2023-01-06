public class QuickSort {
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int si, int ei) {

        //Set Pivot
        int pivot = arr[si];

        //Count Numbers which are less than pivot
        int count_numbers_less_than_pivot = 0;
        for (int i = si + 1; i <= ei; i++) {
            if (arr[i] <= pivot) {
                count_numbers_less_than_pivot++;
            }
        }

        //Put Pivot to its correct index by swapping
        int pivotIndex = si + count_numbers_less_than_pivot;
        swap(arr, si, pivotIndex);


        //Arrange & Swap elements which are smaller or greater than pivot
        int i = si;
        int j = ei;

        while (i < pivotIndex && pivotIndex < j) {
            if (arr[i] <= pivot) {
                i++;
            } else if (arr[j] > pivot) {
                j--;
            } else {
                //Both are not in correct order
                swap(arr, i, j);
            }

        }
        return pivotIndex;
    }


    static void quickSort(int[] input, int si, int ei) {
        int c;
        if (si < ei) {
            c = partition(input, si, ei);
            quickSort(input, si, c - 1);
            quickSort(input, c + 1, ei);
        }

    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 3, 2, 1};
        quickSort(a, 0, 5);
        for (int i = 0; i < 6; i++) {
            System.out.print(a[i] + " ");
        }
    }

}
