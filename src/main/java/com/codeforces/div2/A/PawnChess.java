package com.codeforces.div2.A;

import java.io.*;
import java.util.*;

/**
 * @author Orestis
 * http://codeforces.com/problemset/problem/592/A
 */

public class PawnChess {

    private static char solve(char[][] board) {

        Map<Integer, Boolean> As = new HashMap<>(8);
        Map<Integer, Boolean> Bs = new HashMap<>(8);
        for (int i = 0; i < 8; i++) {
            As.put(i, false);
            Bs.put(i, false);
        }

        int aIndex = Integer.MAX_VALUE;
        for (int i = 0; i < 8; i++) {
            if (aIndex != Integer.MAX_VALUE) { break;}
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'B') {
                    As.put(j, true);
                } else if (board[i][j] == 'W') {
                    if (As.get(j) != true) {
                        aIndex = i;
                        break;
                    }
                }
            }
        }

        int bIndex = Integer.MAX_VALUE;
        for (int i = 7; i > 0; i--) {
            if (bIndex != Integer.MAX_VALUE) { break;}
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'W') {
                    Bs.put(j, true);
                } else if (board[i][j] == 'B') {
                    if (Bs.get(j) != true) {
                        bIndex = 7 - i;
                        break;
                    }
                }
            }
        }

        if (aIndex == bIndex || aIndex < bIndex) {
            return 'A';
        }
        return 'B';
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        char[][] board = new char[8][8];

        for (int i = 0; i < 8; i++) {
            char[] n = in.readString().toCharArray();
            for (int j = 0; j < n.length; j++) {
                board[i][j] = n[j];
            }
        }
        out.print(solve(board));
        out.close();
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