package ca.hernanrossi.Strings;

import java.util.Scanner;

/**
 * Created by herna on 4/15/2016.
 */
public class OnePointFive {

    public void QuestionFive() {

    }

    public boolean run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the first string: ");
        String stringOne = scanner.nextLine();
        System.out.println("Input the second string: ");
        String stringTwo = scanner.nextLine();

        int lengthOne = stringOne.length();
        int lengthTwo = stringTwo.length();
        // more than one change
        if((lengthOne - lengthTwo) < -1 || (lengthOne - lengthTwo) > 1) {
            return false;
        }
        // zero changes
        if(stringOne.equals(stringTwo)) {
            return true;
        }

        char[] charArrayOne = stringOne.toCharArray();
        char[] charArrayTwo = stringTwo.toCharArray();
        if(lengthOne - lengthTwo == -1 ) {
            return oneInsert(charArrayTwo, charArrayOne);
        }else if(lengthTwo - lengthOne == -1) {
            return oneInsert(charArrayOne, charArrayTwo);
        }else {
            int differencesFound = 0;
            for (int i = 0; i < charArrayOne.length; i++) {
                if (differencesFound > 1) {
                    return false;
                } else if (charArrayOne[i] != charArrayTwo[i]) {
                    differencesFound++;
                } else {
                }
            }
        }
        return true;
    }

    private boolean oneInsert(char[] wordLong, char[] wordShort) {
        // stringTwo has a character more therefor all other character must be the same as stringOne
        int differencesFound = 0;
        int j = 0;
        for(int i = 0 ; i < wordLong.length; i++) {
            if(differencesFound > 1) {
                return false;
            }else if(j == wordShort.length && differencesFound == 0){
                return true;
            }else if(wordLong[i] != wordShort[j]){
                differencesFound++;
            }else{
                j++;
            }
        }
        return true;
    }

}
