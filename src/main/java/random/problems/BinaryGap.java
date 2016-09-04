package random.problems;

/**
 * Codility BinaryGap problem
 */
public class BinaryGap {

    public int solution(int N) {
        if (Integer.bitCount(N) <= 1) {
            return 0;
        }

        int[] array = new int[35];

        int mask = 1;
        int last = 0;

        for (int i = 0; i < 33; ++i) {
            if ((N & mask) != 0) { // bit is set
                array[i] = i + 1;
                last = i + 1;
            }
            mask = mask << 1;
        }

        int max = 0;
        for (int i = array.length - 1; i >= 0; --i) {
            if (array[i] != 0) {
                max = Math.max(max, Math.abs(array[i] - last) - 1);
                last = array[i];
            }
        }

        return max;

    }

}
