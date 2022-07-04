class SmallestNumber{
    static String smallestNumber(int s, int d){
        String ans = "";
        
        //Putting all 9 not working
        if(9*d < s){
            return "-1";
        }
        
        for(int i=d-1;i>=0;i--){
            if(s>9){
                ans ='9' + ans;
                s -=9;
            }else{
                if(i==0){
                    ans = String.valueOf(s) + ans;
                }else{
                    ans = String.valueOf(s-1) + ans;
                    
                    i--;
                    
                    while(i>0){
                        ans = '0' + ans;
                        i--;
                        
                    }
                    
                    ans = '1' + ans;
                    break;
                    
                }
                
            }
            
        }
            
        return ans;
        
    }
}