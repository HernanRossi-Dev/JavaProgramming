package ca.hernanrossi.Strings;

import java.util.Scanner;

/**
 * Created by herna on 4/12/2016.
 */
public class URLify {

    public void QuestionThree(){

    }
    // Use the String.replaceAll(regex, replacement string) method
    public String run2() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter string: ");
        String one = reader.nextLine();
        return one.replaceAll(" ", "%20");
    }

    public String run() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter string: ");
        String one = reader.nextLine();
        int count = 0;
        int length = one.length();
        for( int i = 0 ; i < length; i++) {
            char c = one.charAt(i);
            if( c == ' ') {
                count++;
            }
        }
        if(count == 0 ){
            return one;
        }
        int new_length = length + count*3;
        char[] array = new char[new_length];
        while(length > 0) {
            length--;
            char s = one.charAt(length);
            if(s == ' '){
                new_length--;
                array[new_length] = '0';
                new_length--;
                array[new_length] = '2';
                new_length--;
                array[new_length] = '%';
            }else{
                new_length--;
                array[new_length] = s;

            }
        }
        String re = new String(array);
        System.out.println(re);
        return re;
    }
}
