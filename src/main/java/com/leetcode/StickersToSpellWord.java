package com.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/stickers-to-spell-word/submissions/
 */
public class StickersToSpellWord {

    private static int NUM_CHARS = 26;

    public static int minStickers(String[] stickers, String target) {
        int[][] charsPerWord = new int[stickers.length][NUM_CHARS];
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);

        for (int i = 0; i < stickers.length; i++) {
            for (char c : stickers[i].toCharArray()) {
                charsPerWord[i][c - 'a']++;
            }
        }

        return solve(target, charsPerWord, dp);
    }

    private static int solve(String target, int[][] charsPerWord, Map<String, Integer> dp) {
        if (dp.containsKey(target)) {
            return dp.get(target);
        }

        int ans = Integer.MAX_VALUE;

        int[] tar = new int[NUM_CHARS];
        for (char c : target.toCharArray()) {
            tar[c - 'a']++;
        }

        for (int[] sticker : charsPerWord) {
            if (sticker[target.charAt(0) - 'a'] == 0) {
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < NUM_CHARS; j++) {
                if (tar[j] > 0) {
                    // build the remaining string
                    int iter = Math.max(0, tar[j] - sticker[j]);
                    for (int k = 0; k < iter; k++) {
                        sb.append((char) ('a' + j));
                    }
                }
            }
            String result = sb.toString();
            int next = solve(result, charsPerWord, dp);

            if (next != -1) {
                ans = Math.min(ans, next + 1);
            }
        }

        dp.put(target, ans != Integer.MAX_VALUE ? ans : -1);
        return dp.get(target);
    }
}
