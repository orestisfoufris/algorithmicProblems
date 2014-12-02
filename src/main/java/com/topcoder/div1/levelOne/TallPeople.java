package com.topcoder.div1.levelOne;

import java.util.*;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by sweetleaf on 27/09/2014.
 * http://community.topcoder.com/stat?c=problem_statement&pm=2923&rd=5854
 */
public class TallPeople {

    public int[] getPeople(String[] people ){
        int min = 0, max = 0;
        List<Integer> heights = newArrayList();
        for(int i = 0; i < people.length; i++){
            String[] num = people[i].split(" ");
            for(int j = 0; j < num.length; j++) {
                heights.add(Integer.parseInt(num[j]));
            }
        }

        int columns = people[0].split(" ").length;
        int rows = people.length;

        int[][] matrix = new int[rows][columns];
        int count = 0;

        for(int i = 0 ; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = heights.get(count);
                count++;
            }
        }

        int[] x = new int[rows];
        for(int i = 0 ; i < rows ; i++){
            x[i] = 1000000;
            for(int y = 0; y < columns;y++){
                x[i] = Math.min(matrix[i][y], x[i]);
            }
            min = Math.max(min, x[i]);
        }

        x = new int[columns];
        max = 1000000;
        for(int i = 0; i < columns; i++){
            x[i] = -1;
            for(int j = 0; j < rows; j++){
                x[i] = Math.max(matrix[j][i], x[i]);
            }
            max = Math.min(max, x[i]);
        }

//        for(int[] ar : matrix){
//           System.out.println(Arrays.toString(ar));
//      }
        return new int[] {min, max};
    }
}
