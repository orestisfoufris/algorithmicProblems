package com.topcoder.div2.levelOne;

/**
 * Created by Orestis on 20/10/2014
 * http://community.topcoder.com/stat?c=problem_statement&pm=12811
 */
public class FoxAndClassroom {

    public String ableTo(int n, int m){
        for(int i = 2; i <= Math.min(n, m); i++){
            if (n % i == 0 && m % i == 0){
                return "Impossible";
            }
        }
        return "Possible";
    }
}
