import java.util.*;
public class EvaluateBooleanExpr {
    

    static Map<String,Integer> map = new HashMap<>();
    
    static int solve(String s,int i,int j,boolean isTrue){
        
        //Base Condition
        if(i>j) return 0;
        
        if(i>j)return 0;
        if(i==j)
        {
            if(isTrue==true)return s.charAt(i)=='T'?1:0;
            else return s.charAt(i)=='F'?1:0;
        }    
        
        String s1=Boolean.toString(isTrue);
        String s2=Integer.toString(i);
        String s3=Integer.toString(j);
        String temp=s1+s2+s3;
        if(map.containsKey(temp))return map.get(temp);
        int ans=0;

        // String temp  = Integer.toString(i)+" "+Integer.toString(j) +" "+Boolean.toString(isTrue);
        // if(map.containsKey(temp)){
        //     int value = map.get(temp);
        //     return value;
        // }
        
        //K loop
        for(int k=i+1;k<=j-1;k+=2){
            int lt = solve(s,i,k-1,true);
            int lf = solve(s,i,k-1,false);
            int rt = solve(s,k+1,j,true);
            int rf = solve(s,k+1,j,false);
            
            
            char c = s.charAt(k);
            if(c=='&'){
                if(isTrue){
                    ans += lt*rt;
                }else{
                    ans += lt*rf + lf*rt + lf*rf;
                }
            }else if(c=='|'){
                if(isTrue){
                    ans += lt*rf + lf*rt + lt*rt;
                }else{
                    ans += lf*rf;
                }
            }else if(c=='^'){
                if(isTrue){
                    ans += lf*rt + lt*rf;
                }else{
                    ans += rt*rf +lf*rf;
                }
            }
            
            
            
        }
        map.put(temp, ans);
        return ans;
        
        
    }
    
    static int countWays(int N, String S){
        // code here
        
        int i=0;
        int j=N-1;
        int ans =solve(S,i,j,true);
        map.clear(); 
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(countWays(35,"T|F^F&T|F^F^F^T|T&T^T|F^T^F&F^T|T^F"));
    }
}
