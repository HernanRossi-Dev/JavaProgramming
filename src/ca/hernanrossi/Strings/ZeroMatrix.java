package ca.hernanrossi.Strings;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by herna on 4/17/2016.
 */
public class ZeroMatrix {

    ZeroMatrix(){

    }

    public void run(int[][] input) {
        int rows = input.length;
        int columns = input[0].length;
       // Tuple[] zeros = new Tuple[rows*columns];
        LinkedList<Tuple> zeros = new LinkedList<Tuple>();
        for( int i = 0; i < rows; i ++) {
            for( int j = 0; j < columns; j++ ) {
                if(input[i][j] == 0) {
                    Tuple temp = new Tuple(i,j);
                    zeros.add(temp);
                }
            }
        }

        Iterator<Tuple> iterator = zeros.iterator();
        while(iterator.hasNext()){
            Tuple temp = iterator.next();
            for( int i = 0 ; i < columns ; i++ ){
                input[temp.getX()] [i] = 0;
            }
            for( int i = 0 ; i < rows ; i++ ){
                input[i][temp.getY()] = 0;
            }
        }

        for(int i = 0 ; i < rows; i++) {
            System.out.println(Arrays.toString(input[i]));
        }
    }

    // Custom tuple class to track pairs of values
    private class Tuple {
        private  int x;
        private int y;
        // Constructors

        Tuple(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Tuple(){
        }

        // Setter
        void setX(int x) {
            this.x = x;
        }
        void setY(int y) {
            this.y = y;
        }

        // Getters
        int getX(){
            return this.x;
        }
        int getY() {
            return this.y;
        }
    }
}


