package com.kattis;

import javax.annotation.Generated;
import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * https://open.kattis.com/problems/parking
 */
public class Parking {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        OutputWriter out = new OutputWriter(System.out);

        int A = in.readInt();
        int B = in.readInt();
        int C = in.readInt();

        TruckEvent[] sortedTruckEvents = new TruckEvent[6];
        int[] prices = {0, A, B * 2, C * 3};

        int index = 0;
        for (int i = 0; i < 3; ++i) {
            sortedTruckEvents[i + index] = new TruckEvent(in.readInt(), true);
            sortedTruckEvents[i + 1 + index] = new TruckEvent(in.readInt(), false);
            index++;
        }

        Arrays.sort(sortedTruckEvents);

        int result = 0;
        int truckCounter = 0;
        int currentTime = 0;
        for (int i = 0; i < sortedTruckEvents.length; ++i) {
            TruckEvent event = sortedTruckEvents[i];
            result += prices[truckCounter] * (event.getValue() - currentTime);
            truckCounter += event.getModifier();
            currentTime = event.getValue();
        }

        out.print(result);
        out.close();
    }

    // helper class
    private static class TruckEvent implements Comparable<TruckEvent> {
        final int value;
        final boolean isArriving;

        TruckEvent(int value, boolean isArriving) {
            this.value = value;
            this.isArriving = isArriving;
        }

        int getValue() {
            return value;
        }

        int getModifier() {
            return isArriving ? 1 : -1;
        }

        @Override
        public int compareTo(TruckEvent truckEvent) {
            return Integer.compare(value, truckEvent.value);
        }
    }

    /**
     * @param n number of primes to find
     * @return primes
     */
    @Generated("Primes")
    private static boolean[] findPrimes(int n) {
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true); // assume all are primes
        primes[0] = primes[1] = false;

        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (primes[i]) {
                for (int j = i * i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primes;
    }

    @Generated("GCD")
    private static long gcd(long a, long b) {
        if (b == 0 || a == b) {
            return a;
        }

        return gcd(b, a % b);
    }

    //FAST IO
    @Generated("Fast IO")
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