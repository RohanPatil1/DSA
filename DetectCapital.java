public class DetectCapital {

    public boolean detectCapitalUse(String word) {

        int capsCount = 0;
        for(int i=0; i<word.length(); i++){
            char c = word.charAt(i);

            if(Character.isUpperCase(c)){
                capsCount++;
            }
        }

        if(capsCount == word.length()) return true;

        if((capsCount == 1) && Character.isUpperCase(word.charAt(0))) return true;

        if(capsCount == 0) return true;

        return false;
    }
}
