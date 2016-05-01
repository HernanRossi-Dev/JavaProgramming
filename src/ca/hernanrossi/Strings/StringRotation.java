package ca.hernanrossi.Strings;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by herna on 4/17/2016.
 */
public class StringRotation {
    StringRotation(){
        // Constructor
    }

    public boolean run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Give the first string: ");
        String one = scanner.next();
        System.out.println("Give the second string: ");
        String two = scanner.next();
        if(one.length() !=  two.length()) {
            return  false;
        }
        int length = one.length();
        char[] charOne = one.toCharArray();
        char[] charTwo = two.toCharArray();
        StringBuilder x = new StringBuilder();
        StringBuilder y = new StringBuilder();
        //char[] x= new char[0];
       // char[] y = new char[0];

        int xTracker = 0;
        for( int i = 0; i < length; i++ ) {
            if(charOne[0] == charTwo[i]){
               // x  = new char[length - i];
                for( int j = i ; j< length; j++) {
                    if(charOne[xTracker] == charTwo[j]) {
                       // System.out.println(charOne[0] + " " + charTwo[i]);
                        x.append(charOne[xTracker]);
                        xTracker++;
                    }else{return false;}
                }
               // y = new char[length - xTracker];
               for (int j =xTracker; j< length;j++){
                    y.append(charOne[j]);
                    //System.out.println(y[yTracker]);
                }
            }
        }

        String yout = new String(y);
        String xout = new String(x);
        System.out.println(yout);
        System.out.println(xout);

        StringBuilder temp = new StringBuilder(yout);
        temp.append(xout);
        String output = temp.toString();

        System.out.println(Arrays.toString(output.trim().getBytes()));
        System.out.println(Arrays.toString(two.getBytes()));
        if(two.compareTo(output) == 0){
            System.out.println("yes");
            return true;
        }else{
            System.out.println("no");
            return false;
        }
    }
}
