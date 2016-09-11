package com.leetcode;

/**
 * https://leetcode.com/problems/count-and-say/
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }

        String s = "1";
        for (int i = 1; i < n; ++i) {
            s = create(s);
        }

        return s;
    }


    private String create(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 1;

        char f = s.charAt(0);

        for (int i = 1; i < s.length(); ++i) {
            char curr = s.charAt(i);

            if (curr == f) {
                counter++;
            } else {
                sb.append(counter).append(f);
                counter = 1;
                f = curr;
            }
        }

        return sb.append(counter).append(f).toString();
    }
}
