package ctci.chapter5;

/**
 * 5.2 Print the binary representation of a number
 * between 0 and 1 in 32 characters max, else print "ERROR"
 */
public final class Question2 {

    public static String printBinRepresentation(double number) {
        if (number > 1 || number < 0) {
            return "ERROR";
        }

        StringBuilder result = new StringBuilder("0.");
        while (number > 0) {

            if (result.length() >= 32) {
                return "ERROR";
            }

            double temp = 2 * number;
            if (temp >= 1) {
                result.append("1");
                number = temp - 1; // get the next digit
            } else {
                result.append("0");
                number = temp;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            double num = i / 1000.0;
            String binary = printBinRepresentation(num);
            if (!binary.equals("ERROR")) {
                System.out.println(num + " : " + binary);
            }
        }

        // System.out.println(printBinRepresentation(.25));
    }
}
