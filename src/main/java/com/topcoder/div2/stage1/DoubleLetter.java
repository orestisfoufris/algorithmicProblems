package com.topcoder.div2.stage1;

/**
 * Created by Orestis on 30/09/2014
 * http://community.topcoder.com/stat?c=problem_statement&pm=13378
 */
public class DoubleLetter {
    public String ableToSolve(String input) {
        int i = 0;
        int r = input.length();
        while(i+1 < r){
            if(input.charAt(i) == input.charAt(i + 1)){
                input = input.substring(0,i) + input.substring(i+2, r);
                 i = 0;
                r = input.length();
            }
            else {
                i = i +1;
                r = input.length();
            }
        }
        if(input.equals("")){
            return "Possible";
        }
        return "Impossible";
    }
}
