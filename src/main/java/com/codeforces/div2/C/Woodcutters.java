package com.codeforces.div2.C;

import java.io.*;
import java.util.InputMismatchException;

/**
 * @author Orestis
 * http://codeforces.com/problemset/problem/545/C
 */

public class Woodcutters {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int N = in.readInt();
        int[] X = new int[100005];
        int[] H = new int[100005];

        for (int i = 0; i < N; i++) {
            X[i] = in.readInt();
            H[i] = in.readInt();
        }

        out.print(solve(X, H, N));
        out.close();
    }

    private static int solve(int[] x, int[] h, int n) {
        int infinity = Integer.MIN_VALUE;
        int[][] dp = new int[n][2];

        dp[0][0] = 1; // 1st tree can always fell left
        dp[0][1] = x[0] + h[0] < x[1] ? 1 : Integer.MIN_VALUE; // and it might also be able to fell right

        for (int i = 1; i < n; ++i) {
            dp[i][0] = infinity;
            dp[i][1] = infinity;

            // can ith tree fell left?
            if (x[i - 1] < x[i] - h[i]) {
                dp[i][0] = dp[i - 1][0] + 1;
            }

            // is ith tree overlapping with previous tree
            // if prev has fallen right?
            if (x[i - 1] + h[i - 1] < x[i] - h[i]) {
                dp[i][0] = Math.max(dp[i][0], dp[i - 1][1] + 1);
            }

            dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);
            dp[i][0] = Math.max(dp[i][0], dp[i - 1][1]);

            // can ith tree fell right?
            if (i == n - 1 || x[i] + h[i] < x[i + 1]) {
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][0] + 1);
                dp[i][1] = Math.max(dp[i][1], dp[i - 1][1] + 1);
            }
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);

    }

    //FAST IO
    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1 << 10];
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