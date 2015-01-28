package com.topcoder.div2.stage1;

/**
 * Created by Orestis on 28/01/2015
 * problem statement: http://community.topcoder.com/stat?c=problem_statement&pm=13632&rd=16279
 */
public class PeacefulLine {
    public static String makeLine(int[] x){
        int max=0;
        for (int aX : x) {
            int count = 0;
            for (int aX1 : x) {
                if (aX == aX1) {
                    count += 1;
                }
            }
            max = Math.max(max, count);
        }
        if((max * 2) - 1 <= x.length){
            return "Possible";
        }
        return "Impossible";
    }
}
