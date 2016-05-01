package ca.hernanrossi.Strings;

import java.util.Hashtable;

/**
 * Created by Hernan Rossi on 4/11/2016.
 */
public class OnePointOne {

    private String test;

    public OnePointOne(String test) {
        this.test = test;
    }

    public boolean run(){
        System.out.println("Checking if: " + test + " is a string with all unique characters");
        boolean unique = true;
        Hashtable<Character, Boolean> h_table = new Hashtable<>();
        for(int i = 0 ; i < test.length() ; i++) {
            char t = test.charAt(i);
            if(h_table.put(t, false) != null) {
                unique = false;
            }
        }
        System.out.println("Program ended with result: ");
        System.out.println(unique);
        return unique;
    }
}
