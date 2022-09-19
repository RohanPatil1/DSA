import java.util.*;

public class ChooseAndSwap {

    static String replace(String str, char a, char b) {

        String ans = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a)
                ans += b + "";
            else if (str.charAt(i) == b)
                ans += a + "";
            else
                ans += str.charAt(i);
        }
        return ans;
    }

    public static String chooseSwap(String str) {

        TreeSet<Character> set = new TreeSet<>();
        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            set.add(c);
        }
        System.out.println(set);
        for (int i = 0; i < n; i++) {
            set.remove(str.charAt(i));
            System.out.println("After Removal: " + set);

            if (set.isEmpty()) break;
            char currSmallestInSet = set.first(); //smallest char
            if (currSmallestInSet < str.charAt(i)) {
                //Replace
                System.out.println("Before replace :" + currSmallestInSet + " & " + str.charAt(i) + "  STR: " + str);

                str = replace(str, str.charAt(i), currSmallestInSet);
                System.out.println("After replace : STR: " + str);

                break;
            }
        }
        return str;
    }


    public static void asd(List<Integer> arrList) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Collections.sort(arrList);
        int n = arrList.size();
        int minDifference = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            int diff = arrList.get(i + 1) - arrList.get(i);
            if (diff < minDifference) {
                minDifference = diff;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int difference = arrList.get(i + 1) - arrList.get(i);
            if (difference == minDifference) {
                System.out.print(arrList.get(i) + " " + arrList.get(i + 1) + " ");
            }
        }

    }


    public static int findLargestSquareSize(List<List<Integer>> samples) {
        // Write your code here
        int i, j;
        int row = samples.size();
        int column = samples.get(0).size();
        int N[][] = new int[row][column];
        int M[][] = new int[row][column];
        for (int d = 0; d < row; d++) {
            for (int b = 0; b < column; b++) {
                M[d][b] = samples.get(d).get(b);
            }
        }
        int maxOfS, maxI, max_j;
        for (i = 0; i < row; i++)
            N[i][0] = M[i][0];
        for (j = 0; j < column; j++)
            N[0][j] = M[0][j];
        for (i = 1; i < row; i++) {
            for (j = 1; j < column; j++) {
                if (M[i][j] == 1) {
                    N[i][j] = Math.min(N[i][j - 1],
                            Math.min(N[i - 1][j], N[i - 1][j - 1])) + 1;
                } else
                    N[i][j] = 0;
            }

        }
        maxOfS = N[0][0];
        maxI = 0;
        for (i = 0; i < row; i++) {
            for (j = 0; j < column; j++) {
                if (maxOfS < N[i][j]) {
                    maxOfS = N[i][j];
                    maxI = i;
                }
            }
        }
        //Abs difference
        return Math.abs((maxI - maxOfS) - maxI);
    }

    public static int extStr(String s) {
        Map<Character, Integer> map = new HashMap<>();
        List<String> ans = new ArrayList<>();

        int n = s.length();

        for (int i = 0; i < s.length(); i++) {


            ans.add(Character.toString(s.charAt(i)));

//                ans.put(c,i);
        }

        for (int i = 0; i < 26; ++i) {
            char c = (char) ('a' + i);

            if (i <= 1) {
                map.put(c, 1);

            } else if (i <= 4) {
                map.put(c, 2);


            } else if (i <= 7) {
                map.put(c, 3);


            } else if (i <= 9) {
                map.put(c, 9);


            } else if (i <= 12) {
                map.put(c, 12);


            } else if (i <= 15) {
                map.put(c, 15);


            } else if (i <= 18) {
                map.put(c, 7);


            } else if (i <= 21) {
                map.put(c, 8);


            } else if (i <= 24) {
                map.put(c, 9);

            }

        }

        int sum;
        String temp;

        for (int i = 0; i < n - 1; ++i) {

            // char to string
//                string a(1, s[i]);

            temp = "" + s.charAt(i);
            sum = 0 + map.get(s.charAt(i));
            for (int j = i + 1; j < n; ++j) {
                // char to string
//                    string b(1, s[j]);


                temp += s.charAt(j);
                sum += map.get(s.charAt(j));
                int y = temp.length();

                if (sum % y == 0) {
                    ans.add(temp);
                }
            }
        }

        return ans.size();
    }

        /*

          // List<Integer> sorted = arr.stream().sorted().collect(Collectors.toList());
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            if (Math.abs(arr.get(i - 1) -  arr.get(i)) < min) {
                min = Math.abs(arr.get(i - 1) -  arr.get(i));
            }
        }
        List<Integer> answer = new LinkedList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (Math.abs(arr.get(i - 1) -  arr.get(i)) == min) {
                answer.add(arr.get(i - 1));
                answer.add(arr.get(i));
            }
        }

        //Print output
        for(int i=0;i<answer.size()-1;i +=2){

            System.out.println(answer.get(i)+" "+answer.get(i+1));

        }
         */

    public static void main(String[] args) {
        System.out.println(chooseSwap("ccad"));

//        System.out.println(replace("rohan",'o','n'));
    }
}
