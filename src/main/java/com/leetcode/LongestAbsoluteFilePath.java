package com.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/longest-absolute-file-path/
 * 31/12/2016.
 */
public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 0);
        int result = 0;

        for (String s : input.split("\n")) {
            int depth = s.lastIndexOf('\t') + 1;
            int len = s.length() - depth;

            if (s.contains(".")) {
                result = Math.max(result, hashMap.get(depth) + len);
            } else {
                hashMap.put(depth + 1, hashMap.get(depth) + len + 1);
            }
        }

        return result;
    }

}
