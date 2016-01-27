package com.hackerrank.algorithms.greedy;

import java.io.*;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

/**
 * @author Orestis
 * https://www.hackerrank.com/challenges/board-cutting
 */
public class CuttingBoards {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int T = in.readInt();
        for (int k = 0; k < T; ++k) {
            int m = in.readInt(); // y height
            int n = in.readInt(); // x width

            int[] Ys = new int[m - 1];
            int[] Xs = new int[n - 1];
            for (int i = 0; i < m - 1; ++i) {
                Ys[i] = in.readInt();
            }
            for (int i = 0; i < n - 1; ++i) {
                Xs[i] = in.readInt();
            }

            mergeSort(Ys);
            mergeSort(Xs);
            Queue<Integer> x = new LinkedList<>();

            Queue<Integer> y = new LinkedList<>();
            for (int i = 0; i < m - 1; ++i) {
                y.offer(Ys[i]);
            }
            for (int i = 0; i < n - 1; ++i) {
                x.offer(Xs[i]);
            }
            long result = solve(y, x);
            out.print(result + "\n");
        }

        out.close();
    }

    private static long solve(Queue<Integer> Ys, Queue<Integer> Xs) {
        long xCounter = 1;
        long yCounter = 1;

        long sum = 0;
        while (Ys.peek() != null || Xs.peek() != null) {
            long x = Xs.peek() != null ? Xs.peek() : Integer.MIN_VALUE;
            long y = Ys.peek() != null ? Ys.peek() : Integer.MIN_VALUE;

            if (y > x) {
                sum += Ys.poll() * yCounter;
                xCounter++;
            } else if (y < x) {
                sum += Xs.poll() * xCounter;
                yCounter++;
            } else if (y == x) {
                sum += Xs.poll() * xCounter;
                yCounter++;
            }
        }

        return (sum % 1000000007);
    }

    public static void mergeSort(int[] a) {
        int[] tmp = new int[a.length];
        mergeSort(a, tmp, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center + 1, right);
        }
    }

    private static void merge(int[] a, int[] tmp, int left, int right, int rightEnd) {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while (left <= leftEnd && right <= rightEnd) {
            if (a[left] > a[right]) {
                tmp[k++] = a[left++];
            } else {
                tmp[k++] = a[right++];
            }
        }

        while (left <= leftEnd) // Copy rest of first half
        {
            tmp[k++] = a[left++];
        }

        while (right <= rightEnd) // Copy rest of right half
        {
            tmp[k++] = a[right++];
        }

        // Copy tmp back
        for (int i = 0; i < num; i++, rightEnd--) {
            a[rightEnd] = tmp[rightEnd];
        }
    }

    private static class Pair implements Comparable<Pair> {

        private final int index;
        private final int value;

        private Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.equals(other)) {
                return 0;
            }

            if (this.value == other.value) {
                return Integer.compare(this.index, other.index);
            } else {
                return Integer.compare(this.value, other.value);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(index, pair.index) &&
                    Objects.equals(value, pair.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, value);
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
