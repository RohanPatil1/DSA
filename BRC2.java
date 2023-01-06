import java.io.*;
import java.util.*;

public class BRC2 {
    public static void main(String[] args)
            throws IOException {

        // Initialize the reader
        FastReader reader = new FastReader();

        // Initialize the writer
        FastWriter writer = new FastWriter();


        // Reads a single integer
        int T = reader.readSingleInt();
        Scanner in = new Scanner(System.in);
        while (T-- > 0) {
            int[] mnArr = reader.readIntArray(2);
            int n = mnArr[0];
            int keysCount = mnArr[1];


            String keysStr = reader.readString();
            String keysPresent = reader.readString();

            Set<Character> keysNotPresentSet = new HashSet<>();
            for (int i = 0; i < keysStr.length(); i++) {
                keysNotPresentSet.add(keysStr.charAt(i));
            }

            for (int i = 0; i < keysPresent.length(); i++) {
                char curr = keysPresent.charAt(i);
                keysNotPresentSet.remove(curr);
            }


            Set<String> allSubstring = new HashSet<String>();

            for (int i = 0; i <= keysStr.length(); i++) {
                for (int j = i + 1; j <= keysStr.length(); j++) {

                    String sub = keysStr.substring(i, j);

                }
            }

//
//            Set<Character> keysPresent = new HashSet<>();
//            for (int i = 0; i < keysCount; i++) {
//                keysPresent.add(keysStr.charAt(i));
//            }


            int total = (n * (n + 1)) / 2;
            int made = n * keysCount;

//            int ans = total - made - keyStrSet.size();

//            writer.writeSingleInteger(ans);

            //---------------------

            //60->70->75->80->90   delete 80

            //GOAL 75->90
                    /*
                        75.next = 90

                        temp.next = 80.next;
                     */



            /*

                //0 1 2 3 4 5 6 8 10
                //0 + 2 + 4 + 6 + 8 + 10 = ans

                int n = 98


                 i=0  n=98


                0, 1, 2 , 3 ,4, 5

                i=1  n = 3  sum = 0
                i=2  n = 2 sum = 0 + 2
                i=3  n = 2  sum = 2
                i=4  n = 1  sum = 2 + 4 = 6
                i=5  n = 1  sum = 6
                i=6  n = 0  sum = 6 + 6 = 12
                i=7

                public int sumOfEven(int i, int n){


                    //Base
                    if(n==0){
                        return 0;
                    }

                    if(i%2 == 0){ //even
                        return  i + sumOfEven(i+1, n-1);
                    }else{
                        return sumOfEvent(i+1, n);
                    }

                }

                //i=0 n=3
                int sum = 0;

                while(n != 0){
                    if(i%2 == 0){
                        sum = sum + i;
                        i++;
                        n = n - 1;
                    }else{
                        i++;
                    }
                }



                int sum = 0, i = 0, n = 3;
                sumOfEven(i, n, sum);
                print(sum);

        //1+2 = 3
    ///induction



                static long recursion(long n) {
                    if (n == 0) return n;
                    if (n == 1) return n;

                    return recursion(n-1) + recursion(n-2);
                }

        //[0,1,0,0,1,0,1]  Ans = [0,0,0,0,1,1,1]


             */
            Node head = null;


            Node temp = head;
            Node newNode = new Node(80);

            //90 > 80
            while (temp.next != null && temp.next.data < newNode.data) {
                temp = temp.next;
            }
            //temp = 75
            newNode.next = temp.next;
            temp.next = newNode;



        }

        // Prints a single number
//        writer.writeSingleInteger(sum);
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
