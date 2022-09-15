public class AddString {


    public static String stringAddition(String s1, String s2) {
        String resStr = "";
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        int resSum = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int iValue = i >= 0 ? (s1.charAt(i) - '0') : 0;
            int jValue = j >= 0 ? (s2.charAt(j) - '0') : 0;
            int sum = iValue + jValue + carry;
            carry = sum / 10;
            resSum += sum % 10;
        }
        resStr = String.valueOf(resSum);
        return resStr;
    }
}
