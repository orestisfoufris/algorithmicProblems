package com.topcoder.div2.levelOne;

/**
 * Created by Orestis on 19/10/2014
 * http://community.topcoder.com/stat?c=problem_statement&pm=11084
 */
public class TwoWaysSorting {

    public String sortingMethod(String[] stringList){
        boolean isLex = lexicographically(stringList);
        boolean isLen = lengths(stringList);
        if(isLen && isLex){
            return "both";
        }else if(isLen){
            return "lengths";
        }else if(isLex){
            return "lexicographically";
        }else{
            return "none";
        }
    }

    private boolean lexicographically(String[] stringList){
        boolean result = true;
        if(stringList.length == 1){
            return true;
        }
        for(int i = 0; i < stringList.length; i++){
            int j = stringList.length-1;
            while(j > 0){
                if((int)stringList[j].charAt(0) >= (int)stringList[j-1].charAt(0)){
                    j--;
                }else {
                    return false;
                }
            }
        }
        return result;
    }

    private boolean lengths(String[] stringList){
        if(stringList.length == 1){
            return true;
        }
        boolean result = true;
        for(int i = 0; i < stringList.length; i++){
            int j = stringList.length-1;
            while(j > 0) {
                if (stringList[j].length() >= stringList[j - 1].length()) {
                    j--;
                } else {
                    return false;
                }
            }
        }
        return result;
    }
}
