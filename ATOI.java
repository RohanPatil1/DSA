public class ATOI {



    //"123"=>123
    public static int atoi (String str) {
        int size =str.length();

        int res = 0;
        for(int i=0;i<size;i++){

            char curr = str.charAt(i); // "3"
            if(!Character.isDigit(curr)){
                return -1;
            }

            res = res*10  + (curr-'0');

        }


        return res;
    }
    
    public static void main(String[] args) {
        
    }
    
}
