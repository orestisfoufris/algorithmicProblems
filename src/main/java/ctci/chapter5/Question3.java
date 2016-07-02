package ctci.chapter5;

/**
 * 5.3 Given a positive integer, print the next smallest and the next largest
 * number that have the same number of bits and the same number of 1s in
 * their binary representation.
 */
public final class Question3 {

    public static int getLargest(int number) {
        int temp = number;
        int zerosCount = 0;
        int onesCount = 0;

        while((temp & 1) == 0 && temp != 0) {
            zerosCount++;
            temp >>= 1;
        }

        while ((temp & 1) == 1) {
            onesCount++;
            temp >>= 1;
        }

        int index = zerosCount + onesCount;

        if (index == 31 || index == 0) {
            return -1; // can't do it
        }

        number = index | (1 << index);
        number &= ~((1 << index) - 1);
        number |= (1 << (onesCount - 1)) - 1;

        return number;
    }

    public static int getSmallest(int number) {
        int temp = number;
        int zeros = 0;
        int ones = 0;

        // count ones
        while ((temp & 1) == 1) {
            ones++;
            temp = temp >> 1;
        }

        if (temp == 0) { // there was no trailing 1s
            return -1;
        }

        // count zeros
        while ((temp & 1) == 0 && temp != 0) {
            zeros++;
            temp = temp >> 1;
        }

        int index = zeros + ones;
        int mask = ((~0) << index + 1);
        number = number & mask; // clear ones from index until the end
        number = number | (1 << ones + 1) - 1;

        return number << (zeros - 1);
    }


    public static void main(String[] args) {
        System.out.println(getLargest(7));
        System.out.println(getSmallest(11) + "\n");

        System.out.println(getLargest(8));
        System.out.println(getSmallest(16) + "\n");

        System.out.println(getLargest(15));
        System.out.println(getSmallest(23) + "\n");
    }
}
