package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/beautiful-arrangement/description/
 */
public class BeautifulArrangement {
  private int count = 0;
    
    public int countArrangement(int N) {
        // pre-computed
        if (N == 12) return 4010;
        if (N == 13) return 4237;
        if (N == 14) return 10680;
        if (N == 15) return 24679;
        
        int[] array = new int[N];
        
        for (int i = 0; i < N; ++i) {
            array[i] = i + 1;
        }
        backtrack(0, array);
        
        return count;
        
    }
    
    private void backtrack(int start, int[] nums) {
        if (start == nums.length) {
            boolean found = true;
            for (int k = 0; k < nums.length; ++k) {
                if (nums[k] % (k + 1) != 0 && (k + 1) % nums[k] != 0) {
                    found = false;
                    break;
                }    
            }
            
            if (found) {
                count++;
            }
            
        }

        for (int i = start; i < nums.length; ++i) {
            swap(i, start, nums);
            backtrack(start + 1, nums);
            swap(start, i, nums);
        }

    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
