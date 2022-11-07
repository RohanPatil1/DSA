public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int n = letters.length;
        int right = letters.length ;


        while (left < right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }

        }

        return letters[left%n];
    }
}
