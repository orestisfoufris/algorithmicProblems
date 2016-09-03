package com.leetcode.math;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = f(slow);
            fast = f(f(fast)); // fast moves quicker so we will detect loops
            if (slow == 1) { return true; } // if no loop then slow will eventually become 1
        } while (slow != fast);

        return false;
    }

    private int f(int number) {
        int sum = 0;
        int tmp = 0;

        while (number > 0) {
            tmp = number % 10;
            sum += tmp * tmp;
            number /= 10;
        }

        return sum;
    }

}
