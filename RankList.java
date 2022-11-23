import java.util.Scanner;

public class RankList {


    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int t = sc.nextInt();
        while (t-- > 0) {
            int[] arr = new int[2];

            for (int i = 0; i < 2; i++) {
                arr[i] = sc.nextInt();
            }

            int n = arr[0];
            int s = arr[1];


            while(s>0){
                s -= n;
                n--;
                if(n<0){
                    break;
                }
            }

            System.out.println(n);

        }
    }

}

/*
for (int i = 0; i < n; i++)
    {
        cin >> arr[i];
        if (arr[i] > maxi1)
        {
            maxi2 = maxi1;
            maxi1 = arr[i];
        }
        else if (arr[i] > maxi2)
        {
            maxi2 = arr[i];
        }
    }
 */