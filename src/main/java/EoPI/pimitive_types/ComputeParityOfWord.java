package EoPI.pimitive_types;

public class ComputeParityOfWord {

    // the parity of a binary word is 1 if the number of 1s is odd
    // otherwise it is 0
    public static short computeParity(long x) {
        long mask = 1;
        int count = 0;

        while (mask > 0) {
            if ((mask & x) > 0) {
                count++;
            }
            mask <<= 1;
        }

        count += x >= 0 ? 0 : 1;

        return (short) (count % 2 == 0 ? 0 : 1);
    }
}
