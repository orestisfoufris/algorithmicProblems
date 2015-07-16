package com.topcoder.div2.levelOne;

/**
 * Created by Orestis on 15/10/2014
 * http://community.topcoder.com/stat?c=problem_statement&pm=13125  -- First example was a bit misleading
 */
public class WakingUpEasy {

    public int countAlarms(int[] volume, int sleepiness) {
        int count = 0;
        while (sleepiness > 0) {
            for (int i = 0; i < volume.length; i++) {
                if (sleepiness <= 0) {
                    return count;
                }
                sleepiness = sleepiness - volume[i];
                count += 1;
            }
        }
        return count;
    }
}


