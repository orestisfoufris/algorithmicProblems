package com.topcoder.div2.stage1;

import java.util.Objects;

/**
 * Created by Orestis on 29/03/2015
 */

public class SquareScoresDiv2 {

    public int getScore(String s) {
        String[] array = s.split("(?!^)");
        int result = array.length;
        for(int i = 0; i < array.length - 1; i++) {
            int c = 0, j = i;
            while(j < array.length - 1 && Objects.equals(array[j], array[j + 1])) {
                j++; c++;
            }
            if (c != 0) i = j;
            while(c > 0){
                result += c;
                c--;
            }
        }
        return result;
    }
}
