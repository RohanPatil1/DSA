import java.util.*;

import javax.swing.text.StyledEditorKit.BoldAction;

public class BasicRecursion {
    

    //Reverse a string
    public static void revStr(String s,int index){
        if(index <0){
            //To print 0 index
           // System.out.print(s.charAt(index));
            return;
        }
        System.out.print(s.charAt(index));
        revStr(s,index-1);
      
    }


     //Find the first & last occurance of a chararcter in a string
     //abaacdaefaah => a- 0,10

     public static int first = -1;
     public static int last = -1;

     public static void getOccurance(String s,int index,char element){




        
        if(index==s.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }

        char currentChar = s.charAt(index);
        if(currentChar==element){
            if(first == -1){
                //First is not initialised
                first = index;
            }else{
                //Update last
                last = index;
            }
        }
        getOccurance(s, index + 1, element);
     }

     //Check if array is sorted
     public static boolean checkSorted(int[] arr,int index){
         if(index==arr.length-1){
             //We reached last
             return true;
         }

         if(arr[index] >= arr[index+1]){
            return false;
         }

        return  checkSorted(arr, index+1);

     }


     //Move all x to end axbcdxs => avcdsxx
     public static void moveAllX(String s,int index,int countX,String newStr){
      
        if(index==s.length()-1){
        
            //Add x countX times
            for(int i=0;i<countX;i++){
                newStr +='x';
            }
            System.out.println(newStr);
            return;
        }
      
      
        char currChar = s.charAt(index);
         if(currChar == 'x'){
             countX++;
             moveAllX(s, index+1, countX, newStr);
         } else{
             newStr += currChar;
             moveAllX(s, index+1, countX, newStr);
         }

     }


     //Remove Duplicates
     public static void removeDuplicates(String s){
        Set<Character> strSet =new HashSet();
        for(int i=0;i<s.length();i++){
            strSet.add(s.charAt(i));
        }
        System.out.println(strSet);
     }
     public static void removeDuplicatesRecursion(String s,int index,String newStr){
         if(index == s.length()-1){
            System.out.println(newStr);
            return;
         }
         char currChar = s.charAt(index);
         if(!newStr.contains(Character.toString(currChar))){
            newStr += currChar;
         }
         removeDuplicatesRecursion(s, index+1, newStr);
     }

     //Logic is make a map{0:true,1:false}...for all 26 letters which represent the occurance of 'a' 'b'
     //Also to get index of [currChar - 'a'] (For eg: 'z' - 'a' = 25)
     public static boolean[] map = new boolean[26]; //All False by default
     public static void removeDuplicatesRecursion2(String s,int index,String newStr){

        if(index == s.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = s.charAt(index);
        if(map[currChar-'a'] == true){
            //It has already occured
            removeDuplicatesRecursion2(s, index+1, newStr);
        }else{
            //New Letter
            newStr += currChar;
            map[currChar-'a'] = true;
            removeDuplicatesRecursion2(s, index+1, newStr);
        }

     }



    //Print all subsequences
    public static void getAllSubS(String s,int index,String newStr){
        if(index == s.length()){
            System.out.println(newStr);
            return;
        }



        char currChar = s.charAt(index);
        
        //Include
        getAllSubS(s, index+1, newStr+currChar);

        //Not Include
        getAllSubS(s, index+1, newStr);
    }


    
    //Print all UNIQUE subsequences
    public static void getUniqueSubS(String s,int index,String newStr,HashSet<String> set){
        
        if(index == s.length()){
            if(set.contains(newStr)){
                return;
            }
            else{
                System.out.println(newStr);
                set.add(newStr);
                return;
            }
        }



        char currChar = s.charAt(index);
        
        //Include
        getUniqueSubS(s, index+1, newStr+currChar,set);

        //Not Include
        getUniqueSubS(s, index+1, newStr,set);
    }



    ///Keypad Combinations Problem

    public static String[] keypad={".","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static void getAllKeypadComb(String str,int index,String combination){


         if(index==str.length()){
             System.out.println(combination);
             return;
         }

        //To get currMapping currChar - '0' (For eg: '2' - '0' = 2) So keypad[2]="def"

        char currChar = str.charAt(index);
        String mapping = keypad[currChar-'0'];
        for(int i=0;i<mapping.length();i++){
            getAllKeypadComb(str, index+1, combination+mapping.charAt(i));
        }
    }

    public static void main(String[] args) {
        String s= "rohan";
        revStr(s, 4);
        System.out.println("---------------------");

        s = "abaacdaefaah";
        getOccurance(s, 0, 'a');
        System.out.println("---------------------");

        int[] arr =new int[]{1,2,3,4,5,6,7};
        boolean result = checkSorted(arr, 0);
        System.out.println(result);

        System.out.println("---------------------");
        s = "axvcxxd";
        moveAllX(s, 0, 0, "");

        System.out.println("---------------------");
        s="abbccda";
        removeDuplicates(s);
        removeDuplicatesRecursion(s,0,"");

        int a = 'z' - 'a';
        System.out.println(a);
        removeDuplicatesRecursion2(s,0,"");

        System.out.println("---------------------");
        s="abc";
        getAllSubS(s, 0, "");
        
        System.out.println("---------------------");
        s="aaa";
        HashSet<String> set = new HashSet<>();
        getUniqueSubS(s, 0, "",set);
        System.out.println("---------------------");
        s="23";
        getAllKeypadComb(s, 0 ,"");

    }
}
