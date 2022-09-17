import java.util.TreeSet;

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
            System.out.println("After Removal: "+set);

            if (set.isEmpty()) break;
            char currSmallestInSet = set.first(); //smallest char
            if (currSmallestInSet < str.charAt(i)) {
                //Replace
                System.out.println("Before replace :" + currSmallestInSet +" & "+str.charAt(i)+ "  STR: "+str);

               str =  replace(str, str.charAt(i), currSmallestInSet);
                System.out.println("After replace : STR: "+str);

                break;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(chooseSwap("ccad"));

//        System.out.println(replace("rohan",'o','n'));
    }
}
