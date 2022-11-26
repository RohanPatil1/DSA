import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {


        List<Integer> ansList = new ArrayList<>();

        for(int i = left; i<=right; i++){

            int currNumber = i;
            int originalNumber = i;
            boolean flag = true;

            while(currNumber>0){
                int currDigit = currNumber%10;
                currNumber /=10;

                if(currDigit == 0){
                    flag = false;
                    break;
                }

                if(originalNumber % currDigit != 0){
                    flag = false;
                }


            }

            if(flag) ansList.add(i);


        }


        return ansList;
    }
}
