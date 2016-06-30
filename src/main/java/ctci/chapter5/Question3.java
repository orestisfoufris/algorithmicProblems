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
            // System.out.println(Integer.toBinaryString(temp));
            zerosCount++;
            temp >>= 1;
        }

        // System.out.println(Integer.toBinaryString(temp));

        while ((temp & 1) == 1) {
            onesCount++;
            temp >>= 1;
        }

        int add = zerosCount + onesCount;

        if (add == 31 || add == 0) {
            return -1; // can't do it
        }

        number = add | (1 << add);
        number &= ~((1 << add) - 1);
        number |= (1 << (onesCount - 1)) - 1;

        return number;
    }

    public static void main(String[] args) {
        System.out.println(getLargest(5));
    }
}
