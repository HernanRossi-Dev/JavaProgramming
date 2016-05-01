package ca.hernanrossi.Strings;

import java.util.Scanner;

/**
 * Created by herna on 4/15/2016.
 */
public class StringCompression {

    public void OnePointSix() {
    }

    public String run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string to compress repeat characters: ");
        String input = scanner.nextLine();
        char[] charArray = input.toCharArray();
        int length = input.length();
        StringBuilder output = new StringBuilder("");
        char prev = charArray[0];
        int count =0;
        for(int i = 0; i < length ; i++) {
            if(charArray[i] == prev && i < length-1 ) {
                // System.out.println(charArray[i] + " " + prev + " " + count);
                count++;
            }else if(charArray[i] != prev && (i == length-1) ) {
                output.append(prev);
                output.append(count);
                output.append(charArray[i]);
                output.append(1);
            } else if(charArray[i] == prev && (i == length-1) ) {
                output.append(prev);
                output.append(++count);
            }else {
                output.append(prev);
                output.append(count);
                count = 1;
                prev = charArray[i];
                // System.out.println(output.toString());
            }
        }

        if(output.length() > input.length()){
            return input;
        }else {
            return output.toString();
        }
    }

}
