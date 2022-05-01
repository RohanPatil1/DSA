public class MergeSortedArr {

    public static void printArr(int[] arr) {
        
        for(int x:arr){
            System.out.print(x+" ");
        }
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0, k = 0;
        int size = m+n;

        int[] temp = new int[size];
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[k] = nums1[i];
                k++;
                i++;
            } else {
                temp[k] = nums2[j];
                j++;
                k++;
            }
        }

      

        while (i < m) {
            temp[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n) {
            temp[k] = nums2[j];
            j++;
            k++;
        }

        k = 0;
        for (i = 0; i < size; i++) {
            nums1[i] = temp[k];
            k++;
        }
        printArr(temp);
    }

    public static void main(String[] args) {
        merge(new int[]{1,2,3,0,0,0},3,new int[]{2,5,6},3);
    }
}
