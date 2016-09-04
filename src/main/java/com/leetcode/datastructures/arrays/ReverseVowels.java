package com.leetcode.datastructures.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class ReverseVowels {

    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('o'); vowels.add('e'); vowels.add('u'); vowels.add('i');
        vowels.add('A'); vowels.add('O'); vowels.add('E'); vowels.add('U'); vowels.add('I');

        int st = 0;
        int e = s.length() - 1;

        char[] array = s.toCharArray();

        while (st < e) {
            if (vowels.contains(array[st]) && vowels.contains(array[e])) {
                swap(array, st, e);
                e--;
                st++;
            }
            else if (!vowels.contains(array[e])){
                e--;
            } else {
                st++;
            }
        }

        return new String(array);
    }

    private void swap(char[] array, int a, int b) {
        char tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

}
