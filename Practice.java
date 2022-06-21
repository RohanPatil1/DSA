import java.util.*;

public class Practice {

    public static void insertionSort(int[] arr) {

        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = temp;

        }

    }

    public static void selectionSort(int[] arr) {

        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            // Get min
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }

            if (min != i) {
                // swap(arr,min,i);
            }

        }

    }

    // QUICK SORT

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        System.out.println("Value of i: " + i);

        for (int j = low; j <= high - 1; j++) {
            // System.out.println(j);
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // Pivot to its right spot
        swap(arr, i + 1, high);
        return i + 1;

    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pivot = partition(arr, low, high);

            quickSort(arr, low, pivot - 1);
            quickSort(arr, pivot + 1, high);

        }

    }

    // QUICK SORT END

    // MERGE SORT

    public static void merge(int[] arr, int si, int ei) {
        int size = ei - si + 1;
        int mid = (si + ei) / 2;
        int[] tempArr = new int[size];

        int i = si;
        int j = mid + 1;
        int k = 0;

        if (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                tempArr[k] = arr[i];
                i++;
                k++;
            } else {
                tempArr[k] = arr[j];
                j++;
                k++;
            }
        }

        /// Remaining Element
        while (i <= mid) {
            tempArr[k] = arr[i];
            i++;
            k++;
        }

        while (j <= ei) {
            tempArr[k] = arr[j];
            j++;
            k++;
        }

        int m = 0;
        // Copy the sorted elements from tempArr to arr
        for (i = si; i <= ei; i++) {
            arr[i] = tempArr[m];
            m++;
        }

    }

    public static void mergeSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        }

        int mid = (si + ei) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);

        merge(arr, si, ei);

    }

    // MERGE SORT END

    static void printArray(int[] arr, int size) {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    // ThreeSum a+b+c=0
    public static List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> resultSet = new HashSet();
        Arrays.sort(arr);

        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            int curr = arr[i];
            int start = i + 1;
            int end = n - 1;
            while (start < end) {
                int currSum = curr + arr[start] + arr[end];
                if (currSum == 0) {
                    List<Integer> tempL = new ArrayList<>();
                    tempL.add(i);
                    tempL.add(start);
                    tempL.add(end);
                    start++;
                    end--;
                } else if (currSum > 0) {
                    end--;
                } else {
                    start++;
                }

            }
        }

        return new ArrayList(resultSet);

    }

    // ThreeSum a+b+c=k
    public static List<List<Integer>> threeSumOfk(int[] nums, int k) {
        Set<List<Integer>> resultSet = new HashSet();
        Arrays.sort(nums);

        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int low = i + 1;
            int high = n - 1;

            // Find the remaining two pairs
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                int target = k;
                if (sum == target) {
                    resultSet.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (sum > target) {
                    high--;
                } else {
                    low++;
                }

            }

        }

        return new ArrayList(resultSet);

    }

    public static void revStr(String s, int index) {
        if (index < 0) {
            return;
        }

        System.out.print(s.charAt(index));
        revStr(s, index - 1);

    }

    public static void getSubArrayWithSumK(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int currSum = 0;
        int n = arr.length;

        // Add sum with the index
        for (int i = 0; i < n; i++) {
            currSum += arr[i];

            if (currSum - k == 0) {
                System.out.print("Index : 0-" + i);
            }

            if (map.containsKey(currSum - k)) {
                int start = map.get(currSum - k) + 1;
                int end = i;
                System.out.print("Index :" + start + "-" + i);

            } else {
                map.put(currSum, i);
            }

        }

    }

    public static void getSubArrayWithEqual(int[] arr) {

        int n = arr.length;

        // Convert all 0 to -1
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                arr[i] = -1;
            } else {
                arr[i] = 1;
            }
        }

        int max = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Find the range with sum 0
        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0) {
                System.out.println("Start 0 End " + i);
            }

            if (map.containsKey(sum)) {
                // Len = end - start
                int len = i - map.get(sum);
                max = Math.max(max, len);
            } else {
                map.put(sum, i);
            }
        }
        System.out.println("Max Len : " + max);
    }

    // Longest Common Prefix
    public static void longestCommonPrefix(ArrayList<String> strs) {
        String prefix = strs.get(0);

        for (int i = 1; i < strs.size(); i++) {
            String currStr = strs.get(i);
            while (currStr.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        System.out.println("Common Substring : " + prefix);
    }

    // Longest common prefix GOG
    public static void longestCommonPrefix2(String s1, String s2) {

        int prefix = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            int str1Ptr = 0;
            int str2Ptr = i;

            while (str1Ptr < n && str2Ptr < n && s1.charAt(str1Ptr) == s2.charAt(str2Ptr)) {
                str1Ptr++;
                str2Ptr++;
            }
            prefix = Math.max(prefix, str1Ptr);
        }

        System.out.println(s1.substring(0, prefix));

    }

    // Count Distinct Element in Window
    public static void distinctInWindow(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        // Put First k elemenets in map
        for (int i = 0; i < k; i++) {
            Integer j = map.get(arr[i]);
            map.put(arr[i], (j == null) ? 1 : j + 1);
        }
        // First windows output
        System.out.println("Distinct Count for Windwos: ");
        System.out.println(map.size());

        for (int j = k; j < arr.length; j++) {

            // Calc for j
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);

            // Remove i
            if (map.get(arr[j - k]) == 1) {
                map.remove(arr[j - k]);
            } else {
                map.put(arr[j - k], map.get(arr[j - k]) - 1);
            }

            System.out.println(map.size());
        }

    }

    // Count Anagram
    public static void countAnagram(String s, String ptn) {

        int result = 0;// Count of anagrams
        int k = ptn.length();
        Map<Character, Integer> map = new HashMap<>(k);
        for (int m = 0; m < k; m++) {
            map.put(ptn.charAt(m), map.getOrDefault(ptn.charAt(m), 0) + 1);
        }

        int i = 0;
        int j = 0;

        int countX = map.size();

        while (j < s.length()) {
            // If its in the map decrease the count
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if (map.get(s.charAt(j)) == 0) {
                    countX--;
                }
            }

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (countX == 0) {
                    // GOT ANS
                    result++;
                }
                char si = s.charAt(i);
                if (map.containsKey(si)) {
                    map.put(si, map.get(si) + 1);
                    if (map.get(si) == 1) {
                        countX += 1;
                    }
                }
                i++;
                j++;
            }

        }

        System.out.println("Count Of Anagrams : " + result);
    }

    public static void countAnaagram(String s, String ptn) {

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < ptn.length(); i++) {
            map.put(ptn.charAt(i), map.getOrDefault(ptn.charAt(i), 0) + 1);
        }

        int i = 0;
        int j = 0;
        int k = ptn.length();
        int countX = map.size();

        while (j < s.length()) {
            char jChar = s.charAt(j);
            if (map.containsKey(jChar)) {
                map.put(jChar, map.get(jChar) - 1);
                if (map.get(jChar) == 0) {
                    countX--;
                }
            }

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (countX == 0) {
                    result += 1;
                }
                // Remove Calculation for i
                char iChar = s.charAt(i);
                if (map.containsKey(iChar)) {
                    map.put(iChar, map.get(iChar) + 1);
                    if (map.get(iChar) == 1) {
                        countX++;
                    }
                }
                i++;
                j++;

            }

        }

        System.out.println("Count Of Anagrams : " + result);
    }

    public static ArrayList<Integer> twoSum(int[] arr, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        for (int x : arr) {
            map.put(x, i++);
        }

        //get sum
        for (i = 0; i < arr.length; i++) {
            int curr = arr[i];
            int compl = sum - curr;
            if (map.containsKey(compl)) {
                result.add(i);
                result.add(map.get(compl));
            }
        }

        return result;
    }

    public static ArrayList<Integer> twoSum2(int[] arr, int sum) {
        ArrayList<Integer> result = new ArrayList<>();

        int n = arr.length;
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;
        while (start < end) {
            int currSum = arr[start] + arr[end];
            if (currSum == sum) {
                result.add(start);
                result.add(end);
                start++;
                end--;
            } else if (currSum > sum) {
                end--;
            } else {
                start++;
            }
        }


        return result;
    }

    public static void main(String[] args) {


        int[] myA = new int[]{2, 7, 11, 15};
        System.out.println(twoSum2(myA, 9).toString());

        // ThreeSUM a+b+c=0
        int[] arr = new int[]{60, -65, 5, -21, 8, 93};
        List<List<Integer>> result = threeSum(arr);
        System.out.println(result.toString());

        // ThreeSUM a+b+c=k
        int[] arr2 = new int[]{1, 4, 1, 5};
        List<List<Integer>> result2 = threeSumOfk(arr2, 6);
        System.out.println(result2.toString());

        // QUICK SORT
        int[] arr3 = {10, 7, 8, 9, 1, 5};
        int n = arr3.length;

        quickSort(arr3, 0, n - 1);
        System.out.println("Sorted array: ");
        printArray(arr3, n);

        // QUICK SORT

        mergeSort(arr3, 0, n - 1);
        System.out.println("Merge Sorted array: ");
        printArray(arr3, n);

        // REV Str
        revStr("jio", 2);

        // Get Subarry
        getSubArrayWithSumK(new int[]{1, 2, 3, 7, 5}, 12);

        System.out.println();
        // Largest Subarray with equal nos of 1 0
        getSubArrayWithEqual(new int[]{0, 0, 1, 0, 1, 0});

        // Commom Substring
        ArrayList<String> strs = new ArrayList<String>();
        strs.add("flower");
        strs.add("flow");
        strs.add("float");
        longestCommonPrefix(strs);

        // longestCommonPrefix2
        longestCommonPrefix2("geeks", "dgeek");

        // Distinct in Window k
        // distinctInWindow(new int[] { 1, 2, 2, 1, 3, 1, 1, 3 }, 4);

        // Count of anagrams
        countAnaagram("forxsdfadorf", "for");
    }

}
