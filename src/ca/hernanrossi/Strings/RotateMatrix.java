package ca.hernanrossi.Strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by herna on 4/15/2016.
 */
public class RotateMatrix {
    public void OnePointSeven(){

    }

    public void run(int[][] input) {
        int rows = input.length;
        int columns = input[0].length;
        int[][] output = new int[rows][columns];
        for( int i = 0 ; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                output[j][columns-i-1] = input[i][j];
            }

        }
        for(int i = 0 ; i < rows; i++) {
            System.out.println(Arrays.toString(output[i]));

        }
    }
}
