public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int mostFreqLetter = 0;
        int left = 0;
        int max = 0;

        for(int right = 0; right < s.length(); right++){

            freq[s.charAt(right) - 'A']++;
            mostFreqLetter = Math.max(mostFreqLetter, freq[s.charAt(right) - 'A']);

            int lettersToReplace = (right - left + 1) - mostFreqLetter;

            if(lettersToReplace > k){
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            max = Math.max(max, right - left + 1);

        }

        return max;
    }
}
