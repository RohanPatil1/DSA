import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MinimizeTheThickness {
    //https://codeforces.com/problemset/problem/1741/C?f0a28=1
    private static final Scanner sc = new Scanner(System.in);

    // Driver Code
    public static void main(String[] args)
            throws IOException {

        // Initialize the reader
        FastReader reader = new FastReader();

        // Initialize the writer
        FastWriter writer = new FastWriter();

        // Reads a single integer
        int T = reader.readSingleInt();

        while (T-- > 0) {

            // Reads
            int n = reader.readSingleInt();
            int[] arr = new int[n];
            int[] prefix = new int[n];
            int sum = 0;
            // Input Numbers
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];

                if (i == 0) {
                    prefix[0] = sum;
                    continue;
                }
                prefix[i] = prefix[i - 1] + arr[i];
            }


            int end = 0;
            int ans = 0, maxSegment = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int target = prefix[i];
                int currTargetSum = prefix[i] + prefix[i];

                int tempIndex = binarySearch(prefix, currTargetSum);
                while (tempIndex > 0 && tempIndex < n && arr[tempIndex] == currTargetSum) {
                    end = tempIndex;

                    currTargetSum += target; //4+4 now +4
                    maxSegment = Math.max(maxSegment, (end - i));

                }

                if (end == (n - 1)) {
                    ans = Math.min(ans, maxSegment);
                }

            }

            writer.writeSingleInteger(ans);
        }

    }

    static int binarySearch(int[] arr, int target) {

        int left = 0, right = arr.length;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void sort(int[] arr) {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int x : arr)
            ls.add(x);
        Collections.sort(ls);
        for (int i = 0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }

    public static long power(long x, long y, long p) {
        //0^0 = 1
        long res = 1L;
        x = x % p;
        while (y > 0) {
            if ((y & 1) == 1)
                res = (res * x) % p;
            y >>= 1;
            x = (x * x) % p;
        }
        return res;
    }

    // Fast Reader Class
    public static class FastReader {

        // Reader object
        BufferedReader reader;

        // Constructor
        public FastReader() {
            // Initialize the reader
            reader = new BufferedReader(
                    new InputStreamReader(
                            System.in));
        }

        // String tokenizer
        StringTokenizer tokenizer;

        // Function to read integer
        public int readSingleInt()
                throws IOException {
            return Integer.parseInt(
                    reader.readLine());
        }

        // Function to read a single long
        public long readSingleLong()
                throws IOException {
            return Long.parseLong(
                    reader.readLine());
        }

        // Function to read a array of
        // numsInts integers in 1 line
        public int[] readIntArray(int numInts)
                throws IOException {
            int[] nums = new int[numInts];
            tokenizer
                    = new StringTokenizer(
                    reader.readLine());

            // Input Numbers
            for (int i = 0; i < numInts; i++) {
                nums[i] = Integer.parseInt(
                        tokenizer.nextToken());
            }
            return nums;
        }

        public long[] readLongArray(int numInts)
                throws IOException {
            long[] nums = new long[numInts];
            tokenizer
                    = new StringTokenizer(
                    reader.readLine());

            // Input Numbers
            for (int i = 0; i < numInts; i++) {
                nums[i] = Long.parseLong(
                        tokenizer.nextToken());
            }
            return nums;
        }

        // Function to read string
        public String readString()
                throws IOException {
            return reader.readLine();
        }
    }

    // Fast Writer Class
    public static class FastWriter {

        // Writer object
        BufferedWriter writer;

        // Constructor
        public FastWriter() {

            // Initialize the writer
            writer = new BufferedWriter(
                    new OutputStreamWriter(
                            System.out));
        }

        // Function to write single integer
        public void writeSingleInteger(int i)
                throws IOException {
            writer.write(Integer.toString(i));
            writer.newLine();
            writer.flush();
        }


        // Function to write a single long
        public void writeSingleLong(long i)
                throws IOException {
            writer.write(Long.toString(i));
            writer.newLine();
            writer.flush();
        }

        // Function to write a Integer
        // of array with spaces in 1 line
        public void writeIntArrayWithSpaces(
                int[] nums)
                throws IOException {
            for (int i = 0; i < nums.length; i++) {
                writer.write(nums[i] + " ");
            }
            writer.newLine();
            writer.flush();
        }

        // Function to write a Integer
        // of array without spaces
        // in 1 line
        public void writeIntArrayWithoutSpaces(int[] nums)
                throws IOException {
            for (int i = 0;
                 i < nums.length; i++) {
                writer.write(
                        Integer.toString(
                                nums[i]));
            }
            writer.newLine();
            writer.flush();
        }

        // Function to write a String
        public void writeString(String s)
                throws IOException {
            writer.write(s);
            writer.newLine();
            writer.flush();
        }
    }
}
