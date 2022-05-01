
import java.util.*;
public class MaxVowelsInSubstr {
    
    public static boolean isVowel(char c){
       
        if(c=='a' ||c=='e'||c=='i'||c=='o'||c=='u' ){
            return true;
        }
        return false;
    }

    public static int getVowelCount(String s){
        int count=0;
        
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='a' ||c=='e'||c=='i'||c=='o'||c=='u' ){
                count++;
            }
        }
        
        return count;
    }
    
    public static int maxVowels(String s, int k) {
        
        int i=0,j=0;
        int n=s.length();
        int ans = 0;
        String temp = "";
        int count = 0;
        while(j<n){
            temp += s.charAt(j);
            if(isVowel(s.charAt(j))){
                count++;
            }

            if((j-i+1)<k){
                j++;
            }else if((j-i+1)==k){
                ans = Math.max(ans,count);

                //Remove Calc for i
                if(isVowel(temp.charAt(i))){
                    count--;
                }
                //temp = temp.substring(1);
                i++;
                j++;
            }
        }

        return ans;
        
    }


    public static void main(String[] args) {
        System.out.println(maxVowels("abciiidef", 3));        
    }
}
