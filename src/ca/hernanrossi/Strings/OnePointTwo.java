package ca.hernanrossi.Strings;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by herna on 4/12/2016.
 */
public class OnePointTwo {

    public void QuestionTwo() {
        // constructor
    }


    public boolean test() {
        int space_count = 0;
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter string one: ");
        String one = reader.nextLine();
        System.out.println("Enter string two: ");
        String two = reader.nextLine();

        if(one.length() != two.length() ) {
            return false;
        }
        HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
        for( int i = 0; i < one.length(); i ++) {
            char c = one.charAt(i);
            if(c == ' ' ) {
                space_count++;
            } else if( hmap.containsKey(c)){
                int count = hmap.get(c);

                hmap.put(c, ++count);
            }
            else {
                hmap.put(c, 0);
            }
        }
        for( int i = 0; i < two.length(); i ++) {
            char c = two.charAt(i);
            if(c == ' ') {
                space_count--;
            } else if(hmap.containsKey(c)) {
                int count = hmap.get(c);
                if(count == 0) {
                    hmap.remove(c);
                }else {
                    hmap.put(c, --count);
                }
            }else {
                return false;
            }
        }
        if(space_count != 0) {
            return false;
        } else if ( !hmap.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
