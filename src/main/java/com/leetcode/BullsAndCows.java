package com.leetcode;

/**
 * https://leetcode.com/problems/bulls-and-cows/
 */
public class BullsAndCows {

    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0, size = secret.length();
        char s, g;
        int[] array = new int[256];

        for(int i = 0; i < size; ++i) {
            s = secret.charAt(i);
            g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                array[s]++;
            }
        }

        for(int i = 0; i < size; ++i) {
            g = guess.charAt(i);
            s = secret.charAt(i);

            if(array[g] > 0 && g != s) {
                cows++;
                array[g]--;
            }
        }

        return bulls + "A" + cows + "B";
    }

}
