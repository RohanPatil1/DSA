import java.text.DecimalFormat;
import java.util.*;


class MyPair {
    int a;
    int b;

    MyPair(int a, int b) {
        this.a = a;
        this.b = b;
    }


}


class CPair {
    char c;
    int f;

    CPair(char c, int f) {
        this.c = c;
        this.f = f;
    }

}

class CustomCComparator2 implements Comparator<MyPair> {
    @Override
    public int compare(MyPair p1, MyPair p2) {
        int num1 = p1.a;
        int num2 = p2.a;


        return num1 - num2;
    }


}

class CustomCComparator implements Comparator<MyPair> {
    @Override
    public int compare(MyPair p1, MyPair p2) {
        int num1 = p1.a;
        int num2 = p2.a;

        if (num2 > num1) {
            return 1;
        } else if (num1 > num2) {
            return -1;
        }
        return 0;
    }

//    @Override
//    public int compare(Integer num1, Integer num2) {
//        int value = num1.compareTo(num2);
//        if (value > 0) {
//            return -1;
//        } else if (value < 0) {
//            return 1;
//        }
//        return 0;
//    }
}

public class Practice2 {

    public static void revStr(String s, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(s.charAt(index));
        revStr(s, index - 1);

    }

    static int first = -1;
    static int last = -1;

    public static void getOcc(String s, char element, int index) {
        if (index == s.length()) {
            System.out.println("First :" + first + " Last: " + last);
        }

        char currElement = s.charAt(index);
        if (currElement == element) {
            if (first == -1) {
                first = index;
            } else {
                last = index;
            }
        }
        getOcc(s, element, index + 1);
    }

    public static boolean checkSorted(int[] arr, int index) {
        if (index == arr.length) {
            return true;
        }


        if (arr[index - 1] > arr[index]) {
            return false;
        }
        return checkSorted(arr, index + 1);

    }

    public static ArrayList<Integer> getLarSS(int[] arr, int sum) {

        ArrayList<Integer> result = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        int currSum = 0;
        int start = 0;
        int end = 0;
        int maxL = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];

            if (currSum - sum == 0) {
                start = 0;
                end = i;
            }

            if (map.containsKey(currSum - sum)) {
                int len = i - map.get(currSum - sum) + 1;
                if (len > maxL) {
                    start = map.get(currSum - sum) + 1;
                    end = i;
                    maxL = len;
                }

            } else {
                map.put(currSum, i);
            }

        }

        //Fill the result
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }


        return result;
    }


    public static String getCommPrefix(String[] strs) {
        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];

            //Substract until it becomes equal
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }

        }


        return prefix;
    }


    public static List<Integer> getFN(int[] arr, int k) {
        List<Integer> neg = new ArrayList<>();

        int size = arr.length;
        int i = 0, j = 0;

        while (j < size) {
            if (arr[j] < 0) {
                neg.add(arr[j]);
            }

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {

                if (neg.size() == 0) {
                    System.out.print("0 ");
                } else {
                    System.out.print(neg.get(0) + " ");
                    if (neg.get(0) == arr[i]) {
                        neg.remove(0);
                    }
                }
                j++;
                i++;
            }
        }


        return neg;
    }


    public static int countAnagrams(String s, String ptn) {
        int count = 0;

        //Put the ptn in frequency map
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < ptn.length(); i++) {
            char c = ptn.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //forxxxorf
        int i = 0, j = 0;
        int countX = map.size();
        int k = ptn.length();
        int size = s.length();
        while (j < size) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                //f
                if (map.get(c) == 1) {
                    countX--;
                }
                map.put(c, map.get(c) - 1);

            }

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                if (countX == 0) {
                    count++;
                }

                char ci = s.charAt(i);
                if (map.containsKey(ci)) {
                    map.put(ci, map.get(ci) + 1);
                    if (map.get(ci) == 1) {
                        countX++;
                    }
                }
                i++;
                j++;
            }
        }


        return count;
    }


    public static ArrayList<Integer> getMaxSl(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        Deque<Integer> list = new LinkedList<>();
        int i = 0, j = 0, size = arr.length;

        while (j < size) {
            if (list.size() == 0) {
                list.add(arr[j]);
            } else {
                //List is not empty
                while (list.size() > 0 && list.peekLast() < arr[j]) {
                    list.removeLast();
                }
                list.push(arr[j]);
            }

            if ((j - i + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {
                result.add(list.peek());

                //Remove for i
                if (list.peek() == arr[i]) {
                    list.removeFirst();
                }
                i++;
                j++;


            }


        }


        return result;
    }


    public static int longestUniqueSubStr(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0, size = s.length();
        int result = 0;
        while (j < size) {
            char cj = s.charAt(j);
            map.put(cj, map.getOrDefault(cj, 0) + 1);

            if (map.size() < k) {
                j++;
            } else if (map.size() == k) {
                result = Math.max(result, j - i + 1);
                j++;
            } else {
                while (map.size() > k) {
                    char ci = s.charAt(i);
                    if (map.containsKey(ci)) {
                        map.put(ci, map.get(ci) - 1);
                        if (map.get(ci) == 0) {
                            map.remove(ci);
                        }
                    }
                    i++;
                }
                j++;
            }
        }
        return result;
    }

    public static int minSubStr(String s, String ptn) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();

        //Frequency Map for ptn
        for (int i = 0; i < ptn.length(); i++) {
            char c = ptn.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0, size = s.length();
        int countX = map.size();
        while (j < size) {
            char cj = s.charAt(j);
            if (map.containsKey(cj)) {
                map.put(cj, map.get(cj) - 1);
                if (map.get(cj) == 0) {
                    countX--;
                }
            }

            if (countX > 0) {
                j++;
            } else if (countX == 0) {

                if ((j - i + 1) < result) {
                    result = j - i + 1;
                }

                //Calculation for i
                while (countX == 0 && i <= j) {
                    char ci = s.charAt(i);
                    if (map.containsKey(ci)) {
                        map.put(ci, map.get(ci) + 1);
                        if (map.get(ci) == 1) {
                            countX++;
                        }
                    }
                    i++;

                    //RECHECK THE ANS
                    if (countX == 0 && result < (j - i + 1)) {
                        result = j - i + 1;
                    }
                }
                j++;

            }


        }


        return result;
    }


    public static void kClosest(int[] arr, int x, int k) {


        PriorityQueue<MyPair> pq = new PriorityQueue<>(new CustomCComparator());
        for (int i = 0; i < arr.length; i++) {
            pq.offer(new MyPair(Math.abs(arr[i] - x), arr[i]));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        //Get The K elements
        while (!pq.isEmpty()) {
            System.out.println(pq.poll().b);
        }

    }

    public static void kTopEle(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (int key : map.keySet()) {
            pq.add(key);
        }

        //get k
        for (int i = 0; i < k; i++) {
            System.out.println(pq.poll());
        }
    }


    //Allocate books
    public static boolean isValid(int[] arr, int k, int mid) {
        int sum = 0, student = 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > mid) {
                student++;
                sum = arr[i];
            }
        }

        return (k == student);
    }

    public static int allocate(int[] arr, int k) {
        int result = 0;

        int sum = 0, max = 0;
        for (int x : arr) {
            sum += x;
            max = Math.max(max, x);
        }

        int start = max;
        int end = sum;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(arr, k, mid)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }


        return result;
    }


    public static int validP(String s) {
        int result = 0;
        int n = s.length();
        Stack<Integer> indexS = new Stack<>();
        indexS.push(-1);

        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                indexS.push(i);
            } else {
                indexS.pop();
                if (indexS.isEmpty()) {
                    indexS.push(i);
                } else {
                    result = Math.max(result, i - indexS.peek());
                }

                //                if (!charS.isEmpty() && charS.peek() == '(') {
//
//                } else {
//                    indexS.add(i);
//                }
            }


        }

        return result;
    }

    public static int lvp(String s) {
        int n = s.length();
        int result = 0;

        int left = 0, right = 0;

        //From prefix
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right)
                result = Math.max(result, 2 * right);
            else if (right > left) {
                left = 0;
                right = 0;
            }
        }

        left = 0;
        right = 0;

        //From suffix
        for (int i = n - 1; i > 0; i--) {
            char curr = s.charAt(i);
            if (curr == '(') {
                left++;
            } else {
                right++;
            }

            if (left == right) {
                result = Math.max(result, 2 * right);
            } else if (left > right) {
                left = 0;
                right = 0;
            }
        }


        return result;
    }


    public static void recurSort(List<Integer> arr, int n) {
        if (arr.size() == 1) {
            return;
        }

        int temp = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        recurSort(arr, arr.size());
        insertRec(arr, arr.size(), temp);

    }

    private static void insertRec(List<Integer> arr, int n, int temp) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) <= temp) {
            arr.add(temp);
            return;
        }

        int val = arr.get(arr.size() - 1);
        arr.remove(arr.size() - 1);
        insertRec(arr, arr.size(), temp);
        arr.add(val);

    }

    public static void printAbaB(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        char c = input.charAt(0);
        input = input.substring(1);
        printAbaB(input, output + Character.toLowerCase(c));
        printAbaB(input, output + Character.toUpperCase(c));

    }

    public static void printA_B_C(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        String op1 = output + "_" + input.charAt(0);
        String op2 = output + input.charAt(0);
        input = input.substring(1);
        printA_B_C(input, op1);
        printA_B_C(input, op2);
    }


    public static int knapSack01(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (wt[n - 1] <= w) {
            return Math.max(val[n - 1] + knapSack01(wt, val, w - wt[n - 1], n - 1), knapSack01(wt, val, w, n - 1));
        } else {
            return knapSack01(wt, val, w, n - 1);
        }

    }

    static int[][] t = new int[100][100];


    public static int knapsackDP(int[] wt, int[] val, int w, int n) {

        //Init
        for (int i = 0; i < (n + 1); i++) {
            for (int j = 0; j < (w + 1); j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        //Now fill the rest with ans
        for (int i = 1; i < (n + 1); i++) {
            for (int j = 1; j < (w + 1); j++) {
                if (wt[i - 1] <= j) {
                    t[i][j] = Math.max(val[i - 1] + t[i - 1][j - wt[i - 1]], t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][w];
    }

    public static int countSubset_Sum(int[] arr, int n, int S) {

        //Init
        for (int i = 0; i < (n + 1); i++) {
            for (int j = 0; j < (S + 1); j++) {
                if (j == 0) {
                    t[i][j] = 1;
                } else if (i == 0) {
                    t[i][j] = 0;
                }
            }
        }

        //Fill the rest with ans
        for (int i = 1; i < (n + 1); i++) {
            for (int j = 1; j < (S + 1); j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - arr[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }
        return t[n][S];
    }


    //Max number of ways of coins
    public static int maxWCoins(int[] coins, int s) {
        int n = coins.length;
        int[][] t = new int[n + 1][s + 1];

        //Init
        for (int i = 0; i < (n + 1); i++) {
            for (int j = 0; j < (s + 1); j++) {
                if (i == 0) {
                    t[i][j] = 0;
                } else if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        //Fill the rest with ans
        for (int i = 1; i < (n + 1); i++) {
            for (int j = 1; j < (s + 1); j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }


        return t[n][s];
    }

    //Triplets
    public static void a1Triplets(int[] arr) {
        int n = arr.length;
        int count = 0;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int k = n - 1;
                while (k > j) {
                    if (arr[i] + arr[j] > arr[k]) {
                        count++;
                    }
                    k--;
                }
            }
        }

        System.out.println(count);
    }

    public static void a2Triplets(int[] arr) {
        int n = arr.length;

        int count = 0;
        Arrays.sort(arr);
        for (int i = n - 1; i >= 1; i--) {
            int j = 0, k = i - 1;
            while (j < k) {
                if (arr[j] + arr[k] > arr[i]) {
                    count += k - j;
                    k--;
                } else {
                    j++;
                }
            }
        }

        System.out.println(count);
    }

    public static int lcs(String a, String b) {
        int n = a.length();
        int m = b.length();

        //Init
        for (int i = 0; i < (n + 1); i++) {
            for (int j = 0; j < (m + 1); j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }

        //Fill the rest with ans
        for (int i = 1; i < (n + 1); i++) {
            for (int j = 1; j < (m + 1); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i - 1][j], t[i][j - 1]);
                }
            }
        }

        return t[n][m];
    }

    public static void swapNum(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[si];
        int countSmall = 0;

        for (int i = si + 1; i <= ei; i++) {
            if (arr[i] <= pivot) {
                countSmall++;
            }
        }

        int index_p = si + countSmall;
        int output = index_p;

        swapNum(arr, si, index_p);

        int m = si;
        int n = ei;
        while (m < index_p && n > index_p) {
            if (arr[m] <= pivot) {
                m++;
            } else if (arr[n] > pivot) {
                n--;
            } else {
                swapNum(arr, m, n);
            }
        }
        return output;
    }

    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei) {
            return;
        } else {
            int p = partition(arr, si, ei);
            quickSort(arr, si, p - 1);
            quickSort(arr, p + 1, ei);
        }

    }


    public static void merge(int[] arr, int si, int mid, int ei) {
        int size = ei - si + 1;
        int[] out = new int[size];

        int i = si;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                out[k] = arr[i];
                k++;
                i++;
            } else {
                out[k] = arr[j];
                k++;
                j++;
            }
        }

        while (i <= mid) {
            out[k] = arr[i];
            k++;
            i++;
        }

        while (j <= ei) {
            out[k] = arr[j];
            k++;
            j++;
        }

        int m = 0;
        for (int l = si; l <= ei; l++) {
            arr[l] = out[m];
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
        merge(arr, si, mid, ei);
    }


    public static void sortCVolors(int[] arr) {


        int low = 0;
        int high = arr.length - 1;
        int m = 0;

        while (m <= high) {
            if (arr[m] == 0) {
                swapNum(arr, low, m);
                low++;
                m++;
            } else if (arr[m] == 1) {
                m++;
            } else {
                swapNum(arr, m, high);
                high--;
//                m++;
            }
        }


    }

    //5, 6, 7, 8, 9, 10, 1, 2, 3
    public static int searchInRS(int[] arr, int X) {

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while (low <= high) {

            mid = low + (high - low) / 2;
            if (arr[mid] == X) {
                return mid;
            } else if (arr[mid] >= X) {
                //Left sorted Now check in left
                if (arr[mid] > X && arr[low] <= X) {
                    //In left
                    high = mid - 1;
                } else {
                    //Not in left
                    low = mid + 1;
                }

            } else {
                if (arr[mid] > X && arr[high] >= X) {
                    //In Rigght
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

        }
        return -1;

    }

    public static String addStr(String s1, String s2) {

        int i = s1.length() - 1;
        int j = s2.length() - 1;
        String res = "";
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int iVal = i >= 0 ? s1.charAt(i) - '0' : 0;
            int jVal = j >= 0 ? s2.charAt(j) - '0' : 0;

            i--;
            j--;
            int sum = iVal + jVal + carry;

            res = (sum % 10) + res;
            carry = sum % 10;
        }

        return res;
    }

    public static String rHelper(String input, String output, int index) {

        if (index == -1) {
            return output;
        }


        char curr = input.charAt(index);
        if (index > 0 && curr != input.charAt(index - 1)) {
            output += curr;
        }


//        if (input.charAt(index) != input.charAt(index - 1)) {
//            output += input.charAt(index);
//        }

//        output += input.charAt(index);
//       System.out.println(output);
        index -= 1;
        return rHelper(input, output, index);


    }


    public static String removeAdjRecurHelper(String s) {
        String res = "";
        int n = s.length();
        int i = 0;
        while (i < n) {


            if ((i < (n - 1)) && (s.charAt(i) == s.charAt(i + 1))) {
                while ((i < (n - 1)) && (s.charAt(i) == s.charAt(i + 1))) {
                    i++;
                }
            } else {
                res += s.charAt(i);
            }

            i++;
        }

        return res;
    }


    public static String removeAdjRecur(String s) {
        String res = s;
        String temp = "";

        while (temp.length() != res.length()) {
            //More Duplicates
            temp = res;
            res = removeAdjRecurHelper(res);
        }
        return res;
    }


    static Queue<Integer> pq1 = new LinkedList<>();
//    static Queue<Double> pq2 = new LinkedList<>();
//    static double currM = 0;
//    //Function to insert heap.
//    public static void insertHeap(int x) {
//        // add your code here
//        pq1.add(x);
//    }
//
//    //Function to balance heaps.
//    public static void balanceHeaps() {
//        // add your code here
//        int n = pq1.size();
//        int[] a = new int[n];
//        int i = 0;
//        while (!pq1.isEmpty()) {
//            a[i++] = pq1.poll();
//        }
//
//    }

    //Function to return Median.
//    public static double getMedian() {
//        // add your code here
//
//        double ans = findMedian()
////        if (pq2.isEmpty()) {
////            pq2.add(Double.valueOf(pq1.peek()));
////            return pq1.poll();
////        } else {
////            int prev = pq1.poll();
////            double currM = pq2.poll();
////            double newM = (prev + currM) / 2;
////            pq2.add(newM);
////            return newM;
////        }
//
//    }

    public static void printArr(int[] a) {
        System.out.println("-");
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static double findMedian(int a[], int n) {
        // printArr(a);
        System.out.println("-");
        // First we sort the array
        Arrays.sort(a);

        // check for even case
        if (n % 2 != 0)
            return a[n / 2];

        return (a[(n - 1) / 2] + a[n / 2]) / 2;
    }

    public static void getANS(int A[], int N) {
        double currM = 0;
        int k = 0;
        while (N != 0) {
            int curr = A[k++];

            pq1.add(curr);
            System.out.println(pq1.toString());
            int n = pq1.size();
            int[] a = new int[n];
            int i = 0;
//            while (n!=0) {
//                a[i++] = pq1.peek();
//                n--;
//            }
            for (Integer item : pq1) {
                a[i++] = item;
            }
            double m = findMedian(a, pq1.size());
            DecimalFormat format = new DecimalFormat("0.#");

            currM = m;
            System.out.println((int) Math.floor(currM));
            a = null;
            N--;
        }
    }

    public static int minPlatform(int[] arr, int[] dept, int n) {
        PriorityQueue<MyPair> pq = new PriorityQueue<>(new CustomCComparator2());
        ArrayList<MyPair> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new MyPair(arr[i], dept[i]));
        }

        Collections.sort(list, new CustomCComparator2());
        for (MyPair p : list) {
            System.out.println(p.a);
        }

        int platform = 1;
        //PQ - (Dept-Platform)
        //List- (Arr-Dept)
        pq.offer(new MyPair(list.get(0).b, platform));

        for (int i = 1; i < n; i++) {
            MyPair currT = list.get(i);

            if (currT.a >= pq.peek().a) {
                int samePlatform = pq.peek().b;
                pq.poll();
                pq.offer(new MyPair(currT.b, samePlatform));
            } else {
                //Need new platform - Prev dept is greater than next arrival
                platform++;
                pq.offer(new MyPair(currT.b, platform));
            }

        }


        return platform;
    }


    public static void main(String[] args) {

        System.out.println(minPlatform(new int[]{1, 2, 6, 8}, new int[]{5, 9, 7, 10}, 4));

//        getANS(new int[]{5, 15, 1, 3}, 4);

//        String s = "geeksforgeek";
//        Queue<Integer> q = new LinkedList<>();
//        q.add(1);
//        q.add(2);
//        q.add(3);
//        q.add(4);
////        System.out.println(modifyQueue(q,2).toString());
//        System.out.println(removeFirst("aabc"));

//        System.out.println(removeAdjRecur(s));

//        System.out.println(29 % 10);
//        System.out.println(addStr("123", "5"));
        //int[] arr = new int[]{5, 9, 8, 3, 2, 7, 1};
        // mergeSort(arr, 0, arr.length - 1);
        //    quickSort(arr, 0, arr.length - 1);
//        int[] arr = new int[]{1, 1, 2, 2, 0, 1, 0};
//        sortCVolors(arr);
//        for (int x : arr)
//            System.out.print(x + " ");

        //printA_B_C("BC", "A");
        //  System.out.println(knapsackDP(new int[]{1, 3, 4, 5}, new int[]{1, 4, 5, 7}, 7, 4));
        //        int[][] dp = new int[100][100];
        //        for (int[] a : dp) {
        //            Arrays.fill(a, -1);
        //        }
//        System.out.println(countSubset_Sum(arr, arr.length, 10));
//        System.out.println(maxWCoins(new int[]{1, 2, 3}, 5));
//        System.out.println(lcs("abcdgh", "abedhr"));
    }

}
