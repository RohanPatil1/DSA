import java.util.*;

public class PrintAllStrSubsets {

    public static void printAll(String ip, String op) {
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }
        String op1 = op;
        String op2 = op;
        op2 += ip.charAt(0);
        ip = ip.substring(1);
        printAll(ip, op1);
        printAll(ip, op2);

    }

    public static void printAllUniq(String ip, String op, HashSet<String> set) {
        if (ip.length() == 0) {
            set.add(op);
            return;
        }
        String op1 = op;
        String op2 = op;
        op2 += ip.charAt(0);
        ip = ip.substring(1);
        printAllUniq(ip, op1, set);
        printAllUniq(ip, op2, set);

    }

    public static void permutationWithSpaces(String ip, String op) {
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }
        String op1 = op + "_" + ip.charAt(0);
        String op2 = op + ip.charAt(0);
        ip = ip.substring(1);
        permutationWithSpaces(ip, op1);
        permutationWithSpaces(ip, op2);
    }

    public static void permutWithCase(String ip, String op) {
        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }

        String op1 = op + Character.toLowerCase(ip.charAt(0));
        String op2 = op + Character.toUpperCase(ip.charAt(0));
        ip = ip.substring(1);
        permutWithCase(ip, op1);
        permutWithCase(ip, op2);

    }

    public static void letterPermu(String ip, String op) {

        if (ip.length() == 0) {
            System.out.println(op);
            return;
        }

        char currChar = ip.charAt(0);
        if (Character.isDigit(currChar)) {
            String op1 = op + currChar;
            letterPermu(ip.substring(1), op1);
        } else {
            String op1 = op + Character.toLowerCase(currChar);
            String op2 = op + Character.toUpperCase(currChar);
            ip = ip.substring(1);
            letterPermu(ip, op1);
            letterPermu(ip, op2);
        }

    }

    public static void main(String[] args) {
        printAll("aab", "");

        System.out.println("=================");
        HashSet<String> set = new HashSet<>();
        printAllUniq("aab", "", set);
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println("=================");
        String input = "ABC";
        String op = "";
        op += input.charAt(0);
        input = input.substring(1);
        permutationWithSpaces(input, op);

        System.out.println("=================");

        permutWithCase("ab", "");
        System.out.println("=================");

        letterPermu("a1b2", "");
    }

}
