package com.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/#/description
 */
public class MinimumNumberOfArrowsToBurstBalloons {

    public int findMinArrowShots(int[][] points) {
        List<Balloon> balloons = new ArrayList<>();

        for (int[] b : points) {
            balloons.add(new Balloon(b[0], b[1]));
        }

        if (balloons.size() == 0) { return 0; }
        Collections.sort(balloons);
        int arrows = 1;

        Balloon first = balloons.get(0);
        int pe = first.end;

        for (int i = 1; i < balloons.size(); ++i) {
            Balloon c = balloons.get(i);

            if(c.start <= pe) {
                pe = Math.min(pe, c.end);
            } else {
                arrows++;
                pe = c.end;
            }
        }

        return arrows;

    }

    private static class Balloon implements Comparable<Balloon>{
        final int start;
        final int end;

        Balloon(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Balloon o) {
            int start = Integer.compare(this.start, o.start);
            return start != 0 ? start : Integer.compare(this.end, o.end);
        }
    }

}
