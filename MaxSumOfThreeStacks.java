
class MaxSumOfThreeStacks{
    public static int maxEqualSum(int n1,int n2,int n3, int[] s1, int[] s2, int[] s3) {
        // code here
        
        int sum1 = 0,sum2=0,sum3 = 0;
        
        for(int a:s1) sum1 += a;
        for(int a:s2) sum2 += a;
        for(int a:s3) sum3 += a;
        
        
        int top1=0,top2=0,top3=0;
        
        int ans  =0;
        while(true){
            
            if(top1==n1 || top2==n2 || top3==n3){
                ans =0;
                break;
            }else if(sum1==sum2 && sum2==sum3){
                ans = sum1;
                break;
            }else{
                
                
                if(sum1>=sum2 && sum1>=sum3){
                    sum1 -= s1[top1++];
                }else if(sum2>=sum3 && sum2>=sum2){
                    sum2 -= s2[top2++];
                }else if(sum3>=sum1 && sum3>=sum2){
                    sum3 -= s3[top3++];
                }
                
                
            }
            
            
            
            
        }
        
        
        
        return ans;
    }
}