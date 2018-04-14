package com.googlecodejam.year_2018.qualification;

import java.io.*;
import java.util.InputMismatchException;

/**
 * @author Orestis
 */

public class SavingTheUniverseAgain {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int i = 0;
        int T = in.readInt();
        while (T-- > 0) {
            int shield = in.readInt();
            String instructions = in.readString();

            out.print("Case #" + (i+1) + ": " + solve(shield, instructions.toCharArray()) + "\n");
            i++;
        }

        out.close();
    }

    private static String solve(int shield, char[] instructions) {
        int totalDamage = determineTotalDamage(instructions);
        int totalMoves = 0;

        if (totalDamage <= shield) {
            return String.valueOf(totalMoves);
        }

        char[] s = removeCsFromInstructions(instructions);

        for (int i = s.length - 1; i >= 0; --i) {
            if (s[i] == 'S' && i > 0 && s[i - 1] == 'C') {
                swap(s, i, i - 1);
                totalMoves++;

                if (i + 2 <= s.length) {
                    i += 2;
                }

            }

            if (shield >= determineTotalDamage(s)) {
                return String.valueOf(totalMoves);
            }
        }

        return "IMPOSSIBLE";
    }

    private static void swap(char[] s, int x, int y) {
        char temp = s[x];
        s[x] = s[y];
        s[y] = temp;
    }

    private static char[] removeCsFromInstructions(char[] instructions) {
        int firstS = 0;

        for (int i = instructions.length - 1; i >= 0; --i) {
            if (instructions[i] == 'S') {
                firstS = i;
                break;
            }
        }

        if (firstS == instructions.length - 1) {
            return instructions;
        }

        char[] res = new char[firstS + 1];

        System.arraycopy(instructions, 0, res, 0, res.length);

        return res;
    }

    private static int determineTotalDamage(char[] instructions) {
        int result = 0;
        int multiplier = 1;

        for (char c : instructions) {
            if (c == 'S') {
                result += multiplier;
            } else if (c == 'C') {
                multiplier *= 2;
            }
        }

        return result;
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