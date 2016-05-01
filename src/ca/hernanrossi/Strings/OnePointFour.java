package ca.hernanrossi.Strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by herna on 4/14/2016.
 */
public class OnePointFour {

    public void Question4() {

    }

    public boolean run(){
        Scanner scanner  =  new Scanner(System.in);
        System.out.println("Input the test string: ");
        String string = scanner.nextLine();
        char[] array = string.replaceAll(" ", "").toLowerCase().toCharArray();
        int length = array.length;
        if( length == 1) {
            return true;
        }else if(length % 2 == 0){
            // length is even only have an even number of each character unless length is 1
            HashMap<Character, Integer> hashMap = getHmap(array, length);
            // Get an iterator for the entrySet set of the hashmap
            Iterator it = hashMap.entrySet().iterator();
            while(it.hasNext()) {
                // Go through the iterator an check if all the entries are even
                Map.Entry pair = (Map.Entry)it.next();
                if( (int)pair.getValue() % 2  != 0) {
                    // If all the entries aren't even return false
                    return false;
                }
            }
            // All entries were even return true
            return true;
        }else{
            // length is odd must have 1 odd number character and all even other than that
            HashMap<Character, Integer> hashMap = getHmap(array, length);
            Iterator it = hashMap.entrySet().iterator();
            // Must have a single character that has an odd
            int number_of_odd = 0;
            while(it.hasNext()) {
                // Go through the iterator an check if all the entries are even
                Map.Entry pair = (Map.Entry)it.next();
                if( (int)pair.getValue() % 2  != 0) {
                    // If all the entries aren't even return false
                    number_of_odd++;
                }
            }
            if(number_of_odd != 1) {
                return false;
            }else {
                return  true;
            }
        }
    }

    private HashMap<Character, Integer> getHmap(char[] array, int length) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for( int i = 0; i < length ; i++) {
            char c = array[i];
            if( hashMap.containsKey(c)){
                int count = hashMap.get(c);
                hashMap.put(c, ++count);
            }else {
                hashMap.put(c, 1);
            }
        }
        return hashMap;
    }
}
