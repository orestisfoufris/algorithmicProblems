package com.hackerrank.algorithms.graphtheory;

import java.io.*;
import java.util.*;

/**
 * @author Orestis
 * https://www.hackerrank.com/challenges/the-quickest-way-up
 */

public class SnakesAndLadders {

    private static int solve(Map<Integer, List<Integer>> adjacentList) {
        int[] parents = new int[110];
        int[] distances = new int[110];
        int[] seen = new int[110];
        for (int i = 0; i < seen.length; i++) {
            seen[i] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        seen[1] = 2;
        parents[1] = -1;


        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (adjacentList.get(vertex) == null) {
                System.out.println(vertex);
            }
            adjacentList.get(vertex).stream().
                    forEach(integer -> {
                        if (seen[integer] == 1) {
                            seen[integer] = 2;
                            parents[integer] = vertex;
                            distances[integer] = distances[vertex] +  1;
                            queue.offer(integer);
                        }
                    });
            seen[vertex] = 3;
        }

        if (parents[100] == -1) {
            return -1;
        }
        return distances[100] - 1;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int T = in.readInt();
        for (int i = 0; i < T; i++) {
            Map<Integer, List<Integer>> adjacentList = new HashMap<>(100);
            for (int m = 1; m < 101; m++) {
                List<Integer> to = new ArrayList<>(6);
                for (int start = m + 1; start < m + 7 && start < 101; start++) {
                    to.add(start);
                }
                adjacentList.put(m, to);
            }

            int N = in.readInt();
            for (int j = 0; j < N; j++) {
                List<Integer> to = new ArrayList<>(1);
                int val = in.readInt();
                int key = in.readInt();
                to.add(key);

                adjacentList.put(val, to);
            }
            int M = in.readInt();
            for (int k = 0; k < M; k++) {
                List<Integer> to = new ArrayList<>(1);
                int val = in.readInt();
                int key = in.readInt();
                to.add(key);

                adjacentList.put(val, to);
            }

            out.print(solve(adjacentList) + "\n");
        }

        out.close();
    }

    //FAST IO
    private static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1<<10];
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