package ctci.chapter5;

/**
 * 5.1 You are given two 32-bit integers, N and M, and two bit positions, i and j.
 * Write a method to insert M into N such that M starts at bit j and ends at bit i.
 */
public final class Question1 {

    public static int insert(int N, int M, int i, int j) {
        N = clearBits(i, j, N);
        M = M << i;

        return N | M;
    }

    private static int clearBits(int i, int j, int number) {
        int leftMask = (-1 << (j + 1));
        int rightMask = ((1 << i) - 1);

        return number & (leftMask | rightMask);
    }

    public static void main(String[] args) {
        int result = insert(103217, 13, 4, 12);
        System.out.println(Helper.toFullBinaryString(result));
    }

    private static class Helper {
        private static String toFullBinaryString(int a) {
            String s = "";
            for (int i = 0; i < 32; i++) {
                Integer lsb = a & 1;
                s = lsb.toString() + s;
                a = a >> 1;
            }
            return s;
        }
    }

}
