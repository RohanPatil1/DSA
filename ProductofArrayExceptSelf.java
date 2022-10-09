public class ProductofArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];

        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = nums[i]*prefix[i-1];
        }

        postfix[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--){
            postfix[i] = nums[i]*postfix[i+1];
        }


        int[] prodArr = new int[n];
        prodArr[0] = postfix[1];
        prodArr[n-1] = prefix[n-2];
        for(int i=1; i<n-1; i++){
            prodArr[i] = prefix[i-1]*postfix[i+1];
        }

        return prodArr;
    }

    public int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int right=1,left=1;
        for (int i=0;i<n;i++) {
            res[i]=left;
            left*=nums[i];
        }
        for(int i=n-1;i>=0;i--) {
            res[i]*=right;
            right*=nums[i];
        }
        return res;
    }
/*
{              1,         a[0],    a[0]*a[1],    a[0]*a[1]*a[2],  }
{ a[1]*a[2]*a[3],    a[2]*a[3],         a[3],                 1,  }
 */
}
