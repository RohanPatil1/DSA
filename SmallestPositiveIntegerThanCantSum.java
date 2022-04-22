public class SmallestPositiveIntegerThanCantSum {
    

    static int spi(int[] arr){
        int n = arr.length;
        int ans = 1;
        for(int i=0;i<n;i++){
            if(arr[i]>ans)
                return ans;

            ans += arr[i];
        }   

        return ans;

    }
    public static void main(String[] args) {
            System.out.println(spi(new int[]{1,1,1}));
    }

}
