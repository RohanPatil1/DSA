public class ATOI {


    //"123"=>123
    public static int atoi(String str) {
        int size = str.length();

        int res = 0;
        for (int i = 0; i < size; i++) {

            char curr = str.charAt(i); // "3"
            if (!Character.isDigit(curr)) {
                return -1;
            }

            res = res * 10 + (curr - '0');

        }


        return res;
    }

    //gfg
    int atoi1(String str) {
        // Your code here
        int size = str.length();
        boolean isNeg = false;


        if (str.charAt(0) == '-') {
            isNeg = true;
            str = str.substring(1);
        }


        int res = 0;
        for (int i = 0; i < str.length(); i++) {

            char curr = str.charAt(i); // "3"
            if (!Character.isDigit(curr)) {
                return -1;
            }

            res = res * 10 + (curr - '0');

        }

        if (isNeg)
            return (res - 2 * res);

        return res;
    }

    public static void main(String[] args) {

    }

}
