package com.codeforces.div2.B;

import java.io.*;
import java.util.*;

/**
 * @author Orestis
 * http://codeforces.com/problemset/problem/599/B
 */

public class SpongebobJoke {

    private static Pair solve(List<Integer> f, List<Integer> b) {
        Map<Integer, Integer> fIndexes = new HashMap<>();
        for (int i = 0; i < f.size(); i++) {
            fIndexes.put(f.get(i), i + 1);
        }

        Map<Integer, Integer> mapping = new HashMap<>();
        Map<Integer, Integer> res = new TreeMap<>();
        String answer = "Possible";
        for (int i = 0; i < b.size(); i++) {
            if (mapping.containsKey(b.get(i))) {
                Integer value = mapping.get(b.get(i));
                if (value.equals(f.get(i))) {
                    answer = "Ambiguity";
                } else  {
                    return new Pair("Impossible", null);
                }
            } else {
                mapping.put(b.get(i), f.get(i));
                res.put(b.get(i), fIndexes.get(b.get(i)));
            }
        }
//        System.out.println("Result: " + res);
//        System.out.println("F: " + fIndexes);
        return new Pair(answer, res);
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int n = in.readInt();
        int m = in.readInt();

        List<Integer> f = new ArrayList<>(n);
        List<Integer> b = new ArrayList<>(m);

        for (int i = 0; i < n; i++) {
            f.add(in.readInt());
        }

        for (int i = 0; i < m; i++) {
            b.add(in.readInt());
        }

        Pair result = solve(f, b);
        out.print(result.answer + "\n");
        if (Objects.equals(result.answer, "Possible")) {
            StringBuilder sb = new StringBuilder();
            for (Integer i : b) {
                sb.append(result.sequence.get(i));
                sb.append(" ");
            }
            out.print(sb.toString());
        }
        out.close();
    }

    private static class Pair {
        public final String answer;
        public final Map<Integer, Integer> sequence;

        private Pair(String answer, Map<Integer, Integer> sequence) {
            this.answer = answer;
            this.sequence = sequence;
        }
    }
//    10 9
//    1 2 3 4 5 6 7 8 9 10
//    10 9 8 7 6 5 4 3 2
    
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