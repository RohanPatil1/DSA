
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class TheHumanoid {

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
            int[] arr = reader.readIntArray(2);
            int n = arr[0], H = arr[1];
            int[] powers = reader.readIntArray(n);

            sort(powers);

            //Pass 1
            int maxCount1 = getMaxCount(powers, new int[]{2, 2, 3}, H);

            //Pass2
            int maxCount2 = getMaxCount(powers, new int[]{2, 3, 2}, H);

            //Pass3
            int maxCount3 = getMaxCount(powers, new int[]{3, 2, 2}, H);

            //Final Ans
            int ans = Math.max(maxCount1, Math.max(maxCount2, maxCount3));
            writer.writeSingleInteger(ans);
        }
    }

    public static int getMaxCount(int[] powers, int[] gbPowers, int h) {
        int j = 0, count = 0;
        for (int power : powers) {
            if (power < h) {
                h += (power / 2);
                count++;
            } else {
                if (j == 3) break;
                while (j < 3 && h <= power) {
                    h *= gbPowers[j];
                    j++;
                }
                if (h <= power) {
                    break;
                } else {
                    h += (power / 2);
                    count++;
                }
            }
        }
        return count;
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
