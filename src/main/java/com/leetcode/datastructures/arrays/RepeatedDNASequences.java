package com.leetcode.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() <= 10) { return new ArrayList<>(); }

        List<String> results = new ArrayList<>();
        HashMap<String, Boolean> seen = new HashMap<>();
        StringBuilder sb = new StringBuilder(s.substring(0, 10));
        seen.put(sb.toString(), false);

        for (int i = 10; i < s.length(); ++i) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));

            String str = sb.toString();

            if (!seen.containsKey(str)) {
                seen.put(str, false);
            } else {
                boolean value = seen.get(str);
                if (!value) {
                    results.add(str);
                    seen.put(str, true);
                }
            }
        }

        return results;
    }

}
