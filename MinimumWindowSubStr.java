import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubStr {
    public String minWindow(String s, String t) {

        Map<Character,Integer> map =new HashMap<>();

        for(int i=0;i<t.length();i++){
            char ti = t.charAt(i);
            map.put(ti,map.getOrDefault(ti,0)+1);
        }
        int trackCount = map.size(); //0 indicates we got a match

        int j=0;
        int i=0;
        int minWindowSize = Integer.MIN_VALUE;
        String minString = "";
        while(j<s.length()){

            //Put "j"th character to map
            char sj = s.charAt(j);
            if(map.containsKey(sj)){
                map.put(sj,map.get(sj)-1);
                if(map.get(sj)==0){
                    trackCount--;
                }
            }

            //Check for result
            if(trackCount>0){
                j++;
            }else if(trackCount == 0){
                int windowSize = j-i+1;
                System.out.println("GOT "+minWindowSize+" "+windowSize);
                if(minWindowSize==Integer.MIN_VALUE || (j-i+1) < minWindowSize){
                    minWindowSize = j-i+1;
                    minString = s.substring(i,j+1);
                    System.out.println("UPDATING STR "+minString);
                }


                //Remove i & get a better ans if possible
                while(trackCount==0 && i<=j){
                    char si = s.charAt(i);
                    if(map.containsKey(si)){
                        if(map.get(si)==0) trackCount++;

                        map.put(si,map.get(si)+1);
                    }
                    i++;

                    //Check for better ans
                    if(trackCount==0 && j-i+1 < minWindowSize){
                        minWindowSize = j-i+1;
                        minString = s.substring(i,j+1);
                    }

                }//While for si ends
                j++;

            }

        }//While ends


        return minString;
    }
}
