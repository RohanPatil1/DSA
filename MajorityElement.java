public class MajorityElement {

    static int majorityElement(int arr[], int size) {
        int element = -1;


        int count = 0;
        for (int x : arr) {
            if (element == x) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                element = x;
                count = 1;
            }
        }
        //element is a potential ans

        int freq = 0;
        for (int x : arr) {
            if (x == element) {
                freq++;
            }
            if (freq > (size) / 2) {
                return element;
            }
        }

        return -1;
    }

}
