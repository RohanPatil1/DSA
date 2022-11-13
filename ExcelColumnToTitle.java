public class ExcelColumnToTitle {

    public static int titleToNumber(String str) {
        int res = 0;

        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);

            //res = res*10 + arr[i];
            res = res * 26 + (currChar - 'A' + 1); //+1 since A starts with 1... 65-65+1 = 1

        }

        return res;
    }

    public static String numberToTile(int n) {
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();

        //26-> n=26-1=25... 25%26 = 25 ='Z'
        while (n > 0) {
            n = n - 1; //since we want till 0 to 25

            sb.append(letters.charAt(n % 26));
            n = n / 26;
        }

        sb.reverse();
        return sb.toString();
    }
}
