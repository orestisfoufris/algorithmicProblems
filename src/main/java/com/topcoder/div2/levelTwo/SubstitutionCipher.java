package com.topcoder.div2.levelTwo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Orestis
 * Problem Statement : https://community.topcoder.com/stat?c=problem_statement&pm=14074&rd=16552
 */
public class SubstitutionCipher {

    public static String decode(String a, String b, String y) {
        String allLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int length = a.length();

        Set<Character> charsA = new HashSet<>();
        for (int i = 0; i < length; i++) {
            charsA.add(a.charAt(i));
        }

        Set<Character> missingLetterA = new HashSet<>();
        Set<Character> missingLetterB = new HashSet<>();

        char missingB = '\u0000';
        char missingA = '\u0000';
        if (charsA.size() == 25) { // one letter is missing
            for (int i = 0; i < length; i++) {
                missingLetterA.add(a.charAt(i));
                missingLetterB.add(b.charAt(i));
            }
            for (int i = 0; i < allLetters.length(); i++) {
                if (!missingLetterA.contains(allLetters.charAt(i))) {
                    missingA = allLetters.charAt(i);
                }
                if (!missingLetterB.contains(allLetters.charAt(i))) {
                    missingB = allLetters.charAt(i);
                }
            }
        }

        Map<Character, Character> letters = new HashMap<>();

        for (int i = 0; i < length; i++) {
            letters.put(b.charAt(i), a.charAt(i));
        }

        if (missingA != '\u0000' && missingB != '\u0000') {
            letters.put(missingB, missingA);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < y.length(); i++) {
            if (!letters.containsKey(letters.get(y.charAt(i)))) {
                return "";
            }

            stringBuilder.append(letters.get(y.charAt(i)));
        }

        return stringBuilder.toString();
    }
}
