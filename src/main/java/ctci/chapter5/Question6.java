package ctci.chapter5;

/**
 * 5.6 Write a program to swap odd and even bits in an integer with
 * as few instructions as possible.
 */
public final class Question6 {

    public static int swapOddAndEvenBits(int number) {
        return (((number & 0xaaaaaaaa) >> 1) | ((number & 0x55555555) << 1));
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(54));
        System.out.println(Integer.toBinaryString(swapOddAndEvenBits(54)));
    }
}
