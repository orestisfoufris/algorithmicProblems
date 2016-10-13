package EoPI.dynamicprogramming;


import java.util.*;

/**
 * Search for a sequence in a 2D array
 * 13/10/2016.
 */
public final class SearchSequence {

    public static boolean patternExists(List<List<Integer>> array, List<Integer> pattern) {
        Set<Point> explored = new HashSet<>();

        for (int i = 0; i < array.size(); ++i) {
            for (int j = 0; j < array.get(i).size(); ++j) {
                if (findPath(array, pattern, explored, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean findPath(List<List<Integer>> array, List<Integer> pattern, Set<Point> explored,
                                    int x, int y, int current) {

        if (pattern.size() == current) {
            return true;
        }

        if (x < 0 || x >= array.size() || y < 0 || y >= array.get(x).size() || explored.contains(new Point(x, y, current))) {
            return false;
        }

        if (array.get(x).get(y).equals(pattern.get(current)) &&
                (findPath(array, pattern, explored, x - 1, y, current + 1) ||
                findPath(array, pattern, explored, x, y - 1, current + 1) ||
                findPath(array, pattern, explored, x + 1, y, current + 1) ||
                findPath(array, pattern, explored, x, y + 1, current + 1))) {

            return true;
        }

        explored.add(new Point(x, y, current));
        return false;
    }

    private static class Point {
        int x;
        int y;
        int offset;

        Point(int x, int y, int offset) {
            this.x = x;
            this.y = y;
            this.offset = offset;

        }

        @Override
        public boolean equals(Object other) {
            return this == other
                    || !(other == null || getClass() != other.getClass())
                    && Objects.equals(this, other);
        }

        @Override
        public int hashCode(){
            return Objects.hash(x, y, offset);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", offset=" + offset +
                    '}';
        }
    }
}
