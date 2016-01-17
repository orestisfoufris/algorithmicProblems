package random.problems;

import com.google.common.base.Stopwatch;

import java.io.*;
import java.util.*;

/**
 * @author Orestis
 * Facebook Hacker Cup 2016 Qalification round problem 1
 */

public class Boomerang {

    public static void main(String[] args) throws Exception {
        FileInputStream fileInStream =
                new FileInputStream("boomerang_constellations.txt");

        InputReader in = new InputReader(fileInStream);
        OutputWriter out = new OutputWriter(System.out);

        int T = in.readInt();
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < T; i++) {
            int N = in.readInt();

            List<Point> points = new ArrayList<>(N);
            for (int j = 0; j < N; j++) {
                points.add(new Point(in.readInt(), in.readInt()));
            }

            out.print("Case #" + (i+1) + ": " + solve(points) + "\n");
        }
        out.print(stopwatch.stop());
        out.close();
    }

    private static int solve(List<Point> points) {
        int[] boomerangs = new int[2000050];
        boomerangs[3] = 1;

        for (int i = 0; i < 2001; i++) {
            if (i > 3) {
                int nxt = boomerangs[i - 1] + (i - 2);
                boomerangs[i] = nxt;
            }
        }

        int result = 0;
        Map<Point, Map<Double, Integer>> distPerPoint = new HashMap<>();
        for (Point point : points) {
            Map<Double, Integer> occurMap = new HashMap<>();
            distPerPoint.put(point, occurMap);
            for (Point innerPoint : points) {
                if (!point.equals(innerPoint)) {
                    double d = findDistance(point, innerPoint);
                    if (occurMap.containsKey(d)) {
                        int times = occurMap.get(d);
                        times += 1;
                        occurMap.put(d, times);
                    } else {
                        occurMap.put(d, 1);
                    }
                }
            }
        }

        for (Map.Entry<Point, Map<Double, Integer>> entry : distPerPoint.entrySet()) {
            Map<Double, Integer> value = entry.getValue();
            for (Map.Entry<Double, Integer> p : value.entrySet()) {
                result += boomerangs[p.getValue() + 1];
            }
        }

        return result;
    }

    /**
     * find the distance between two points in a cartesian system
     */
    private static double findDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow((point2.x - point1.x), 2) + Math.pow((point2.y - point1.y), 2));
    }

    private static class Point {
        public final int x;
        public final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Objects.equals(x, point.x) &&
                    Objects.equals(y, point.y);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }



    //FAST IO
    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (numChars == -1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public double readDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, readInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public String next() {
            return readString();
        }

        public interface SpaceCharFilter {
            boolean isSpaceChar(int ch);
        }
    }

    private static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void print(Object... objects) {
            for (int i = 0; i < objects.length; i++) {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }

        public void printLine(Object... objects) {
            print(objects);
            writer.println();
        }

        public void close() {
            writer.close();
        }

        public void flush() {
            writer.flush();
        }

    }
}