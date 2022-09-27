import java.util.*;
import java.util.LinkedList;

public class WordLadder {

    static class LadderPair {
        String str;
        int step;

        public LadderPair(String str, int step) {
            this.str = str;
            this.step = step;
        }
    }


    public static int wordLadder1(String startWord, String endWord, String[] wordList) {

        int stepCount = 0;
        Queue<LadderPair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        int len = wordList.length;

        //Add all words to set
        for (String s : wordList) {
            set.add(s);
        }

        q.add(new LadderPair(startWord, 1));
        //deleting from set means visited[str] = 1
        set.remove(startWord);
        while (!q.isEmpty()) {
            LadderPair currPair = q.poll();
            String currWord = currPair.str;
            int currStep = currPair.step;

            if (currWord.equals(endWord)) {
                return currStep;
            }

            //For every character in currWord
            for (int i = 0; i < currWord.length(); i++) {
//                char original = currWordArr[i];
                char[] replaceStrArr = currWord.toCharArray(); //hat
                for (char ch = 'a'; ch <= 'z'; ch++) {

                    replaceStrArr[i] = ch; //aat, bat, cat, dat,...,zat (i=0)  //hat, hbt, hct, ..hzt (i=1)...
                    String replacedWord = new String(replaceStrArr);

                    if (set.contains(replacedWord)) {
                        set.remove(replacedWord);
                        q.add(new LadderPair(replacedWord, currStep + 1));
                    }

//                    currWordArr[i] = ch; //aat, bat, cat, ...zat
//
//                    //Check if the new word exist in set
//                    if (set.contains(new String(currWordArr))) {
//                        set.remove(currWord);
//                    }
//                    q.add(new LadderPair(currWord, currStep + 1));
//
//                }
//                currWordArr[i] = original;
                }
            }


        }


        return stepCount;
    }


    public static ArrayList<ArrayList<String>> wordLadder2(String startWord, String endWord, String[] wordList) {

        ArrayList<ArrayList<String>> resultList = new ArrayList<>();
        Queue<ArrayList<String>> q = new LinkedList<>();
        int len = wordList.length;

        //Add all words to set
        Set<String> set = new HashSet<>(Arrays.asList(wordList));

        //Add first sequence {startWord}
        ArrayList<String> firstSeq = new ArrayList<>();
        firstSeq.add(startWord);
        q.add(firstSeq);

        ArrayList<String> wordsUsedOnLevel = new ArrayList<>();
        wordsUsedOnLevel.add(startWord);
        int level = 0;

        while (!q.isEmpty()) {
            ArrayList<String> currSeq = q.poll();

            //Erase all words that has been used in previous levels to transform
            if (currSeq.size() > level) {
                level++;
                for (String k : wordsUsedOnLevel) {
                    set.remove(k);
                }
            }

            //Get the currWord i.e the last
            String word = currSeq.get(currSeq.size() - 1);
            for (int i = 0; i < word.length(); i++) {
                char[] replaceStrArr = word.toCharArray(); //hat
                for (char ch = 'a'; ch <= 'z'; ch++) {

                    replaceStrArr[i] = ch; //aat, bat, cat, dat,...,zat (i=0)  //hat, hbt, hct, ..hzt (i=1)...
                    String replacedWord = new String(replaceStrArr);
                    if (set.contains(replacedWord)) {
                        //Make a new seq and add to queue
                        ArrayList<String> newSeq = new ArrayList<>(currSeq);
                        newSeq.add(replacedWord);
                        q.add(newSeq);

                        //mark as visited on  the level
                        wordsUsedOnLevel.add(replacedWord);
                        currSeq.remove(currSeq.size() - 1);


                    }
                }
            }
        }
        return resultList;
    }
}
