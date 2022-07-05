public class PowerOfN {


    public static int  powerOfN(int n,int r) {

        if(r==0) return 1;

        int ans = powerOfN(n,r/2);
        int ansSq =ans*ans;

        //n is odd
        if(n%2==1){
            return ansSq*n;
        }

        return ansSq; //Even

    }

    public static void main(String[] args) {

    }

}
